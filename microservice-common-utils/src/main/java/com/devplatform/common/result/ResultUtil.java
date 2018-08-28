package com.devplatform.common.result;

public class ResultUtil {

	private static CommonResult commonResult(String code, String msg, Object data) {
		CommonResult cr = new CommonResult();
		cr.setCode(code);
		cr.setMsg(msg);
		cr.setData(data);
		return cr;
	}

	public static CommonResult getSuccess() {
		return getSuccess(null);
	}

	public static CommonResult getSuccess(Object data) {
		return getSuccess("请求成功", data);
	}

	public static CommonResult getSuccess(String msg, Object data) {
		return commonResult("200", msg, data);
	}

	public static CommonResult getCommonFailed() {
		return getFailed("500", "请求失败");
	}

	public static CommonResult getFailed(String code, String msg) {
		return getFailed(code, msg, null);
	}

	public static CommonResult getFailed(String code, String msg, Object data) {
		return commonResult(code, msg, data);
	}
}
