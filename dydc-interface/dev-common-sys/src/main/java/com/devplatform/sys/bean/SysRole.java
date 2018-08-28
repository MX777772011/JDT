package com.devplatform.sys.bean;

@SuppressWarnings("serial")
public class SysRole extends BaseBean {

	private String id;// id主键
	private String roleName;// 角色名称
	private java.sql.Timestamp createTime;// 创建时间
	private String createBy;// 创建人
	private java.sql.Timestamp updateTime;// 修改时间
	private String updateBy;// 修改人
	private Integer state;// 状态0=可用 1=禁用
	private String descr;// 角色描述
	private Integer viewData;// 浏览数据权限 0,无权限 1,员工权限 3,录入员 5,经理权限 6,部门经理权限 8,老板权限
								// 9,全权限
								// 目前此字段已废弃，为之前项目组做项目时使用遗留，项目组可自行扩展使用或者不用

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public java.sql.Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getViewData() {
		return viewData;
	}

	public void setViewData(Integer viewData) {
		this.viewData = viewData;
	}

}
