package com.devplatform.common.utils.excel;



public class TitleContent {
	
	private java.lang.String id;//主键
	private java.lang.String titleId;//考题目表主键
	private java.lang.String content;//题目内容
	private java.lang.String pic;//题目中的图片（图片表主键）
	public String toString() {
		return "TitleContent [id=" + id + ", titleId=" + titleId + ", content=" + content + ", pic=" + pic + "]\n";
	}
	public TitleContent(String id, String titleId, String content, String pic) {
		super();
		this.id = id;
		this.titleId = titleId;
		this.content = content;
		this.pic = pic;
	}
	public TitleContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getTitleId() {
		return titleId;
	}
	public void setTitleId(java.lang.String titleId) {
		this.titleId = titleId;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getPic() {
		return pic;
	}
	public void setPic(java.lang.String pic) {
		this.pic = pic;
	}
	

	
	
	
}
