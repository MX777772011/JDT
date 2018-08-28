package com.devplatform.common.utils;

public class HttpHeader {

	
	public String toString() {
		return "HttpHeader [key=" + key + ", value=" + value + "]";
	}

	private String key ;
	
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HttpHeader(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public HttpHeader() {
		super();
	}
	

	
	
}
