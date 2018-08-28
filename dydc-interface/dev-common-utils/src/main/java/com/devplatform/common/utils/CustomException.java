package com.devplatform.common.utils;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1958246937922915228L;

	private String errCode;

	public CustomException(String msg, String errCode) {
		super(msg);
		this.errCode = errCode;
	}

	public CustomException(String msg, Throwable obj, String errCode) {
		super(msg, obj);
		this.errCode = errCode;
	}

	/**
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode == null ? "AAAA" : errCode;
	}

	public CustomException() {
		super();
	}

	public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

}