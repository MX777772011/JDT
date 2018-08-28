package com.devplatform.common.utils;

import java.util.Comparator;

public class FileOrderUtils implements Comparator<String> {

	// 此类实现Comparable接口
	@Override
	public int compare(String s1, String s2) {
		if (FileOrderUtils.returnDouble(s1) < FileOrderUtils.returnDouble(s2))
			return -1;
		else if (FileOrderUtils.returnDouble(s1) > FileOrderUtils.returnDouble(s2))
			return 1;
		else
			return 0;

	}

	public static double returnDouble(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				sb.append(str.charAt(i));
			else if (str.charAt(i) == '.' && i < str.length() - 1 && Character.isDigit(str.charAt(i + 1)))
				sb.append(str.charAt(i));
			else
				break;
		}
		if (sb.toString().isEmpty())
			return 0;
		else
			return Double.parseDouble(sb.toString());
	}
}
