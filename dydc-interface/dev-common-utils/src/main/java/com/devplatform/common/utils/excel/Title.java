package com.devplatform.common.utils.excel;



public class Title{
	
	
	private java.lang.String id;//主键
	private java.lang.String practiseId;//考试练习表主键
	private java.lang.String titleName;//题目名称
	private java.lang.String titleRecord;//题目录音（T_AUDIO）
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getPractiseId() {
		return practiseId;
	}
	public void setPractiseId(java.lang.String practiseId) {
		this.practiseId = practiseId;
	}
	public java.lang.String getTitleName() {
		return titleName;
	}
	public void setTitleName(java.lang.String titleName) {
		this.titleName = titleName;
	}
	public java.lang.String getTitleRecord() {
		return titleRecord;
	}
	public void setTitleRecord(java.lang.String titleRecord) {
		this.titleRecord = titleRecord;
	}
	public String toString() {
		return "Title [id=" + id + ", practiseId=" + practiseId + ", titleName=" + titleName + ", titleRecord=" + titleRecord + "]";
	}
	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Title(String id, String practiseId, String titleName, String titleRecord) {
		super();
		this.id = id;
		this.practiseId = practiseId;
		this.titleName = titleName;
		this.titleRecord = titleRecord;
	}
	

	
	
}
