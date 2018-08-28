package com.devplatform.business.mina.server.entity;

import java.util.Date;


public class MessageEntity {
	
	private String sn;
	
	private String cmd;//命令类型
	
	private Date timestamp;//时间戳
	
	private Integer rand;
	
	private String sign;

	private Object data;
	
	private Object message;
	
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getRand() {
		return rand;
	}
	public void setRand(Integer rand) {
		this.rand = rand;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
