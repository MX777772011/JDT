package com.devplatform.common.utils.beanutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.devplatform.common.utils.CustomException;


/**
 * 自动生成MyBatis的实体类、实体映射XML文件、Mapper
 *
 * @author 李寅初
 * @date 2016-01-12
 * @version v1.0
 */
public class MybatisGeneratorUtil {

	private static MybatisGeneratorUtil instance = null;
	
	private Connection conn ;
	
	private MybatisGeneratorUtil() {
		try {
			getConn();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private Connection getConn() throws ClassNotFoundException, SQLException {
		return getConn(GeneratorConstant.DB_URL, GeneratorConstant.DB_USER,GeneratorConstant.DB_PASSWORD, GeneratorConstant.DB_DRIVER);
	}
	private Connection getConn(String DB_URL,String DB_USER,String DB_PASSWORD,String DB_DRIVER) throws ClassNotFoundException, SQLException {
		Class.forName(DB_DRIVER);
		conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
		return conn;
	}

	/**
	 * 
	 * @param table_name
	 * @return
	 */
	private ClassBean getClassBean(String table_name){
		ClassBean cb = new ClassBean();
		try {
			String table_sql = "select * from t_config_table where table_name = '"+table_name+"'";
			ResultSet tableResultSet = conn.prepareStatement(table_sql).executeQuery();
			while (tableResultSet.next()) {
				cb.setTableName(tableResultSet.getString("table_name"));
				cb.setComment(tableResultSet.getString("table_comment"));
				cb.setAuthCode(tableResultSet.getString("table_authcode"));
			}
			List<FieldBean> fbs = new ArrayList<FieldBean>();
			String field_sql = "select c.* from t_config_colmun c left join t_config_table t on c.table_id=t.id where t.table_name='"+table_name+"' order by is_show_list desc,seq";
			ResultSet fieldResultSet = conn.prepareStatement(field_sql).executeQuery();
			while (fieldResultSet.next()) {
				FieldBean fb = new FieldBean();
				fb.setId(fieldResultSet.getLong("id"));
				fb.setTableId(fieldResultSet.getLong("table_id"));
				fb.setDataSource(fieldResultSet.getString("data_source"));
				fb.setIsQuery(fieldResultSet.getString("is_query"));
				fb.setIsShowList(fieldResultSet.getString("is_show_list"));
				fb.setJdbcName(fieldResultSet.getString("jdbc_name"));
				fb.setJdbcType(fieldResultSet.getString("jdbc_type"));
				fb.setKey(fieldResultSet.getString("key"));
				fb.setLimitType(fieldResultSet.getString("limit_type"));
				fb.setPageName(fieldResultSet.getString("page_name"));
				fb.setPageType(fieldResultSet.getInt("page_type"));
				fb.setIsLike(fieldResultSet.getString("is_like"));
				fb.setIsOrder(fieldResultSet.getString("is_order"));
				fb.setOrderType(fieldResultSet.getString("order_type"));
				fb.setSeq(fieldResultSet.getInt("seq"));
				fbs.add(fb);
			}
			cb.setFields(fbs);
			System.out.println(cb);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("数据库操作失败"+e.getMessage(), "0104");
		}
		return cb;
	}
	
	private String getJavaContent(ClassBean cb, String templateName){
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", cb);
		root.put("package", GeneratorConstant.MODEL_NAME);
		return FtlUtil.analysisTemplate(GeneratorConstant.BASE_PATH+GeneratorConstant.TEMPLATE_PATH, templateName, root);
	}
	private String getXmlContent(ClassBean cb, String templateName){
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", cb);
		root.put("package", GeneratorConstant.MODEL_NAME);
		String orderby = "";
		if(cb.getHasOrder()!=0){
			orderby = orderby + "order by ";
			for(FieldBean field:cb.getFields()){
				if(field.getIsOrder().equals("1")){
					orderby = orderby+field.getJdbcName()+" "+("0".equals(field.getOrderType())?"asc":"desc")+",";
				}
			}
		}
		if(orderby.indexOf(",")!=-1){
			orderby=orderby.substring(0, orderby.lastIndexOf(","));
		}
		root.put("orderby", orderby);
		String content = FtlUtil.analysisTemplate(GeneratorConstant.BASE_PATH+GeneratorConstant.TEMPLATE_PATH, GeneratorConstant.TEMPLATE_NAME_XML, root);
		content = content.replaceAll("_#_", "#");
		return content;
	}
	private String getJspContent(ClassBean cb, String templateName){
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", cb);
		root.put("package", GeneratorConstant.MODEL_NAME);
		String content = FtlUtil.analysisTemplate(GeneratorConstant.BASE_PATH+GeneratorConstant.TEMPLATE_PATH, templateName, root);
		content = content.replace("_#_", "$");
		return content;
	}
	
	private File createFile(String targetPath,String fileName,String fileExt){
		File folder = new File(GeneratorConstant.BASE_PATH+targetPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
//		File beanFile = new File(GeneratorConstant.BASE_PATH+targetPath, cb.getBeanName() + fileExt);
		File beanFile = new File(GeneratorConstant.BASE_PATH+targetPath, fileName + fileExt);
		try {
			beanFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(beanFile.getPath());
			throw new CustomException("文件出错", "0102");
		}
		return beanFile;
	}
	
	private void writeFile(File beanFile,String content){
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile)));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("文件出错", "0102");
		}
	}
	
	protected void buildJavaFile(String targetPath,String fileName,String fileExt,ClassBean cb,String templateName){
		writeFile(createFile(targetPath,fileName,fileExt), getJavaContent(cb,templateName));
	}
	protected void buildXmlFile(String targetPath,String fileName,String fileExt,ClassBean cb,String templateName){
		writeFile(createFile(targetPath,fileName,fileExt), getXmlContent(cb,templateName));
	}
	protected void buildJspFile(String targetPath,String fileName,String fileExt,ClassBean cb,String templateName){
		writeFile(createFile(targetPath,fileName,fileExt), getJspContent(cb,templateName));
	}
	protected void buildAuthFile(String targetPath,String fileName,String fileExt,ClassBean cb,String templateName){
		writeFile(createFile(targetPath,fileName,fileExt), getJspContent(cb,templateName));
	}
	
	private void buildBean(ClassBean cb){
		buildJavaFile(GeneratorConstant.TARGET_PATH_VO,cb.getBeanName()+GeneratorConstant.VO_NAME,GeneratorConstant.FILE_EXT_JAVA,cb,GeneratorConstant.TEMPLATE_NAME_VO);
	}
	
	private void buildSearch(ClassBean cb){
		buildJavaFile(GeneratorConstant.TARGET_PATH_SEARCH,cb.getBeanName()+GeneratorConstant.SEARCH_NAME,GeneratorConstant.FILE_EXT_JAVA,cb,GeneratorConstant.TEMPLATE_NAME_SEARCH);
	}
	
	private void buildMapper(ClassBean cb){
		buildJavaFile(GeneratorConstant.TARGET_PATH_MAPPER,cb.getBeanName()+GeneratorConstant.MAPPER_NAME,GeneratorConstant.FILE_EXT_JAVA,cb,GeneratorConstant.TEMPLATE_NAME_MAPPER);
	}

	private void buildXml(ClassBean cb){
		buildXmlFile(GeneratorConstant.TARGET_PATH_XML,cb.getBeanName()+GeneratorConstant.MAPPER_NAME,GeneratorConstant.FILE_EXT_XML,cb,GeneratorConstant.TEMPLATE_NAME_XML);
	}

	private void buildControllerP(ClassBean cb){
		buildJavaFile(GeneratorConstant.TARGET_PATH_CONTROLLER,GeneratorConstant.CONTROLLER_P+cb.getBeanName()+GeneratorConstant.CONTROLLER_NAME,GeneratorConstant.FILE_EXT_JAVA,cb,GeneratorConstant.TEMPLATE_NAME_CONTROLLER_P);
	}
	
	private void buildControllerI(ClassBean cb){
		buildJavaFile(GeneratorConstant.TARGET_PATH_CONTROLLER,GeneratorConstant.CONTROLLER_I+cb.getBeanName()+GeneratorConstant.CONTROLLER_NAME,GeneratorConstant.FILE_EXT_JAVA,cb,GeneratorConstant.TEMPLATE_NAME_CONTROLLER_I);
	}
	
	private void buildService(ClassBean cb){
		buildJavaFile(GeneratorConstant.TARGET_PATH_SERVICE,cb.getBeanName()+GeneratorConstant.SERVICE_NAME,GeneratorConstant.FILE_EXT_JAVA,cb,GeneratorConstant.TEMPLATE_NAME_SERVICE);
	}

	private void buildImpl(ClassBean cb){
		buildJavaFile(GeneratorConstant.TARGET_PATH_SERVICE_IMPL,cb.getBeanName()+GeneratorConstant.SERVICE_IMPL_NAME,GeneratorConstant.FILE_EXT_JAVA,cb,GeneratorConstant.TEMPLATE_NAME_SERVICE_IMPL);
	}
	
	private void buildList(ClassBean cb){
		buildJspFile(GeneratorConstant.TARGET_PATH_JSP+cb.getBeanName().toLowerCase()+"/",GeneratorConstant.JSP_LIST_NAME,GeneratorConstant.FILE_EXT_JSP,cb,GeneratorConstant.TEMPLATE_NAME_LIST);
	}
	
	private void buildAdd(ClassBean cb){
		buildJspFile(GeneratorConstant.TARGET_PATH_JSP+cb.getBeanName().toLowerCase()+"/",GeneratorConstant.JSP_ADD_NAME,GeneratorConstant.FILE_EXT_JSP,cb,GeneratorConstant.TEMPLATE_NAME_ADD);
	}

	private void buildEdit(ClassBean cb){
		buildJspFile(GeneratorConstant.TARGET_PATH_JSP+cb.getBeanName().toLowerCase()+"/",GeneratorConstant.JSP_EDIT_NAME,GeneratorConstant.FILE_EXT_JSP,cb,GeneratorConstant.TEMPLATE_NAME_EDIT);
	}
	private void buildView(ClassBean cb){
		buildJspFile(GeneratorConstant.TARGET_PATH_JSP+cb.getBeanName().toLowerCase()+"/",GeneratorConstant.JSP_VIEW_NAME,GeneratorConstant.FILE_EXT_JSP,cb,GeneratorConstant.TEMPLATE_NAME_VIEW);
	}
	private void buildAuth(ClassBean cb){
		buildAuthFile(GeneratorConstant.TARGET_PATH_AUTH+cb.getBeanName().toLowerCase()+"/",cb.getBeanName(),GeneratorConstant.FILE_EXT_JSON,cb,GeneratorConstant.TEMPLATE_NAME_AUTH);
	}



	public static MybatisGeneratorUtil getInstance() {
		if (instance == null) {
			instance = new MybatisGeneratorUtil();
		}
		return instance;
	}
	
	public void generateAll() {
		try {
			List<String> tables = new ArrayList<String>();
			ResultSet tablesResults = conn.prepareStatement("show tables").executeQuery();
			while (tablesResults.next()) {
				String tableName = tablesResults.getString(1);
				tables.add(tableName);
			}
			for(String table_name:tables){
				generate(table_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
	}
	
	public void generate(String table_name) {
			ClassBean cb = getClassBean(table_name);
			generateBean(cb,table_name);
			generateSearch(cb,table_name);
			generateMapper(cb,table_name);
			generateXml(cb,table_name);
			generateControllerP(cb,table_name);
			generateControllerI(cb,table_name);
			generateService(cb,table_name);
			generateImpl(cb,table_name);
			generateList(cb,table_name);
			generateAdd(cb,table_name);
			generateEdit(cb,table_name);
			generateView(cb,table_name);
			generateAuth(cb,table_name);
	}
	
	private void generateBean(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildBean(cb);
	}
	private void generateSearch(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildSearch(cb);
	}
	private void generateMapper(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildMapper(cb);
	}
	private void generateXml(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildXml(cb);
	}
	private void generateControllerP(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildControllerP(cb);
	}
	private void generateControllerI(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildControllerI(cb);
	}
	private void generateService(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildService(cb);
	}
	private void generateImpl(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildImpl(cb);
	}
	private void generateList(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		Sorts.sortByQuery(cb.getFields());
		buildList(cb);
	}
	private void generateAdd(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildAdd(cb);
	}
	private void generateEdit(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildEdit(cb);
	}
	private void generateView(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildView(cb);
	}
	private void generateAuth(ClassBean cb,String table_name) {
		if(cb==null){
			cb = getClassBean(table_name);
		}
		buildAuth(cb);
	}
	
	public void generateBean(String table_name) {generateBean(null,table_name);}
	public void generateSearch(String table_name) {generateSearch(null,table_name);}
	public void generateMapper(String table_name) {generateMapper(null,table_name);}
	public void generateXml(String table_name) {generateXml(null,table_name);}
	public void generateControllerP(String table_name) {generateControllerP(null,table_name);}
	public void generateControllerI(String table_name) {generateControllerI(null,table_name);}
	public void generateService(String table_name) {generateService(null,table_name);}
	public void generateImpl(String table_name) {generateImpl(null,table_name);}
	public void generateList(String table_name) {generateList(null,table_name);}
	public void generateAdd(String table_name) {generateAdd(null,table_name);}
	public void generateEdit(String table_name) {generateEdit(null,table_name);}
	public void generateView(String table_name) {generateView(null,table_name);}
	public void generateAuth(String table_name) {generateAuth(null,table_name);}
	
}
