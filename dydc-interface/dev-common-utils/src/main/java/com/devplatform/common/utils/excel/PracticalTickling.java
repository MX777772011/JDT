package com.devplatform.common.utils.excel;



public class PracticalTickling {
	
	private java.lang.String id;//主键
	private java.lang.String practicalId;//实战表主键
	private java.lang.String audioId;//录音表主键
	private java.lang.String audioIdURL;//录音表主键
	private java.lang.String exampleName;//示例名称
	private java.lang.String exampleContent;//用来存放脚本与解析的内容
	
	private Integer exampleOrder;//示例排序

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getPracticalId() {
		return practicalId;
	}

	public void setPracticalId(java.lang.String practicalId) {
		this.practicalId = practicalId;
	}

	public java.lang.String getAudioId() {
		return audioId;
	}

	public void setAudioId(java.lang.String audioId) {
		this.audioId = audioId;
	}

	public java.lang.String getAudioIdURL() {
		return audioIdURL;
	}

	public void setAudioIdURL(java.lang.String audioIdURL) {
		this.audioIdURL = audioIdURL;
	}

	public java.lang.String getExampleName() {
		return exampleName;
	}

	public void setExampleName(java.lang.String exampleName) {
		this.exampleName = exampleName;
	}

	public java.lang.String getExampleContent() {
		return exampleContent;
	}

	public void setExampleContent(java.lang.String exampleContent) {
		this.exampleContent = exampleContent;
	}

	public Integer getExampleOrder() {
		return exampleOrder;
	}

	public void setExampleOrder(Integer exampleOrder) {
		this.exampleOrder = exampleOrder;
	}

	public String toString() {
		return "PracticalTickling [id=" + id + ", practicalId=" + practicalId + ", audioId=" + audioId + ", audioIdURL=" + audioIdURL + ", exampleName=" + exampleName + ", exampleContent=" + exampleContent + ", exampleOrder=" + exampleOrder + "]";
	}

	public PracticalTickling() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PracticalTickling(String id, String practicalId, String audioIdURL, String exampleName, String exampleContent) {
		super();
		this.id = id;
		this.practicalId = practicalId;
		this.audioIdURL = audioIdURL;
		this.exampleName = exampleName;
		this.exampleContent = exampleContent;
	}

	
}
