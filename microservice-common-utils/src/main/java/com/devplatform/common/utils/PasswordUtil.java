package com.devplatform.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordUtil {

	public static String hashPwd(String pwd) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return new BigInteger(1, md5.digest(pwd.getBytes("utf-8"))).toString(16);
		} catch (Exception e) {
			throw new CustomException("MD5加密出错。");
		}
	}

	public static void main(String[] args) {
		System.out.println(hashPwd("123456"));
	}
}
