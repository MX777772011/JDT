package com.devplatform.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ISpeakUtil {
	
	public static int counts = 0;
	
	public static String pubTimes;
	
	/**
	 * 禁止实例化
	 */
	private ISpeakUtil() {
	}

	
	/**
	 * 通过时间戳来生成数据库的主键
	 * 
	 * @return
	 */
	public static String getId() {
		String id = "";
		try {
			if (counts == 9) {// 本来不用写此，会降低效率，但是由于数据库数据都是18位，所以在此限定counts为1位
				Thread.sleep(1);
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Calendar calendar = Calendar.getInstance();
			if (df.format(calendar.getTime()).equals(pubTimes)) {
				counts++;
			} else {
				pubTimes = df.format(calendar.getTime());
				counts = 0;
			}
			if (id.length() == 15) {
				id = pubTimes + "00" + counts;
			} else if (id.length() == 16) {
				id = pubTimes + "0" + counts;
			} else {
				id = pubTimes + counts;
			}
			if (id.length() > 18) {
				id = id.substring(0, 18);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
