package com.devplatform.business.mina.server;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.devplatform.business.mina.server.entity.MessageEntity;

public class SessionWarehouse {
	
	private final static Map<String,SessionWarehouse> SESSION_WAREHOUSE_MAP = new HashMap<String, SessionWarehouse>();
	
	private IoSession session;
	
	private Map<String,Boolean> status;
	
	private Map<String,Object> data;
	
	private SessionWarehouse(){
	}
	
	public static IoSession getIoSession(String sn){
		SessionWarehouse sessionWarehouse = SESSION_WAREHOUSE_MAP.get(sn);
		if (sessionWarehouse!=null) {
			IoSession session = sessionWarehouse.session;
			return session;
		}
		return null;
	}
	public static void StopQuery(String sn,String cmd){
		SessionWarehouse sessionWarehouse = SESSION_WAREHOUSE_MAP.get(sn);
		if(sessionWarehouse!=null){
			if(sessionWarehouse.status!=null){
				sessionWarehouse.status.put(cmd,false);
			}
		}
	}
	public static void saveIoSession(MessageEntity messageEntity,IoSession session){
		SessionWarehouse sessionWarehouse = SESSION_WAREHOUSE_MAP.get(messageEntity.getSn());
		if(sessionWarehouse==null){
			SessionWarehouse newSessionWarehouse = new SessionWarehouse();
			newSessionWarehouse.session = session;
			newSessionWarehouse.status = new HashMap<String, Boolean>();
			newSessionWarehouse.data = new HashMap<String, Object>();
			SESSION_WAREHOUSE_MAP.put(messageEntity.getSn(), newSessionWarehouse);
		}else{
			sessionWarehouse.session = session;
		}
		
	}
	public static void saveData(MessageEntity messageEntity) throws Exception{
		SessionWarehouse sessionWarehouse = SESSION_WAREHOUSE_MAP.get(messageEntity.getSn());
		if (sessionWarehouse!=null) {
			if(sessionWarehouse.data==null){
				sessionWarehouse.data = new HashMap<String, Object>();
				sessionWarehouse.data.put(messageEntity.getCmd(),messageEntity.getData());
			}else{
				sessionWarehouse.data.put(messageEntity.getCmd(),messageEntity.getData());
			}
			sessionWarehouse.status.put(messageEntity.getCmd(), true);
		}else{
			throw new Exception("模块连接异常。。。");
		}
	}
	
	//根据sn和命令查询
	public static Object getData(String sn,String cmd) {
		SessionWarehouse sessionWarehouse = SESSION_WAREHOUSE_MAP.get(sn);
		if (sessionWarehouse!=null) {
			for (int i = 0;i < 10;i ++) {
				if(sessionWarehouse.data!=null&&sessionWarehouse.status.get(cmd)){
						return sessionWarehouse.data.get(cmd);
				}else{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			return "数据暂无。。。";
		}
		return null;
	}
}
