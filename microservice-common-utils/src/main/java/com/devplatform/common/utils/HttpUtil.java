package com.devplatform.common.utils;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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
		try {
			HttpPost httpRequst = new HttpPost(url);
			StringEntity entity = new StringEntity(body, charset);
			httpRequst.setEntity(entity);
			httpRequst.setHeader("Content-Type", "application/json;charset=utf-8");
			HttpResponse httpResponse = HttpClients.createDefault().execute(httpRequst);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.err.println(EntityUtils.toString(httpResponse.getEntity()));
				throw new CustomException(httpResponse.getStatusLine().getStatusCode() + "");
			}
			return EntityUtils.toString(httpResponse.getEntity());
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
			throw new CustomException("402");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CustomException("402");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException("402");
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
		try {
			HttpPost httpRequst = new HttpPost(url);
			StringEntity entity = new StringEntity(body, charset);
			httpRequst.setEntity(entity);
			httpRequst.setHeader("Content-Type", "application/json;charset=utf-8");
			HttpResponse httpResponse = HttpClients.createDefault().execute(httpRequst);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				System.err.println(EntityUtils.toString(httpResponse.getEntity()));
				throw new CustomException(httpResponse.getStatusLine().getStatusCode() + "");
			}
			return EntityUtils.toString(httpResponse.getEntity());
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
			throw new CustomException("402");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CustomException("402");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException("402");
		}
	}

}
