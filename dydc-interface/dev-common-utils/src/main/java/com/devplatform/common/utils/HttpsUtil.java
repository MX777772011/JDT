package com.devplatform.common.utils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpsUtil {

	private static final String CONTENT_TYPE = "Content-Type";
	private static final String ACCEPT = "Accept";
	private static final String APPLICATION_JSON = "application/json";


	public static void main(String[] args) {
		String s = doPostSSL("https://testsso.unipus.cn/sso/1.0/sso/put_phone_code", "{\"phone\":\"13661386395\",\"linkType\":0}");
		System.out.println(s);
	}

	private static final String DEFAULT_ENDCODING = "UTF-8";


	public static String doPostSSL(String apiUrl, Object json) {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).build();
		HttpPost request = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;
		String result = null;

		try {
			request.setHeader(CONTENT_TYPE, APPLICATION_JSON);
			request.setHeader(ACCEPT, APPLICATION_JSON);
			StringEntity stringEntity = new StringEntity(json.toString(), DEFAULT_ENDCODING);// 解决中文乱码问题
			request.setEntity(stringEntity);
			response = httpClient.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				System.out.println(EntityUtils.toString(response.getEntity(), DEFAULT_ENDCODING));
				throw new CustomException("没有正确调用远程接口",response.getStatusLine().getStatusCode() + "");
			}
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				throw new CustomException("没有获得返回","402");
			}
			result = EntityUtils.toString(entity, DEFAULT_ENDCODING);
			System.out.println(result);
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(),e.getErrCode());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(),"402");
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 创建SSL安全连接
	 * 
	 * @return
	 */
	private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
		SSLConnectionSocketFactory sslsf = null;
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}

				@Override
				public void verify(String host, SSLSocket ssl) throws IOException {
				}

				@Override
				public void verify(String host, X509Certificate cert) throws SSLException {
				}

				@Override
				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
				}
			});
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return sslsf;
	}

}