package com.devplatform.common.utils.excel;



public class Practical {
	
	
	private java.lang.String id;//主键
	private java.lang.String practiseId;//考试练习表主键
	private java.lang.String trainTitle;//实战标题（问答1之类的）
	
	private java.lang.String trainVideo;//考官视频（视频表主键）
	private java.lang.String trainVideoURL;//考官视频（视频表主键）
	
	private java.lang.String trainContent;//训练内容
	
	private java.lang.String pictureId;//图片表主键
	private java.lang.String pictureIdURL;//图片表主键
	
	private java.lang.String audioId;//音频表主键（zip）
	private java.lang.String audioIdURL;//音频表主键（zip）
	
	private java.lang.String role;//角色
	
	private java.lang.String controlPoint;//指令控制点
	
	private java.lang.String expandField1;//预留扩展字段1（启用  视频静态图片）
	private java.lang.String expandField1URL;//预留扩展字段1（启用  视频静态图片）
	private java.lang.String expandField2;//预留扩展字段2（启用  视频动态图片）
	private java.lang.String expandField2URL;//预留扩展字段2（启用  视频动态图片）

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

	public java.lang.String getTrainContent() {
		return trainContent;
	}

	public void setTrainContent(java.lang.String trainContent) {
		this.trainContent = trainContent;
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

	public java.lang.String getControlPoint() {
		return controlPoint;
	}

	public void setControlPoint(java.lang.String controlPoint) {
		this.controlPoint = controlPoint;
	}
	
	public java.lang.String getExpandField1() {
		return expandField1;
	}

	public void setExpandField1(java.lang.String expandField1) {
		this.expandField1 = expandField1;
	}

	public java.lang.String getExpandField1URL() {
		return expandField1URL;
	}

	public void setExpandField1URL(java.lang.String expandField1URL) {
		this.expandField1URL = expandField1URL;
	}

	public java.lang.String getExpandField2() {
		return expandField2;
	}

	public void setExpandField2(java.lang.String expandField2) {
		this.expandField2 = expandField2;
	}

	public java.lang.String getExpandField2URL() {
		return expandField2URL;
	}

	public void setExpandField2URL(java.lang.String expandField2URL) {
		this.expandField2URL = expandField2URL;
	}

	public String toString() {
		return "Practical [id=" + id + ", practiseId=" + practiseId + ", trainTitle=" + trainTitle + ", trainVideo="
				+ trainVideo + ", trainVideoURL=" + trainVideoURL + ", trainContent=" + trainContent + ", pictureId="
				+ pictureId + ", pictureIdURL=" + pictureIdURL + ", audioId=" + audioId + ", audioIdURL=" + audioIdURL
				+ ", role=" + role + ", controlPoint=" + controlPoint + ", expandField1=" + expandField1
				+ ", expandField1URL=" + expandField1URL + ", expandField2=" + expandField2 + ", expandField2URL="
				+ expandField2URL + "]";
	}

	public Practical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Practical(String id, String practiseId, String trainTitle, String trainVideo, String trainVideoURL, String trainContent, String pictureId, String pictureIdURL, String audioId, String audioIdURL, String role, String controlPoint,String expandField1URL,String expandField2URL) {
		super();
		this.id = id;
		this.practiseId = practiseId;
		this.trainTitle = trainTitle;
		this.trainVideo = trainVideo;
		this.trainVideoURL = trainVideoURL;
		this.trainContent = trainContent;
		this.pictureId = pictureId;
		this.pictureIdURL = pictureIdURL;
		this.audioId = audioId;
		this.audioIdURL = audioIdURL;
		this.role = role;
		this.controlPoint = controlPoint;
		this.expandField1URL = expandField1URL;
		this.expandField2URL = expandField2URL;
	}

	public Practical(String id, String practiseId, String trainVideoURL, String trainContent, String pictureIdURL, String controlPoint,String expandField1URL,String expandField2URL) {
		super();
		this.id = id;
		this.practiseId = practiseId;
		this.trainVideoURL = trainVideoURL;
		this.trainContent = trainContent;
		this.pictureIdURL = pictureIdURL;
		this.controlPoint = controlPoint;
		this.expandField1URL = expandField1URL;
		this.expandField2URL = expandField2URL;
	}
	
	

	
	
}
