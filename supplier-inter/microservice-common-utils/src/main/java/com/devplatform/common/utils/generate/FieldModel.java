package com.devplatform.common.utils.generate;

import com.devplatform.common.utils.CustomException;

/**
 * 
 * @author liyinchu
 *
 */
public class FieldModel {
	/**
	 * 字段名称
	 */
	private String fieldName;
	/**
	 * java字段名称
	 */
	private String fieldJavaName;
	/**
	 * 字段备注
	 */
	private String fieldRemark;
	/**
	 * 字段类型
	 */
	private String fieldType;
	/**
	 * 字段类型
	 */
	private String fieldJavaType;
	/**
	 * 可否为null
	 */
	private String canBeNull;
	/**
	 * 最大长度
	 */
	private Integer maxLength;
	/**
	 * 最新长度
	 */
	private Integer minLength;
	/**
	 * 是否邮箱
	 */
	private String isEmail;
	/**
	 * 是否手机号
	 */
	private String isMobile;
	
	private String isIdNo;
	/**
	 * 正则表达式
	 */
	private String regexString;
	/**
	 * 枚举值
	 */
	private String enumString;
	/**
	 * java类的get方法的名称
	 */
	private String getMethodName;
	
	/**
	 * java类的set方法的名称
	 */
	private String setMethodName;
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldRemark() {
		fieldRemark = fieldRemark.replaceAll("\n", "").replaceAll("\r", "");
		return fieldRemark;
	}
	public void setFieldRemark(String fieldRemark) {
		this.fieldRemark = fieldRemark;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getCanBeNull() {
		return canBeNull;
	}
	public void setCanBeNull(String canBeNull) {
		this.canBeNull = canBeNull;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public String toString() {
		return "FieldModel [fieldName=" + fieldName + ", fieldJavaName=" + fieldJavaName + ", fieldRemark=" + fieldRemark + ", fieldType=" + fieldType + ", canBeNull=" + canBeNull + ", maxLength=" + maxLength + ", minLength=" + minLength + ", isEmail=" + isEmail + ", isMobile=" + isMobile
				+ ", isIdNo=" + isIdNo + ", regexString=" + regexString + ", enumString=" + enumString + "]";
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	public String getIsEmail() {
		return isEmail;
	}
	public void setIsEmail(String isEmail) {
		this.isEmail = isEmail;
	}
	public String getIsMobile() {
		return isMobile;
	}
	public void setIsMobile(String isMobile) {
		this.isMobile = isMobile;
	}
	public String getRegexString() {
		return regexString;
	}
	public void setRegexString(String regexString) {
		this.regexString = regexString;
	}
	public String getEnumString() {
		return enumString;
	}
	public void setEnumString(String enumString) {
		this.enumString = enumString;
	}
	public String getFieldJavaName() {
		if(fieldName!=null){
			StringBuffer sb = new StringBuffer(fieldName.length());
			String tableNew = fieldName.toLowerCase();
			String[] tables = tableNew.split("_");
			String temp = null;
			for (int i = 0; i < tables.length; i++) {
				temp = tables[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			fieldJavaName = sb.toString();
			fieldJavaName = fieldJavaName.substring(0, 1).toLowerCase()+fieldJavaName.substring(1);
		}
		return fieldJavaName;
	}
	public void setFieldJavaName(String fieldJavaName) {
		this.fieldJavaName = fieldJavaName;
	}
	public String getIsIdNo() {
		return isIdNo;
	}
	public void setIsIdNo(String isIdNo) {
		this.isIdNo = isIdNo;
	}
	public String getFieldJavaType() {
		if(GeneratorConstant.TYPE_MAP.get(fieldType.toUpperCase())==null){
			fieldJavaType = "String";
		}else{
			fieldJavaType = GeneratorConstant.TYPE_MAP.get(fieldType.toUpperCase());
		}
		return fieldJavaType;
	}
	public void setFieldJavaType(String fieldJavaType) {
		this.fieldJavaType = fieldJavaType;
	}

	
	public String getGetMethodName() {
		if(fieldName!=null){
			StringBuffer sb = new StringBuffer(fieldName.length());
			String newstring = fieldName.toLowerCase();
			String[] newArray = newstring.split("_");
			String temp = null;
			for (int i = 0; i < newArray.length; i++) {
				temp = newArray[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			getMethodName = "get"+sb.toString();
			return getMethodName;
		}
		throw new CustomException("数据库字段名称不能为空", "0101");
	}
	public String getSetMethodName() {
		if(fieldName!=null){
			StringBuffer sb = new StringBuffer(fieldName.length());
			String newstring = fieldName.toLowerCase();
			String[] newArray = newstring.split("_");
			String temp = null;
			for (int i = 0; i < newArray.length; i++) {
				temp = newArray[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			setMethodName = "set"+sb.toString();
			return setMethodName;
		}
		throw new CustomException("数据库字段名称不能为空", "0101");
	}
}
