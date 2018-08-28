package com.devplatform.business.utils;


import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static JsonUtil json = null;
	private ObjectMapper mapper = null;

	private JsonUtil() {
		mapper = new ObjectMapper();
	}

	public static JsonUtil getInstance() {
		if (json == null) {
			json = new JsonUtil();
		}
		return json;
	}

	public static ObjectMapper getObjectMapper() {
		return JsonUtil.getInstance().mapper;
	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param pojoCalss
	 * @return
	 */
	public static Object getObjectFromJsonString(String jsonString,
			Class pojoCalss) {

		Object pojo = null;
		try {
			pojo = getObjectMapper().readValue(jsonString, pojoCalss);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pojo;
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param javaObj
	 * @return
	 */
	public static String getJsonStringFromObject(Object javaObj) {
		StringWriter jsonStr = new StringWriter();
		try {
			getObjectMapper().writeValue(jsonStr, javaObj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonStr.toString();
	}
	/**
	 * list对象转换成json字符串
	 * @param list
	 * @return
	 */
	public static String getJsonStringFromList(List list){
		String jsonStr = "";
		try {
			jsonStr = getObjectMapper().writeValueAsString(list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonStr;
	}

	public static void main(String[] args) throws Exception {
		 
		
		
	}
}
