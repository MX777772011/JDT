package com.devplatform.common.utils.beanutil;

import java.util.HashMap;
import java.util.Map;

public class GeneratorConstant {
	public static final String BASE_PATH = "/Users/Administrator/.ssh/gain";
	public static final String MODEL_NAME = "lhjt";
	public static final String TABLE_PREFIX = "t_";

	public static final String VO_NAME = "";
	public static final String SEARCH_NAME = "Search";
	public static final String MAPPER_NAME = "Mapper";
	public static final String SERVICE_NAME = "Service";
	public static final String SERVICE_IMPL_NAME = "ServiceImpl";
	public static final String CONTROLLER_NAME = "Controller";
	public static final String CONTROLLER_P = "P";
	public static final String CONTROLLER_I = "I";
	public static final String JSP_LIST_NAME = "list";
	public static final String JSP_ADD_NAME = "add";
	public static final String JSP_EDIT_NAME = "edit";
	public static final String JSP_VIEW_NAME = "view";

	public static final String FILE_EXT_JAVA = ".java";
	public static final String FILE_EXT_XML = ".xml";
	public static final String FILE_EXT_JSP = ".jsp";
	public static final String FILE_EXT_HTML = ".html";
	public static final String FILE_EXT_JS = ".js";
	public static final String FILE_EXT_JSON = ".json";
	

	
	public static final String TEMPLATE_PATH = "/src/main/resources/template/";
	
	public static final String TEMPLATE_NAME_VO = "vo.ftl";
	public static final String TEMPLATE_NAME_MAPPER = "mapper.ftl";
	public static final String TEMPLATE_NAME_XML = "xml.ftl";
	public static final String TEMPLATE_NAME_EXT = "ext.ftl";
	public static final String TEMPLATE_NAME_SEARCH = "search.ftl";
	public static final String TEMPLATE_NAME_SERVICE = "service.ftl";
	public static final String TEMPLATE_NAME_SERVICE_IMPL = "serviceImpl.ftl";
	public static final String TEMPLATE_NAME_CONTROLLER_P = "controller_page.ftl";
	public static final String TEMPLATE_NAME_CONTROLLER_I = "controller_interface.ftl";
	public static final String TEMPLATE_NAME_LIST = "jsp_list.ftl";
	public static final String TEMPLATE_NAME_ADD = "jsp_add.ftl";
	public static final String TEMPLATE_NAME_EDIT = "jsp_edit.ftl";
	public static final String TEMPLATE_NAME_VIEW = "jsp_view.ftl";
	public static final String TEMPLATE_NAME_AUTH = "auth.json.ftl";

	public static final String TARGET_PATH_VO = "/xx/main/java/com/"+MODEL_NAME+"/db/";
	public static final String TARGET_PATH_SEARCH = "/xx/main/java/com/"+MODEL_NAME+"/search/";
	public static final String TARGET_PATH_MAPPER = "/xx/main/java/com/"+MODEL_NAME+"/mapper/";
	public static final String TARGET_PATH_XML = "/xx/main/resources/mapper/";
	public static final String TARGET_PATH_EXT = "/xx/main/java/com/"+MODEL_NAME+"/ext/";
	public static final String TARGET_PATH_SERVICE = "/xx/main/java/com/"+MODEL_NAME+"/service/";
	public static final String TARGET_PATH_SERVICE_IMPL = "/xx/main/java/com/"+MODEL_NAME+"/service/impl/";
	public static final String TARGET_PATH_CONTROLLER = "/xx/main/java/com/"+MODEL_NAME+"/controller/";
	public static final String TARGET_PATH_JSP = "/xx/main/webapp/WEB-INF/jsp/";
	public static final String TARGET_PATH_AUTH = "/xx/main/resources/conf/m/";
	
	
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "root";
	public static final String DB_URL = "jdbc:mysql://10.0.0.250:3306/gain?characterEncoding=utf8";
	
	public static final Map<String,String> TYPE_MAP = getMap();
	
	private static Map<String, String> getMap() {
		Map<String,String> typeMap = new HashMap<String, String>();
		typeMap.put("CHAR","java.lang.String");
		typeMap.put("VARCHAR","java.lang.String");
		typeMap.put("LONGVARCHAR","java.lang.String");
		typeMap.put("LONGTEXT","java.lang.String");
		typeMap.put("TEXT","java.lang.String");
		typeMap.put("NUMERIC","java.math.BigDecimal");
		typeMap.put("DECIMAL","java.math.BigDecimal");
		typeMap.put("BIT","Boolean");
		typeMap.put("BOOLEAN","Boolean");
		typeMap.put("TINYINT","Byte");
		typeMap.put("SMALLINT","Short");
		typeMap.put("INTEGER","Integer");
		typeMap.put("INT","Integer");
		typeMap.put("BIGINT","Long");
		typeMap.put("REAL","Float");
		typeMap.put("FLOAT","Double");
		typeMap.put("DOUBLE","Double");
		typeMap.put("BINARY","Byte[]");
		typeMap.put("VARBINARY","Byte[]");
		typeMap.put("LONGVARBINARY","Byte[]");
		typeMap.put("DATE","java.util.Date");
		typeMap.put("DATETIME","java.util.Date");
		typeMap.put("TIME","java.util.Date");
		typeMap.put("TIMESTAMP","java.util.Date");
		typeMap.put("CLOB","java.sql.Clob");
		typeMap.put("BLOB","java.sql.Blob");
		return typeMap;
	}

}
