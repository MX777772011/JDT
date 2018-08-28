package com.devplatform.sys.model;

public class SiteNewsModel extends BaseModel {

	private String id;//   	private String pid;// 所属栏目	private String title;// 标题	private String summary;// 摘要	private String contentid;// 新闻内容id	private String pic;//   	private java.util.Date createTime;//   	private String createUser;//   	private Integer status;// 状态
	private Integer view;// 点击量
	
		
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContentid() {
		return this.contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	
}
