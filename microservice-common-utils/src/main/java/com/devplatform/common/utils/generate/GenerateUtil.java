package com.devplatform.common.utils.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.devplatform.common.utils.CustomException;
import com.devplatform.common.utils.DBConnectionUtil;
import com.devplatform.common.utils.FtlUtil;
import com.devplatform.common.utils.JDBCQueryUtil;

public class GenerateUtil {
	private static final ResourceBundle GENERATE_RESOURCE_BUNDLE = ResourceBundle.getBundle("generate");

	public static void generate() {

		CreateJavaModel model = new CreateJavaModel();

		model.setTableName(GENERATE_RESOURCE_BUNDLE.getString("tablename"));
		model.setServiceName(GENERATE_RESOURCE_BUNDLE.getString("serviceName"));
		String target = GENERATE_RESOURCE_BUNDLE.getString("target");
		target = target.endsWith(File.separator) ? target : target + File.separator;
		model.setDevPath(target);
		model.setTemplateFolder(GENERATE_RESOURCE_BUNDLE.getString("templatepath"));
		model.setFields(getFields(model.getTableName()));
			
		createBean(model);
		createService(model);
		createDao(model);
		createAction(model);

	}

	private static List<FieldModel> getFields(String tableName) {
		// 要生成的表名
		String dburl = GENERATE_RESOURCE_BUNDLE.getString("dburl");
		String dbname = GENERATE_RESOURCE_BUNDLE.getString("dbname");
		String dbuser = GENERATE_RESOURCE_BUNDLE.getString("dbuser");
		String dbpassword = GENERATE_RESOURCE_BUNDLE.getString("dbpassword");
		String tableSql = "select distinct column_name, data_type, column_comment, ordinal_position, column_key, is_nullable, character_maximum_length max_length from information_schema.columns c where table_name = ? and table_schema = ? group by column_name order by ordinal_position asc";
		Connection conn = DBConnectionUtil.getMysqlConnection(dburl, dbuser, dbpassword);
		List<Map<String, Object>> results = JDBCQueryUtil.commonQueryList(conn, tableSql, tableName, dbname);
		System.out.println(results);

		List<FieldModel> fields = new ArrayList<FieldModel>();
		for(Map<String, Object> result:results){
			FieldModel field = new FieldModel();
			field.setFieldName(result.get("COLUMN_NAME").toString());
			field.setFieldRemark(result.get("COLUMN_COMMENT").toString());
			field.setFieldType(result.get("DATA_TYPE").toString());
			field.setCanBeNull(result.get("IS_NULLABLE").toString());
			fields.add(field);
		}
		
		return fields;
	}

	protected static void createBean(CreateJavaModel model) {
		createJava(model,"TempBean.ftl","bean","");
	}

	protected static void createModel(CreateJavaModel model) {
		createJava(model,"TempModel.ftl","model","Model");
	}

	protected static void createService(CreateJavaModel model) {
		createJava(model,"TempService.ftl","service","Service");
	}

	protected static void createDao(CreateJavaModel model) {
		createJava(model,"TempDao.ftl","dao","Dao");
	}

	protected static void createAction(CreateJavaModel model) {
		createJava(model,"TempController.ftl","controller","Controller");
	}

	private static void createJava(CreateJavaModel model, String tempName, String packageName, String typeName) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), tempName, root);
		content = content.replace("_#_", "#");
		writeFile(createFile(getTargetPath(model.getDevPath(), model.getServiceName(),packageName), model.getClassName()+typeName, "java"), content);
	}


	private static String getTargetPath(String target, String serviceName,String packageName) {
		return target + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "devplatform" + File.separator + serviceName + File.separator + packageName + File.separator;
	}

	private static void writeFile(File beanFile, String content) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile), "UTF-8"));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("文件出错", "0102");
		}
	}

	private static File createFile(String targetPath, String fileName, String fileExt) {

		File folder = new File(targetPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File beanFile = new File(targetPath, fileName + "." + fileExt);
		try {
			beanFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(beanFile.getPath());
			throw new CustomException("文件出错", "0102");
		}
		return beanFile;
	}

	public static void main(String[] args) {
		generate();
	}
}
