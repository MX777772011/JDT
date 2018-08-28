package com.devplatform.sso.constant;

public enum SSOResutlConstant {

	COMMON_SUCCESS("200", "请求成功"), COMMON_FAILED("100500", "请求失败"),

	LOGIN_FAILED_NULL("101001", "用户名、密码不能为空"),
	LOGIN_FAILED_NOUSER("101002", "没有找到该用户"),
	LOGIN_FAILED_UNUSE("101003", "该用户已经被禁用"),
	LOGIN_FAILED_ERRPWD("101004", "密码错误"),

	// QINIU_UPLOAD_ERRPR("3001","文件上传七牛云是出错"),

	;

	public String key;
	public String value;

	private SSOResutlConstant(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public static SSOResutlConstant get(String key) {
		SSOResutlConstant[] values = SSOResutlConstant.values();
		for (SSOResutlConstant object : values) {
			if (object.key.equals(key)) {
				return object;
			}
		}
		return null;
	}

}
