package com.devplatform.common.utils.generate;

import java.util.HashMap;
import java.util.Map;

public class GeneratorConstant {

	public static final Map<String, String> TYPE_MAP = getMap();

	private static Map<String, String> getMap() {
		Map<String, String> typeMap = new HashMap<String, String>();
		typeMap.put("CHAR", "java.lang.String");
		typeMap.put("VARCHAR", "java.lang.String");
		typeMap.put("LONGVARCHAR", "java.lang.String");
		typeMap.put("LONGTEXT", "java.lang.String");
		typeMap.put("TEXT", "java.lang.String");
		typeMap.put("NUMERIC", "java.math.BigDecimal");
		typeMap.put("DECIMAL", "java.math.BigDecimal");
		typeMap.put("BIT", "Boolean");
		typeMap.put("BOOLEAN", "Boolean");
		typeMap.put("TINYINT", "Byte");
		typeMap.put("SMALLINT", "Short");
		typeMap.put("INTEGER", "Integer");
		typeMap.put("INT", "Integer");
		typeMap.put("BIGINT", "Long");
		typeMap.put("REAL", "Float");
		typeMap.put("FLOAT", "Double");
		typeMap.put("DOUBLE", "Double");
		typeMap.put("BINARY", "Byte[]");
		typeMap.put("VARBINARY", "Byte[]");
		typeMap.put("LONGVARBINARY", "Byte[]");
		typeMap.put("DATE", "java.util.Date");
		typeMap.put("DATETIME", "java.util.Date");
		typeMap.put("TIME", "java.util.Date");
		typeMap.put("TIMESTAMP", "java.util.Date");
		typeMap.put("CLOB", "java.sql.Clob");
		typeMap.put("BLOB", "java.sql.Blob");
		return typeMap;
	}

}
