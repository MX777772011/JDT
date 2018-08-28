package com.devplatform.business.mina.server;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.devplatform.business.mina.server.entity.MessageEntity;
import com.devplatform.business.utils.JsonUtil;
import com.devplatform.common.utils.json.JSONUtil;
import com.devplatform.sys.redis.impl.RedisDaoImpl;

public class MessageHandler {

	public static void handle(MessageEntity messageEntity, IoSession session) throws Exception{
		String sn = messageEntity.getSn();
		switch(messageEntity.getCmd()){
			case "reg":
				String str = "{\"sn\":\""+sn+"\",\"cmd\":\"regrsp\",\"data\":{\"error\":\"0\"}}";
				session.write(str);
				SessionWarehouse.saveIoSession(messageEntity, session);
				break;
			case "rsp1":
				messageEntity.setCmd("query1");
				System.out.println(messageEntity);
				SessionWarehouse.saveData(messageEntity);
				break;
			case "rsp2":
				messageEntity.setCmd("query2");
				System.out.println(messageEntity);
				SessionWarehouse.saveData(messageEntity);
				break;
			case "push":
				System.out.println(messageEntity);
				SessionWarehouse.saveData(messageEntity);
				break;
			case "keepalive":
				String str2 = "{\"sn\":\""+sn+"\",\"cmd\":\"keepalive\"}";
				session.write(str2);
				break;
			default:
				return;
		}
	}
	public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		Class<?> clazz = obj.getClass();
		System.out.println(clazz);
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object value = field.get(obj);
			map.put(fieldName, value);
		}
		return map;
    }
}
