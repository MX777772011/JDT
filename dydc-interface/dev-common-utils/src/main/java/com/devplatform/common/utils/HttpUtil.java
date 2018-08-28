package com.devplatform.common.utils;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * http接口调用工具类
 * 
 * @author liyinchu
 *
 */
public class HttpUtil {

	/**
	 * 将请求的数据以json的形式发给服务器，返回json字符串,默认编码为UTF-8
	 * 
	 * @param url
	 * @param body
	 * @return
	 */
	public static String postJSON(String url, String body) {
		return postJSON(url, body, "UTF-8");
	}

	/**
	 * 以post方式将请求的数据以json的形式发给服务器，返回json字符串
	 * 
	 * @param url
	 *            接口http地址
	 * @param body
	 *            请求的json字符串
	 * @param charset
	 *            字符编码
	 * @return
	 */
	public static String postJSON(String url, String body, String charset) {
		HttpResponse httpResponse = null;
		try {
			HttpPost httpRequst = new HttpPost(url);
			StringEntity entity = new StringEntity(body, charset);
			httpRequst.setEntity(entity);
			httpRequst.setHeader("Content-Type", "application/json;charset=utf-8");
			httpResponse = HttpClients.createDefault().execute(httpRequst);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.err.println(EntityUtils.toString(httpResponse.getEntity()));
				throw new CustomException("没有正确调用远程接口",httpResponse.getStatusLine().getStatusCode() + "");
			}
			return EntityUtils.toString(httpResponse.getEntity());
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		}
	}

	/**
	 * 以get方式将请求的数据以json的形式发给服务器，返回json字符串
	 * 
	 * @param url
	 *            接口http地址
	 * @param body
	 *            请求的json字符串
	 * @param charset
	 *            字符编码
	 * @return
	 */
	public static String getJSON(String url, String body, String charset) {
		HttpResponse httpResponse = null;
		try {
			HttpPost httpRequst = new HttpPost(url);
			StringEntity entity = new StringEntity(body, charset);
			httpRequst.setEntity(entity);
			httpRequst.setHeader("Content-Type", "application/json;charset=utf-8");
			httpResponse = HttpClients.createDefault().execute(httpRequst);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.err.println(EntityUtils.toString(httpResponse.getEntity()));
				throw new CustomException("没有正确调用远程接口",httpResponse.getStatusLine().getStatusCode() + "");
			}
			return EntityUtils.toString(httpResponse.getEntity());
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		}
	}

	public static String postForm(String url, String charset, List<HttpHeader> heads, List<NameValuePair> forms) {
		HttpResponse httpResponse =null;
		try {
			HttpPost httpRequst = new HttpPost(url);
			if (heads != null) {
				for (HttpHeader head : heads) {
					httpRequst.setHeader(head.getKey(), head.getValue());
				}
			}
			HttpEntity entity = new UrlEncodedFormEntity(forms, charset);
			httpRequst.setEntity(entity);
			httpResponse = HttpClients.createDefault().execute(httpRequst);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.err.println(EntityUtils.toString(httpResponse.getEntity()));
				throw new CustomException("没有正确调用远程接口",httpResponse.getStatusLine().getStatusCode() + "");
			}
			return EntityUtils.toString(httpResponse.getEntity());
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		}

	}

	
	public static String getJSON(String url){
		HttpGet getRequst = new HttpGet(url);
		HttpResponse httpResponse =null;
		try {
			httpResponse = HttpClients.createDefault().execute(getRequst);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.err.println(EntityUtils.toString(httpResponse.getEntity()));
				throw new CustomException("没有正确调用远程接口",httpResponse.getStatusLine().getStatusCode() + "");
			}
			return EntityUtils.toString(httpResponse.getEntity());
		}  catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), httpResponse == null ? "402":""+httpResponse.getStatusLine().getStatusCode());
		}
	}
	
}
