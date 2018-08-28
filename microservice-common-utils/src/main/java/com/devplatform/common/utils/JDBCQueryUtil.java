package com.devplatform.common.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCQueryUtil {

	public static List<Map<String, Object>> commonQueryList(Connection conn, String sql, Object... args) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		printSQL(sql, args);
		
		try {
			ps = conn.prepareStatement(sql);
			if (args != null && args.length > 0) {
				int parameterIndex = 1;
				for (Object arg : args) {
					ps.setObject(parameterIndex, arg);
					parameterIndex++;
				}
			}

			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int count1 = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= count1; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				result.add(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}

		return result;
	}
	public static Map<String, Object> commonQueryMap(Connection conn, String sql, Object... args) {
		Map<String, Object> result = new HashMap<String, Object>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		printSQL(sql, args);
		
		try {
			ps = conn.prepareStatement(sql);
			if (args != null && args.length > 0) {
				int parameterIndex = 1;
				for (Object arg : args) {
					ps.setObject(parameterIndex, arg);
					parameterIndex++;
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int count1 = md.getColumnCount();
			while (rs.next()) {
				result = new HashMap<String, Object>();
				for (int i = 1; i <= count1; i++) {
					result.put(md.getColumnName(i), rs.getObject(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return result;
	}
	
	private static void printSQL(String sql, Object... args){
		System.out.println("sql:	"+sql);
		if(args!=null && args.length>0){
			System.out.print("parameters:	");
			int parameterIndex = 1 ;
			for (Object arg : args) {
				System.out.print("	parameter \""+parameterIndex+"\" 's value is :	" +String.valueOf(arg));
				parameterIndex++;
			}
			System.out.println();
		}
	}

}
