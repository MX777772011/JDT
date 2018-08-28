package com.devplatform.sys.model;

public class SiteNewsColumnModel extends BaseModel {

	private String id;//   	private String pid;// 父节点id	private String name;//   	private String description;// 描述	private Integer sorting;// 排序	private Integer forbidden;// 是否禁用，默认是0，1为禁用	private String createUer;// 创建用户	private java.util.Date createTime;//
	private Integer type;//栏目类别
	private String template;
	
	//非数据库查询字段
	private Boolean queryAll;
	
	
	public Boolean getQueryAll() {
		return queryAll;
	}

	public void setQueryAll(Boolean queryAll) {
		this.queryAll = queryAll;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSorting() {
		return this.sorting;
	}

	public void setSorting(Integer sorting) {
		this.sorting = sorting;
	}

	public Integer getForbidden() {
		return this.forbidden;
	}

	public void setForbidden(Integer forbidden) {
		this.forbidden = forbidden;
	}

	public String getCreateUer() {
		return this.createUer;
	}

	public void setCreateUer(String createUer) {
		this.createUer = createUer;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
