package com.devplatform.common.exception;

public enum ExceptionEnum {

	UNKNOW_ERROR("-1", "未知错误"), USER_NOT_FIND("-2", "用户不存在");

	private String code;

	private String msg;

	ExceptionEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
