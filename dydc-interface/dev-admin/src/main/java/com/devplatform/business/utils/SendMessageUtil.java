package com.devplatform.business.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.devplatform.business.mina.server.SessionWarehouse;

public class SendMessageUtil {
	private final static Map<String,SendMessageUtil> SEND_MESSAGE_UTIL = new HashMap<String, SendMessageUtil>();
	
	private String oroom = null;
	
	private String eis = null;
	
	private String addrSet = null;
	
	private String val = null;
	
	private String cmd = null;
	
	private String sn = null;
	
	private SendMessageUtil(String sn){
		this.sn = sn;
	}
	public static SendMessageUtil getInstance(String sn) {
		SendMessageUtil sendMessageUtil = SEND_MESSAGE_UTIL.get(sn);
		if(sendMessageUtil==null){
			SendMessageUtil newSendMessageUtil = new SendMessageUtil(sn);
			SEND_MESSAGE_UTIL.put(sn,newSendMessageUtil);
			return newSendMessageUtil;
		}
		return sendMessageUtil;
	}

	public String getEis() {
		return eis;
	}

	public void setEis(String eis) {
		this.eis = eis;
	}

	public String getAddrSet() {
		return addrSet;
	}

	public void setAddrSet(String addrSet) {
		this.addrSet = addrSet;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getSn() {
		return sn;
	}

	public void Send() throws Exception{
		SessionWarehouse.StopQuery(sn, cmd);
		IoSession session = SessionWarehouse.getIoSession(sn);
		if(session!=null){
			switch(cmd){
			case "query1":
				String query1Str = "{\"sn\":\""+sn+"\",\"cmd\":\"query1\",\"data\":{\"oRoom\":\"-1\",\"tag\":\"222\"}}";
				System.out.println("服务器发送"+query1Str);
				session.write(query1Str);
				break;
			case "query2":
				String query2Str = "{\"sn\":\""+sn+"\",\"cmd\":\"query2\",\"data\":{\"oRoom\":\""+oroom+"\",\"tag\":\"2\"}}";
				System.out.println("服务器发送"+query2Str);
				session.write(query2Str);
				break;
			case "control":
				String controlStr = "{\"sn\":\""+sn+"\",\"cmd\":\"control\",\"data\":\"EIS"+eis+"="+addrSet+"="+val+"\"}";
				System.out.println("服务器发送"+controlStr);
				session.write(controlStr);
				break;
			default:
				return;
			}
			
		}else{
			throw new Exception("模块连接异常。。。");
		}
	}
	public String getOroom() {
		return oroom;
	}
	public void setOroom(String oroom) {
		this.oroom = oroom;
	}
}
