package com.devplatform.common.utils.excel;

import java.util.List;


public class Explain  {
	

	private java.lang.String id;//主键
	private java.lang.String practiseId;//考试练习表主键
	private java.lang.String pid;//上级主键
	private java.lang.String questionTitle;//标题            （Q1，只有问答才有，其他没有）
	private java.lang.String questionContent;//问答标题            （问答的时候，是Question 1:What would many people think of San Francisco according to the passage?            其他的时候，是答案解析之类的            ）
	private java.lang.String titleOne;//一级标题
	private java.lang.String titleSecond;//二级标题
	private java.lang.String audioId;//录音
	private java.lang.String audioIdURL;//录音URL
	private Integer titleLevel;//级别
	
	private List<Explain> childs;

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

	public java.lang.String getPid() {
		return pid;
	}

	public void setPid(java.lang.String pid) {
		this.pid = pid;
	}

	public java.lang.String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(java.lang.String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public java.lang.String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(java.lang.String questionContent) {
		this.questionContent = questionContent;
	}

	public java.lang.String getTitleOne() {
		return titleOne;
	}

	public void setTitleOne(java.lang.String titleOne) {
		this.titleOne = titleOne;
	}

	public java.lang.String getTitleSecond() {
		return titleSecond;
	}

	public void setTitleSecond(java.lang.String titleSecond) {
		this.titleSecond = titleSecond;
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

	public Integer getTitleLevel() {
		return titleLevel;
	}

	public void setTitleLevel(Integer titleLevel) {
		this.titleLevel = titleLevel;
	}

	public List<Explain> getChilds() {
		return childs;
	}

	public void setChilds(List<Explain> childs) {
		this.childs = childs;
	}

	public String toString() {
		return "Explain [id=" + id + ", practiseId=" + practiseId + ", pid=" + pid + ", questionTitle=" + questionTitle + ", questionContent=" + questionContent + ", titleOne=" + titleOne + ", titleSecond=" + titleSecond + ", audioId=" + audioId + ", audioIdURL=" + audioIdURL + ", titleLevel="
				+ titleLevel + ", childs=" + childs + "]";
	}

	public Explain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Explain(String id, String practiseId, String pid, String questionTitle, String questionContent, String titleOne, String titleSecond, String audioId, String audioIdURL, Integer titleLevel, List<Explain> childs) {
		super();
		this.id = id;
		this.practiseId = practiseId;
		this.pid = pid;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.titleOne = titleOne;
		this.titleSecond = titleSecond;
		this.audioId = audioId;
		this.audioIdURL = audioIdURL;
		this.titleLevel = titleLevel;
		this.childs = childs;
	}

	public Explain(String id, String practiseId, String questionTitle, String questionContent, String titleOne, String titleSecond, String audioIdURL) {
		super();
		this.id = id;
		this.practiseId = practiseId;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.titleOne = titleOne;
		this.titleSecond = titleSecond;
		this.audioIdURL = audioIdURL;
	}
	
	
	
}
