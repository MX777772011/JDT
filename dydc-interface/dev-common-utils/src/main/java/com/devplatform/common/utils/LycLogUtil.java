package com.devplatform.common.utils;

import org.apache.log4j.Logger;

public class LycLogUtil {

	protected final static Logger log = Logger.getLogger("mylog");

	public static int type = 2;

	public static void info(Object message){
		switch (type) {
		case 1:
			System.out.println(message);
			break;
		case 2:
			log.error(message);
			break;

		default:
			break;
		}
		
	}
}
