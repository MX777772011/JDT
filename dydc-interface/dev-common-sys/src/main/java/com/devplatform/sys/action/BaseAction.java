package com.devplatform.sys.action;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.devplatform.common.utils.HtmlUtil;
import com.devplatform.common.utils.URLUtils;
import com.devplatform.sys.edit.DateEditor;
import com.devplatform.sys.edit.MyEditor;

public class BaseAction {

	public final static String SUCCESS = "success";

	public final static String MSG = "msg";

	public final static String DATA = "data";
	
	public final static String CODE = "code";

	public final static String LOGOUT_FLAG = "logoutFlag";
	@Autowired(required=false)
	public HttpServletRequest request;
	@Autowired(required=false)
	public HttpServletResponse response;
	
	public PropertyEditorSupport getDatePes() {
		return datePes;
	}

	public void setDatePes(PropertyEditorSupport datePes) {
		this.datePes = datePes;
	}

	public PropertyEditorSupport getIntPes() {
		
		return intPes;
	}

	public void setIntPes(PropertyEditorSupport intPes) {
		this.intPes = intPes;
	}

	public static String getLogoutFlag() {
		return LOGOUT_FLAG;
	}

	private PropertyEditorSupport datePes;
	private PropertyEditorSupport  intPes;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,new DateEditor()); 
		binder.registerCustomEditor(int.class, new MyEditor());
	}

	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 所有ActionMap 统一从这里获取
	 * 
	 * @return
	 */
	public Map<String, Object> getRootMap() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		// 添加url到 Map中
		rootMap.putAll(URLUtils.getUrlMap());
		return rootMap;
	}

	public ModelAndView forword(String viewName, Map<String, Object> context) {
		return new ModelAndView(viewName, context);
	}

	public ModelAndView error(String errMsg) {
		return new ModelAndView("error");
	}

	/**
	 * 
	 * 提示成功信息
	 * 
	 * @param message
	 * 
	 */
	public void sendSuccessMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		HtmlUtil.writerJson(response, result);
	}
	public void sendSuccessMessage(HttpServletResponse response, String message,String data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		result.put(DATA, data);
		HtmlUtil.writerJson(response, result);
	}

	/**
	 * 
	 * 提示失败信息
	 * 
	 * @param message
	 * 
	 */
	public void sendFailureMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		HtmlUtil.writerJson(response, result);
	}
	

//	/**
//	 * 
//	 *公共異常信息
//	 * 
//	 * @param message
//	 * 
//	 */
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	public ModelAndView handleException(Exception ex, HttpServletRequest request) {
//
//		return new ModelAndView().addObject("error", "错误信息");
//
//	}
}
