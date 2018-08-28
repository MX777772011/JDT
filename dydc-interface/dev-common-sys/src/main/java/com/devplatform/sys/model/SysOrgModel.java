package com.devplatform.sys.model;

public class SysOrgModel extends BaseModel{

	private String id;
	private String name;//组织名称
	private String pid;//父Id
	private String createdTime;//创建时间
	private String describe;//组织描述
	private String principal;//负责人id
	private String createdBy;//创建人id
	private Integer deleted;//删除状态 0=未删除,1=已删除
	
	//以下为联合查询时使用
	private Integer isVisual;
	private Integer isManager;
	private Integer isTeamLeader;
	private Integer excludeManager;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Integer getIsVisual() {
		return isVisual;
	}
	public void setIsVisual(Integer isVisual) {
		this.isVisual = isVisual;
	}
	public Integer getIsManager() {
		return isManager;
	}
	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}
	public Integer getIsTeamLeader() {
		return isTeamLeader;
	}
	public void setIsTeamLeader(Integer isTeamLeader) {
		this.isTeamLeader = isTeamLeader;
	}
	public Integer getExcludeManager() {
		return excludeManager;
	}
	public void setExcludeManager(Integer excludeManager) {
		this.excludeManager = excludeManager;
	}
	
	
	
}
