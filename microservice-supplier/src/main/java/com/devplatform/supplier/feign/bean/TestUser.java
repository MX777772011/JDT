package com.devplatform.supplier.feign.bean;


public class TestUser {
	
	private Long id;////
	
	private java.lang.String userName;////
	
	private java.util.Date createTime;////日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	private java.lang.String email;////
	
	private java.lang.String phone;////
	
	private Long companyId;////
	
	private java.lang.String companyName;////
	
	private Integer delFlag;////
	
	private Long createUserId;////
	
	private java.util.Date updateTime;////日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	private Long updateUserId;////

	/**
	 * id/的getter方法
	 */
	public Long getId(){
		return id;
	}
	/**
	 * id/的setter方法
	 */
	public void setId(Long id){
		this.id = id;
	}
	/**
	 * userName/的getter方法
	 */
	public java.lang.String getUserName(){
		return userName;
	}
	/**
	 * userName/的setter方法
	 */
	public void setUserName(java.lang.String userName){
		this.userName = userName;
	}
	/**
	 * createTime/的getter方法
	 */
	public java.util.Date getCreateTime(){
		return createTime;
	}
	/**
	 * createTime/的setter方法
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 * email/的getter方法
	 */
	public java.lang.String getEmail(){
		return email;
	}
	/**
	 * email/的setter方法
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 * phone/的getter方法
	 */
	public java.lang.String getPhone(){
		return phone;
	}
	/**
	 * phone/的setter方法
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 * companyId/的getter方法
	 */
	public Long getCompanyId(){
		return companyId;
	}
	/**
	 * companyId/的setter方法
	 */
	public void setCompanyId(Long companyId){
		this.companyId = companyId;
	}
	/**
	 * companyName/的getter方法
	 */
	public java.lang.String getCompanyName(){
		return companyName;
	}
	/**
	 * companyName/的setter方法
	 */
	public void setCompanyName(java.lang.String companyName){
		this.companyName = companyName;
	}
	/**
	 * delFlag/的getter方法
	 */
	public Integer getDelFlag(){
		return delFlag;
	}
	/**
	 * delFlag/的setter方法
	 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * createUserId/的getter方法
	 */
	public Long getCreateUserId(){
		return createUserId;
	}
	/**
	 * createUserId/的setter方法
	 */
	public void setCreateUserId(Long createUserId){
		this.createUserId = createUserId;
	}
	/**
	 * updateTime/的getter方法
	 */
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	/**
	 * updateTime/的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 * updateUserId/的getter方法
	 */
	public Long getUpdateUserId(){
		return updateUserId;
	}
	/**
	 * updateUserId/的setter方法
	 */
	public void setUpdateUserId(Long updateUserId){
		this.updateUserId = updateUserId;
	}

}
