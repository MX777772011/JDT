package com.devplatform.common.utils;

import com.devplatform.common.annotation.AuthCustom;

public class CloneTestBean {
	private static final String static_final_String = "123";
	private static  String static_String ;
	
	
	@AuthCustom(field = ("pws"))
	private String userName;
	
	@AuthCustom(field = ("userName"))
	private String pws;
	
	private Integer order;
	
	
	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPws() {
		return pws;
	}
	public void setPws(String pws) {
		this.pws = pws;
	}
	public static String getStatic_String() {
		return static_String;
	}
	public static void setStatic_String(String static_String) {
		CloneTestBean.static_String = static_String;
	}
	private String s;
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public static String getStaticFinalString() {
		return static_final_String;
	}
	public String toString() {
		return "CloneTestBean [userName=" + userName + ", pws=" + pws + ", order=" + order + ", s=" + s + "]";
	}
}
