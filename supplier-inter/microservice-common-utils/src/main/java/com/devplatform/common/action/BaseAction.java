package com.devplatform.common.action;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.devplatform.common.custom.DateEditor;
import com.devplatform.common.custom.MyEditor;


public class BaseAction {

	@Autowired
	public HttpServletRequest request;
	@Autowired
	public HttpServletResponse response;
	
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

	

}
