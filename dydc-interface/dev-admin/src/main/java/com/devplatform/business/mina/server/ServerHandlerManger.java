package com.devplatform.business.mina.server;

import com.devplatform.business.mina.server.entity.JsonNodeEntity;
import com.devplatform.common.utils.SpringContextUtil;

public class ServerHandlerManger {
	public static void init() {

	}

	public static MessageReceivedImp getHandler(JsonNodeEntity jsonNodeEntity) {
		return (MessageReceivedImp) getHandler(jsonNodeEntity.getKey());
	}
	
	public static MessageReceivedImp getHandler(String key) {
		return (MessageReceivedImp) SpringContextUtil.getBean(key);
	}

	public static void action(String message) {
		// getHandler("").
	}
}
