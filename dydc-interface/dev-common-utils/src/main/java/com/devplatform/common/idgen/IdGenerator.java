package com.devplatform.common.idgen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devplatform.common.utils.CustomException;
import com.devplatform.common.utils.StringUtil;

public class IdGenerator {

	public synchronized static String generateId() throws Exception {
		// 目前先按照改造的snowflake进行初始化
		// 未来如果需要更换，改这个generateId方法即可
		return StringUtil.ObjectToString(SnowflakeIpBind.getInstance().nextId());
		// return
		// StringUtil.ObjectToString(UUID.randomUUID().toString().replaceAll("-",
		// ""));
	}

	public static void main(String[] args) throws Exception {
		List<String> ids = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new FileReader("/Users/liyinchu/Desktop/id/2.txt"));

		String s = null;

		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行

			ids.add(s);
		}
		br.close();

		System.out.println(ids.size());
		Set<String> generates = new HashSet<String>();
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 1000000; i++) {
			generates.add(generateId());
		}
		System.out.println(generates.size());
		System.out.println(System.currentTimeMillis());
		int i=0;
		for (String id : ids) {
			for (String generate : generates) {
				if (id.equals(generate)) {
					System.err.println(id);
					throw new CustomException(id);
				}
			}
			if(i%100==0){
				System.out.println(i+"	"+System.currentTimeMillis());
			}
			i++;
		}
	}

}