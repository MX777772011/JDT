package com.devplatform.common.utils.json;

import net.sf.json.JSONObject;

/**
 * 
 * 
 * JSON字符串转换工具类
 * 
 * @author liyinchu
 */
public class JSONConvertUtil {

	/**
	 * JSON字符串转bean
	 * 
	 * @param source
	 *            要转换的字符串
	 * @param beanClass
	 *            要转成什么类型的javaBean
	 * @return Object对象，需要强制类型转换。
	 */
	public static Object getObjectFromJSONString(String source, Class<?> beanClass) {
		JSONObject jsonObject = JSONObject.fromObject(source);
		Object bean = JSONObject.toBean(jsonObject, beanClass);
		return bean;
	}

	public static String getStringFromObject(Object source) {
		JSONObject jo = JSONObject.fromObject(source);
		return jo.toString();
	}

	public static void main(String[] args) {
		SampleBean a = new SampleBean();
		a.setPassword("123");
		a.setUsername("abc");
		String s = getStringFromObject(a);
		System.out.println(s);
		Object o = getObjectFromJSONString(s, SampleBean.class);
		System.out.println(o);
		System.out.println((SampleBean) o);

	}
}
