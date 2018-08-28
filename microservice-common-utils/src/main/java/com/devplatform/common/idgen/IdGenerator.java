package com.devplatform.common.idgen;

import java.util.HashSet;
import java.util.Set;

import com.devplatform.common.utils.StringUtil;



public class IdGenerator {
	
	public  synchronized static String generateId() throws Exception{
		//目前先按照改造的snowflake进行初始化
		//未来如果需要更换，改这个generateId方法即可
		return StringUtil.ObjectToString(SnowflakeIpBind.getInstance().nextId());
	}
	
	 public static void main(String[] args) throws Exception{
		 Long time1=System.currentTimeMillis();
		 Set<String> sets=new HashSet<String>();
		 for(int i=0;i<1000000;i++){
			 sets.add(generateId());
		 }
		 System.out.println("生成1000000记录");
		 System.out.println("实际生成数："+sets.size());
		 System.out.println("用时"+(System.currentTimeMillis() - time1)+"ms");
		 System.out.println(1000000 == sets.size());
	 }
	
}