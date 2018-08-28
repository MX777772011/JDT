package com.devplatform.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class JPushUtil {
	protected static final Logger LOG = LoggerFactory.getLogger(JPushUtil.class);


	public static PushResult sendPush(String appKey, String masterSecret,int platType,String alert) {
		return sendPush(appKey, masterSecret, platType, alert, false);
	}
	public static PushResult sendPush(String appKey, String masterSecret,int platType,String alert,boolean isApnsProduction) {
		
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());
		// 生成推送的内容，这里我们先测试全部推送
		PushPayload payload = null;
		switch (platType) {
		case 1:
			payload = buildPushObject_all_alert(alert,isApnsProduction);
			break;
		case 2:
			payload = buildPushObject_android_alert(alert,isApnsProduction);
			break;
		case 3:
			payload = buildPushObject_ios_alert(alert,isApnsProduction);
			break;
		default:
			throw new CustomException();
		}
		try {
			System.out.println(payload.toString());
			PushResult result = jpushClient.sendPush(payload);
			System.out.println(result + "................................");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection error. Should retry later. ");
			throw new CustomException(e);
		} 
	}

	public static PushPayload buildPushObject_all_all_alert(String ALERT) {
		return PushPayload.alertAll(ALERT);
	}

	public static PushPayload buildPushObject_all_alert(String ALERT) {
		return buildPushObject_all_alert(ALERT, true);
	}
	public static PushPayload buildPushObject_all_alert(String ALERT,boolean isApnsProduction) {
		return PushPayload.newBuilder().setPlatform(Platform.all())// 设置接受的平台
				.setAudience(Audience.all())// Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
				.setNotification(Notification.alert(ALERT)).setOptions(Options.newBuilder().setApnsProduction(isApnsProduction).build()).build();
	}

	public static PushPayload buildPushObject_android_alert(String ALERT) {
		return buildPushObject_android_alert(ALERT, true);
	}
	public static PushPayload buildPushObject_android_alert(String ALERT,boolean isApnsProduction) {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.all())
				.setNotification(Notification.android(ALERT, ALERT, null)).setOptions(Options.newBuilder().setApnsProduction(false).build()).build();
	}
	public static PushPayload buildPushObject_ios_alert(String ALERT) {
		return buildPushObject_ios_alert(ALERT, true);
	}
	public static PushPayload buildPushObject_ios_alert(String ALERT,boolean isApnsProduction) {
		return PushPayload.newBuilder().setPlatform(Platform.ios())
				.setAudience(Audience.all())
				.setNotification(Notification.ios(ALERT, null)).setOptions(Options.newBuilder().setApnsProduction(isApnsProduction).build()).build();
	}

	public static void main(String[] args){
		String appKey = "25b9547fddae471928aac2b3";
		String masterSecret ="5cbd7b345ef62eeecf2907a2";
//		testSendPush(appKey,masterSecret,"生产测试alert1");
		sendPush(appKey,masterSecret,1,"生产测试全部生产测试全部生产测试全部生产测试全部生");
//		sendPush(appKey,masterSecret,2,"生产测试Android");
//		sendPush(appKey,masterSecret,3,"生产测试ios");
	}
}