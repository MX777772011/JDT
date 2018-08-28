package com.devplatform.common.utils.excel;



public class Practise  {
	
	
	private java.lang.String id;//主键
	private java.lang.String etId;//考试类型表主键
	private java.lang.String sectionId;//考试环节表主键
	private java.lang.String trainName;//练习名称
	private Integer trainOrder;//练习排序
	private Integer buyOrNot;//是否应购买(0否1是）(只有已经购买过的才可以练习）
	
	
	public Practise(String id, String etId, String sectionId, String trainName, Integer trainOrder, Integer buyOrNot) {
		super();
		this.id = id;
		this.etId = etId;
		this.sectionId = sectionId;
		this.trainName = trainName;
		this.trainOrder = trainOrder;
		this.buyOrNot = buyOrNot;
	}

	public Practise() {
		super();
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getEtId() {
		return etId;
	}

	public void setEtId(java.lang.String etId) {
		this.etId = etId;
	}

	public java.lang.String getSectionId() {
		return sectionId;
	}

	public void setSectionId(java.lang.String sectionId) {
		this.sectionId = sectionId;
	}

	public java.lang.String getTrainName() {
		return trainName;
	}

	public void setTrainName(java.lang.String trainName) {
		this.trainName = trainName;
	}

	public Integer getTrainOrder() {
		return trainOrder;
	}

	public void setTrainOrder(Integer trainOrder) {
		this.trainOrder = trainOrder;
	}

	public Integer getBuyOrNot() {
		return buyOrNot;
	}

	public void setBuyOrNot(Integer buyOrNot) {
		this.buyOrNot = buyOrNot;
	}

	public String toString() {
		return "Practise [id=" + id + ", etId=" + etId + ", sectionId=" + sectionId + ", trainName=" + trainName + ", trainOrder=" + trainOrder + ", buyOrNot=" + buyOrNot + "]";
	}

	
	
	
}
