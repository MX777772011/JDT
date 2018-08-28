package com.devplatform.common.utils.excel;


public class Train {
	
	
	private java.lang.String id;//主键
	
	private java.lang.String practiseId;//考试练习表主键
	
	private java.lang.String trainTitle;//训练标题（问答1之类的）
	
	private java.lang.String trainContent;//训练内容

	private java.lang.String trainVideo;//考官视频（视频表主键）
	private java.lang.String trainVideoURL;//考官视频（视频表主键）
	
	private java.lang.String pictureId;//图片表主键
	private java.lang.String pictureIdURL;//图片表主键
	
	private java.lang.String audioId;//音频表主键（zip）
	private java.lang.String audioIdURL;//音频表主键（zip）
	
	private java.lang.String role;//角色
	
	private Integer trainOrder;//排序
	
	private java.lang.String trainAnswer;//训练答案
	
	private String sectionControlTime;//控制点

	public String toString() {
		return "Train [id=" + id + ", practiseId=" + practiseId + ", trainTitle=" + trainTitle + ", trainContent=" + trainContent + ", trainVideo=" + trainVideo + ", trainVideoURL=" + trainVideoURL + ", pictureId=" + pictureId + ", pictureIdURL=" + pictureIdURL + ", audioId=" + audioId
				+ ", audioIdURL=" + audioIdURL + ", role=" + role + ", trainOrder=" + trainOrder + ", trainAnswer=" + trainAnswer + ", sectionControlTime=" + sectionControlTime + "]";
	}

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Train(String id, String practiseId, String trainTitle, String trainContent, String trainVideo, String trainVideoURL, String pictureId, String pictureIdURL, String audioId, String audioIdURL, String role, Integer trainOrder, String trainAnswer, String sectionControlTime) {
		super();
		this.id = id;
		this.practiseId = practiseId;
		this.trainTitle = trainTitle;
		this.trainContent = trainContent;
		this.trainVideo = trainVideo;
		this.trainVideoURL = trainVideoURL;
		this.pictureId = pictureId;
		this.pictureIdURL = pictureIdURL;
		this.audioId = audioId;
		this.audioIdURL = audioIdURL;
		this.role = role;
		this.trainOrder = trainOrder;
		this.trainAnswer = trainAnswer;
		this.sectionControlTime = sectionControlTime;
	}

	public Train(String id, String practiseId, String trainTitle, String trainContent, String trainVideoURL, String pictureIdURL, String audioIdURL, String sectionControlTime) {
		super();
		this.id = id;
		this.practiseId = practiseId;
		this.trainTitle = trainTitle;
		this.trainContent = trainContent;
		this.trainVideoURL = trainVideoURL;
		this.pictureIdURL = pictureIdURL;
		this.audioIdURL = audioIdURL;
		this.sectionControlTime = sectionControlTime;
	}

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

	public java.lang.String getTrainTitle() {
		return trainTitle;
	}

	public void setTrainTitle(java.lang.String trainTitle) {
		this.trainTitle = trainTitle;
	}

	public java.lang.String getTrainContent() {
		return trainContent;
	}

	public void setTrainContent(java.lang.String trainContent) {
		this.trainContent = trainContent;
	}

	public java.lang.String getTrainVideo() {
		return trainVideo;
	}

	public void setTrainVideo(java.lang.String trainVideo) {
		this.trainVideo = trainVideo;
	}

	public java.lang.String getTrainVideoURL() {
		return trainVideoURL;
	}

	public void setTrainVideoURL(java.lang.String trainVideoURL) {
		this.trainVideoURL = trainVideoURL;
	}

	public java.lang.String getPictureId() {
		return pictureId;
	}

	public void setPictureId(java.lang.String pictureId) {
		this.pictureId = pictureId;
	}

	public java.lang.String getPictureIdURL() {
		return pictureIdURL;
	}

	public void setPictureIdURL(java.lang.String pictureIdURL) {
		this.pictureIdURL = pictureIdURL;
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

	public java.lang.String getRole() {
		return role;
	}

	public void setRole(java.lang.String role) {
		this.role = role;
	}

	public Integer getTrainOrder() {
		return trainOrder;
	}

	public void setTrainOrder(Integer trainOrder) {
		this.trainOrder = trainOrder;
	}

	public java.lang.String getTrainAnswer() {
		return trainAnswer;
	}

	public void setTrainAnswer(java.lang.String trainAnswer) {
		this.trainAnswer = trainAnswer;
	}

	public String getSectionControlTime() {
		return sectionControlTime;
	}

	public void setSectionControlTime(String sectionControlTime) {
		this.sectionControlTime = sectionControlTime;
	}
}
