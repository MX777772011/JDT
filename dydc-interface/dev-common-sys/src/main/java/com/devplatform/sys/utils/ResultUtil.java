package com.devplatform.sys.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.devplatform.common.utils.HtmlUtil;
import com.devplatform.sys.action.BaseAction;
import com.devplatform.sys.constant.ResultCodeEnum;


public class ResultUtil {
	
	public static void sendJsonData(HttpServletResponse response, boolean isSuccess, String code, String msg, Object data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(BaseAction.SUCCESS, isSuccess);
		result.put(BaseAction.MSG, msg);
		result.put(BaseAction.CODE, code);
		if (data instanceof String) {
			 data = returnJsonMap(data.toString());
		}
		if(data == null){
			data =new HashMap<String,Object>();
		}
		result.put(BaseAction.DATA, data);
		System.out.println(result);
		HtmlUtil.writerJson(response, result);
	}
	public static void sendJsonData(HttpServletResponse response, boolean isSuccess, ResultCodeEnum code, Object data) {
		sendJsonData(response, isSuccess, code.key, code.value, data);
	}

	@SuppressWarnings("unchecked")
	public static Map<String,String> returnJsonMap(String str){
		return JSONObject.fromObject(str);
	}
	
}
