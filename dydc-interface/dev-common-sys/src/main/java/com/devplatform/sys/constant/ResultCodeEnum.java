package com.devplatform.sys.constant;


public enum ResultCodeEnum {
	
	COMMON_SUCCESS("0", "请求成功"), 
	COMMON_FAILED("AAAA", "请求失败"), 
	ERROR_REQUEST_TYPE("0003","请求类型不正确"),
	BAD_REQUEST("0002","缺少请求参数"),
	UN_LOGIN("0001", "未登录，请先登录"),

	LACK_PARAMETER1("0002","缺少用户ID"),
	LACK_PARAMETER2("0002","缺少试题ID"),
	LACK_PARAMETER3("0002","缺少陪练类型"),
	LACK_PARAMETER4("0002","缺少匹配类型"),
	LACK_PARAMETER5("0002","缺少匹配时间"),
	
	ROOM_RESULT("R001","未找到该房间"),
	
	UPLOAD_FILE_TYPE_ERROR("E0012", "文件格式不正确"), 
	UPLOAD_FILE_NOTEXSIT("E0013", "上传文件不存在"), 
	
	BOOK_CODE_TYPE_ERROR("E0014", "验证码与激活模块不一致"), 

	EMAIL_FORMAT_ERROR("E001", "邮箱格式不正确"), 
	PHONE_FORMAT_ERROR("E002", "手机格式不正确"), 
	IDNO_FORMAT_ERROR("E003", "身份证格式不正确"), 
	NUMBER_FORMAT_ERROR("E004", "邮箱格式不正确"), 
	STRING_MINLENGTH_ERROR("E005", "邮箱格式不正确"), 
	STRING_MAXLENGTH_ERROR("E006", "邮箱格式不正确"), 
	STRING_NOT_NULL("E007", "邮箱格式不正确"), 
	LONGER_NOT_LENGTH("E008", "大于最大长度"), 
	SHORTER_NOT_LENGTH("E009", "小于最小长度"), 
	GREATER_MAX("E0010", "大于最大值"), 
	LESSER_MIN("E0011", "小于最小值"), 

	MATCH_NO_RESULT("M001", "暂时没有匹配到用户，请耐心等待。"), 
	INVITE_MATCH_NO_RESULT("M002", "用户已和其他小伙伴匹配"), 
	
	REG_ERR_NO_USERNAME("RE1001","请填写用户名"),
	REG_ERR_NO_PHONE("RE1102","请填写手机号"),
	REG_ERR_CODE_ERROR("RE1108","验证码错误，try again"),
	REG_ERR_CODE_OUT("RE1501","验证码已过期"),
	REG_ERR_PHONE_FORMATERR("RE1105","手机号格式有误,请输入11位手机号"),
	REG_ERR_NO_EMAIL("RE1301","请填写邮箱"),
	REG_ERR_EMAIL_FORMATERR("RE1302","邮箱格式错误"),
	REG_ERR_PHONE_EXISTA("RE1103","该手机号已注册过嘤嘤嘤"),
	REG_ERR_PHONE_EXISTB("RE1104","该手机号已注册过嘤嘤嘤"),
	REG_ERR_EMAIL_EXISTA("RE1303","邮箱已经激活"),
	REG_ERR_EMAIL_EXISTB("RE1305","邮箱已经注册，但是未激活"),
	REG_ERR_NO_PASSWORD("RE1201","密码必须是6-16位数字字母组合"),
	REG_ERR_PASSWORD_FORMATERR("RE1202","密码必须是6-16位数字字母组合"),
	REG_ERR_NO_NICKNAME("RE1401","昵称为2-16位字符串哦！"),
	REG_ERR_NICKNAME_FORMATERR("RE1402","昵称为2-16位字符串哦！"),
	REG_ERR_NICKNAME_EXIST("RE1403","昵称已经被占用，请选择一个新的昵称"),
	REG_ERR_NICKNAME_EXIST1("RE1404","昵称包含特殊字符，请输入有效昵称"),
	REG_ERR_PHONE_INEXISTENCE("RE1105","手机号不存在"),

	LOGIN_NO_USERNAME("LE1001","请填写用户名"),
	LOGIN_NO_PASSWORD("LE1201","密码必须是6-16位数字字母组合"),
	LOGIN_NO_ERR_USERNAME_AND_PASSWORD("LE2012","账号密码不匹配呀！"),

	QINIU_UPLOAD_ERRPR("3001","文件上传七牛云是出错"),
	
	;
	
	
	public String key;
	public String value;

	
	private ResultCodeEnum(String key,String value){
		this.key=key;
		this.value= value;
	}
	
	public static ResultCodeEnum get(String key){
		ResultCodeEnum[] values = ResultCodeEnum.values();
		for (ResultCodeEnum object : values) {
			if (object.key.equals(key)) {
				return object;
			}
		}
		return null;
	}
	
	
}
