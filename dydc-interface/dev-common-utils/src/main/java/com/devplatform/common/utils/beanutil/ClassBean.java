package com.devplatform.common.utils.beanutil;

import java.util.List;

public class ClassBean {

	private String authCode;
	
	private String tableName;
	
	private String beanName;

	private String beanNameLower;
	
	private String comment;
	
	private List<FieldBean> fields;
	
	private int hasOrder;

	private boolean hasDate;

	private boolean hasFile;
	
	private boolean hasValid;
	
	private boolean hastransfer;
	
	
	public String getBeanNameLower() {
		beanNameLower = getBeanName().toLowerCase();
		return beanNameLower;
	}

	public String getBeanName() {
		if(tableName!=null){
			StringBuffer sb = new StringBuffer(tableName.length());
			String tableNew = tableName.toLowerCase();
			String[] tables = tableNew.split("_");
			String temp = null;
			for (int i = 1; i < tables.length; i++) {
				temp = tables[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			beanName = sb.toString();
		}
		return beanName;
	}

	public List<FieldBean> getFields() {
		return fields;
	}

	public void setFields(List<FieldBean> fields) {
		this.fields = fields;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getHasOrder() {
		hasOrder=0;
		if(fields!=null){
			for(FieldBean field:fields){
				if(field.getIsOrder().equals("1")){
					hasOrder++;
					break;
				}
			}
		}
		return hasOrder;
	}
	
	

	public boolean isHasDate() {
		boolean flag = false;
		if(fields==null){
			return false;
		}
		for(FieldBean field:fields){
			if(field.getPageType()==3){
				flag = true;
				break;
			}
		}
		hasDate = flag ;
		return hasDate;
	}

	public boolean isHasFile() {
		boolean flag = false;
		if(fields==null){
			return false;
		}
		for(FieldBean field:fields){
			if(field.getPageType()==6){
				flag = true;
				break;
			}
		}
		hasFile = flag ;
		return hasFile;
	}
	
	

	@Override
	public String toString() {
		return "ClassBean [tableName=" + tableName + ", beanName=" + getBeanName() + ", beanNameLower=" + getBeanNameLower() + ", comment=" + comment + ", hasOrder=" + getHasOrder() +", hasDate=" + isHasDate() + ", fields=" + fields + "]";
	}

	/**
	 * @return the hasValid
	 */
	public boolean isHasValid() {
		if(fields==null){
			return false;
		}
		for(FieldBean field:fields){
			if(!"0".equals(field.getLimitType())){
				hasValid = true;
				return hasValid;
			}
		}
		return false;
	}

	/**
	 * @return the hastransfer
	 */
	public boolean isHastransfer() {
		if(fields==null){
			return false;
		}
		for(FieldBean field:fields){
			if(field.getDataSource()!=null){
				hastransfer = true;
				return hastransfer;
			}
		}
		return false;
	}

	/**
	 * @return the authCode
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @param authCode the authCode to set
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	
	
	
}
