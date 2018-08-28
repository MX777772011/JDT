package com.devplatform.sys.bean;

@SuppressWarnings("serial")
public class SysLog extends BaseBean {

	private String id; //
	private String userId; // 操作人
	private java.sql.Timestamp operationTime; // 操作时间
	private String operation; // 操作
	private String url; // 操作路径
	private String details; // 操作详情
	private String moduleName; // 操作栏目

	private String loginTime; // 登录时间
	private String loginCount;// 登录数量

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public java.sql.Timestamp getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(java.sql.Timestamp operationTime) {
		this.operationTime = operationTime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		return "SysLog [details=" + details + ", id=" + id + ", moduleName=" + moduleName + ", operation=" + operation + ", operationTime=" + operationTime + ", url=" + url + ", userId=" + userId + "]";
	}

}
