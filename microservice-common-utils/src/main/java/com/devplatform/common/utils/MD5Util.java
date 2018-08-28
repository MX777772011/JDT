package com.devplatform.common.utils;

import java.security.MessageDigest;

public class MD5Util {
	public static String md5Encode(String inStr) {
		try {
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (Exception e) {
				System.err.println(e.toString());
				e.printStackTrace();
				return "";
			}

			byte[] byteArray = inStr.getBytes("UTF-8");
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = md5Bytes[i] & 0xFF;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString().toUpperCase();
		} catch (Exception e) {
		}
		return "MD5-ERROR";
	}

	public static String md5EncodeTwo(String inStr) {

		String md5String = md5Encode(inStr);

		String resultString = "";
		char[] charArray = md5String.toCharArray();

		for (int i = charArray.length - 1; i >= 0; i--) {
			resultString += charArray[i];
		}
		return resultString;
	}

	public static void main(String[] args) throws Exception {
		String str = new String("abcdefg111");
		System.out.println("原始：" + str);
		System.out.println("MD5后：" + md5Encode(str));
	}
}