package com.devplatform.common.utils.excel;



public class Repart {
	
	
	private java.lang.String id;//主键
	private Integer repartType;//跟读类型(1整句跟读,2整段跟读)
	private java.lang.String practiseId;//考试练习表主键
	private java.lang.String repatQuestion;//问答题目
	private java.lang.String repatContent;//跟读文本
	private java.lang.String repatAudio;//跟读音频文件
	private java.lang.String repatPic;//图片
	private java.lang.String repatAudioURL;//跟读音频文件
	private java.lang.String repatPicURL;//图片
	private java.lang.String repatRole;//角色
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public Integer getRepartType() {
		return repartType;
	}
	public void setRepartType(Integer repartType) {
		this.repartType = repartType;
	}
	public java.lang.String getPractiseId() {
		return practiseId;
	}
	public void setPractiseId(java.lang.String practiseId) {
		this.practiseId = practiseId;
	}
	public java.lang.String getRepatQuestion() {
		return repatQuestion;
	}
	public void setRepatQuestion(java.lang.String repatQuestion) {
		this.repatQuestion = repatQuestion;
	}
	public java.lang.String getRepatContent() {
		return repatContent;
	}
	public void setRepatContent(java.lang.String repatContent) {
		this.repatContent = repatContent;
	}
	public java.lang.String getRepatAudio() {
		return repatAudio;
	}
	public void setRepatAudio(java.lang.String repatAudio) {
		this.repatAudio = repatAudio;
	}
	public java.lang.String getRepatPic() {
		return repatPic;
	}
	public void setRepatPic(java.lang.String repatPic) {
		this.repatPic = repatPic;
	}
	public java.lang.String getRepatAudioURL() {
		return repatAudioURL;
	}
	public void setRepatAudioURL(java.lang.String repatAudioURL) {
		this.repatAudioURL = repatAudioURL;
	}
	public java.lang.String getRepatPicURL() {
		return repatPicURL;
	}
	public void setRepatPicURL(java.lang.String repatPicURL) {
		this.repatPicURL = repatPicURL;
	}
	public java.lang.String getRepatRole() {
		return repatRole;
	}
	public void setRepatRole(java.lang.String repatRole) {
		this.repatRole = repatRole;
	}
	public String toString() {
		return "Repart [id=" + id + ", repartType=" + repartType + ", practiseId=" + practiseId + ", repatQuestion=" + repatQuestion + ", repatContent=" + repatContent + ", repatAudio=" + repatAudio + ", repatPic=" + repatPic + ", repatAudioURL=" + repatAudioURL + ", repatPicURL=" + repatPicURL
				+ ", repatRole=" + repatRole + "]";
	}
	public Repart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Repart(String id, Integer repartType, String practiseId, String repatQuestion, String repatContent, String repatAudio, String repatPic, String repatAudioURL, String repatPicURL, String repatRole) {
		super();
		this.id = id;
		this.repartType = repartType;
		this.practiseId = practiseId;
		this.repatQuestion = repatQuestion;
		this.repatContent = repatContent;
		this.repatAudio = repatAudio;
		this.repatPic = repatPic;
		this.repatAudioURL = repatAudioURL;
		this.repatPicURL = repatPicURL;
		this.repatRole = repatRole;
	}
	public Repart(String id, Integer repartType, String practiseId, String repatQuestion, String repatContent, String repatAudioURL, String repatPicURL) {
		super();
		this.id = id;
		this.repartType = repartType;
		this.practiseId = practiseId;
		this.repatQuestion = repatQuestion;
		this.repatContent = repatContent;
		this.repatAudioURL = repatAudioURL;
		this.repatPicURL = repatPicURL;
	}

	
	
	
	
}
