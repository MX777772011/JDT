package com.devplatform.common.utils.jpush.example;

import java.util.HashMap;
import java.util.Map;

import com.devplatform.common.utils.jpush.api.DeviceEnum;
import com.devplatform.common.utils.jpush.api.ErrorCodeEnum;
import com.devplatform.common.utils.jpush.api.IOSExtra;
import com.devplatform.common.utils.jpush.api.JPushClient;
import com.devplatform.common.utils.jpush.api.MessageResult;

public class JPushClientExample {
	// 在极光注册上传应用的 appKey 和 masterSecret
//	private static final String appKey = "24d0e26a59be70c303cb9e61";// //必填，例如466f7032ac604e02fb7bda89
//
//	private static final String masterSecret = "4be3cad9de7772fd9f66519c";// 必填，每个应用都对应一个masterSecret

	private static JPushClient jpush = null;

	/*
	 * 保存离线的时长。秒为单位。最多支持10天（864000秒）。 0 表示该消息不保存离线。即：用户在线马上发出，当前不在线用户将不会收到此消息。
	 * 此参数不设置则表示默认，默认为保存1天的离线消息（86400秒
	 */
	private static long timeToLive = 60 * 60 * 24;

	public static void main(String[] args) {
		/*
		 * Example1: 初始化,默认发送给android和ios，同时设置离线消息存活时间 jpush = new
		 * JPushClient(masterSecret, appKey, timeToLive);
		 * 
		 * Example2: 只发送给android jpush = new JPushClient(masterSecret, appKey,
		 * DeviceEnum.Android);
		 * 
		 * Example3: 只发送给IOS jpush = new JPushClient(masterSecret, appKey,
		 * DeviceEnum.IOS);
		 * 
		 * Example4: 只发送给android,同时设置离线消息存活时间 jpush = new
		 * JPushClient(masterSecret, appKey, timeToLive, DeviceEnum.Android);
		 */
//		jpush = new JPushClient(masterSecret, appKey, DeviceEnum.Android);
		/*
		 * 是否启用ssl安全连接, 可选 参数：启用true， 禁用false，默认为非ssl连接
		 */
//		jpush.setEnableSSL(true);
		// 测试发送消息或者通知
		//testSend();
	}
	/**
	 * 推送方法，type(1.所有，2.安卓，3.IOS)
	 * @param appKey
	 * @param masterSecret
	 * @param type
	 * @param msg
	 * @return
	 */
	public Map<String, Object> jPushMain(String appKey,String masterSecret,Integer type,String msg,String title) {
		Map<String, Object> map = new HashMap<String, Object>();
		switch (type) {
		case 1:
			jpush = new JPushClient(masterSecret, appKey, timeToLive);
			break;
		case 2:
			jpush = new JPushClient(masterSecret, appKey, timeToLive, DeviceEnum.Android);
			break;
		case 3:
			jpush = new JPushClient(masterSecret, appKey, timeToLive, DeviceEnum.IOS);
			break;
		default:
			map.put("success", false);
			map.put("msg", "类型不能为空");
			return map;
		}
		jpush.setEnableSSL(true);
		map = testSend(msg,title);
		return map;
	}

	private static Map<String, Object> testSend(String msg,String title) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 在实际业务中，建议 sendNo 是一个你自己的业务可以处理的一个自增数字。
		// 除非需要覆盖，请确保不要重复使用。详情请参考 API 文档相关说明。
		Integer num = getRandomSendNo();
		String sendNo = num.toString();
		String msgTitle = title;
		String msgContent = msg;
		/*
		 * IOS设备扩展参数, 设置badge，设置声音
		 */
		Map<String, Object> extra = new HashMap<String, Object>();
		IOSExtra iosExtra = new IOSExtra(1, "WindowsLogonSound.wav");
		extra.put("ios", iosExtra);
		// IOS和安卓一起
		MessageResult msgResult = jpush.sendNotificationWithAppKey(sendNo, msgTitle, msgContent, 0, extra);

		// 对所有用户发送通知, 更多方法请参考文档
		// MessageResult msgResult =
		// jpush.sendCustomMessageWithAppKey(sendNo,msgTitle, msgContent);

		if (null != msgResult) {
			System.out.println("服务器返回数据: " + msgResult.toString());
			if (msgResult.getErrcode() == ErrorCodeEnum.NOERROR.value()) {
				map.put("success",true);
				map.put("msg",msgResult.toString());
				map.put("sendno",msgResult.getSendno());
//				System.out.println("发送成功， sendNo=" + msgResult.getSendno());
			} else {
				map.put("success",true);
				map.put("msg",msgResult.getErrmsg());
				map.put("code", msgResult.getErrcode());
//				System.out.println("发送失败， 错误代码=" + msgResult.getErrcode() + ", 错误消息=" + msgResult.getErrmsg());
			}
		} else {
			map.put("success",true);
			map.put("msg", "无法发送数据");
//			System.out.println("无法获取数据");
		}
		return map;

	}

	public static final int MAX = Integer.MAX_VALUE;
	public static final int MIN = (int) MAX / 2;

	/**
	 * 保持 sendNo 的唯一性是有必要的 It is very important to keep sendNo unique.
	 * 
	 * @return sendNo
	 */
	public static int getRandomSendNo() {
		return (int) (MIN + Math.random() * (MAX - MIN));
	}

}
