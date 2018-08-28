package com.devplatform.sys.action;

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

import javax.servlet.http.HttpServletRequest;

//import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.devplatform.common.idgen.IdGenerator;
import com.devplatform.common.utils.CustomException;
import com.devplatform.common.utils.DBConnectionUtil;
import com.devplatform.common.utils.JDBCQueryUtil;
import com.devplatform.common.utils.ValidateUtil;
import com.devplatform.common.utils.beanutil.FtlUtil;
import com.devplatform.sys.bean.SysMenu;
import com.devplatform.sys.bean.SysMenuBtn;
import com.devplatform.sys.model.CreateJavaModel;
import com.devplatform.sys.model.FieldModel;
import com.devplatform.sys.service.SysMenuService;

@Controller
@ResponseBody
@RequestMapping("/sys/createjava")
public class CreateJavaAction extends BaseAction {

	protected final static Logger log = Logger.getLogger(CreateJavaAction.class);
	private ResourceBundle res = null;

	
	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(CreateJavaModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		res = ResourceBundle.getBundle("config/default/createJava");
		String defaultUrl = res.getString("gpt.url");
		String defaultIp = getIpFromUrl(defaultUrl);
		String defaultPort = getPortFromUrl(defaultUrl);
		String defaultDb = getDBFromUrl(defaultUrl);
		String defaultUserName = res.getString("gpt.username");
		String defaultPassword = res.getString("gpt.password");
		String devPath = res.getString("gpt.devPath");
		devPath = new String(res.getString("gpt.devPath").getBytes("ISO-8859-1"),"UTF-8");
		// 设置页面数据
		context.put("defaultIp", defaultIp);
		context.put("defaultPort", defaultPort);
		context.put("defaultDb", defaultDb);
		context.put("defaultUserName", defaultUserName);
		context.put("defaultPassword", defaultPassword);
		context.put("devPath", devPath);
		return forword("sys/create", context);
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/viewTable")
	public Map<String, Object> viewTable(CreateJavaModel model, HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
	
			String tableSql = "select distinct column_name, data_type, column_comment, ordinal_position, column_key, is_nullable, character_maximum_length max_length from information_schema.columns c where table_name = ? and table_schema = ? group by column_name order by ordinal_position asc";
			Connection conn = null;
			if (model.getDbType() == 1) {
				String url = "jdbc:mysql://_ip_:_port_/_dbName_?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true";
				url = url.replaceAll("_ip_", model.getIp()).replaceAll("_port_", model.getPort()).replaceAll("_dbName_", model.getDbName());
				try {
					conn = DBConnectionUtil.getMysqlConnection(url, model.getUsername(), model.getDbpwd());
					context.put("success", true);
					context.put("msg", "验证成功");
				} catch (Exception e) {
					context.put("success", false);
					context.put("msg", e.toString() );
				}
			} else if (model.getDbType() == 2) {
				// conn = DBConnectionUtil.getOracleConnection(url,
				// model.getUsername(), model.getDbpwd());
				return null;// 暂时由于没有写获取连接等方法，为避免后续报错，此处返回null，不执行后续语句
			} else if (model.getDbType() == 3) {

				return null;// 暂时由于没有写获取连接等方法，为避免后续报错，此处返回null，不执行后续语句
			} else if (model.getDbType() == 4) {

				return null;// 暂时由于没有写获取连接等方法，为避免后续报错，此处返回null，不执行后续语句
			} else {
				return null;// 暂时由于没有写获取连接等方法，为避免后续报错，此处返回null，不执行后续语句
			}

			if(model.getCurrentIndex() != null && model.getCurrentIndex().equals("1")){
				return context;
			}
			List<Map<String, Object>> results = JDBCQueryUtil.commonQueryList(conn, tableSql, model.getTableName(), model.getDbName());
			if(results!=null && results.size()>0){
				for(Map<String, Object> result:results){
					result.put("MAX_LENGTH", result.get("CHARACTER_MAXIMUM_LENGTH"));
				}
				context.put("data", results);
				context.put("success", true);
				context.put("msg","验证成功");
			}else{
				context.put("success", false);
				context.put("msg","没有此表" );
			}
		return context;
	}

	private String getIpFromUrl(String source) {
		if (ValidateUtil.isNotEmpty(source)) {
			String[] temp = source.split(":");
			if (temp != null && temp.length == 4) {
				return temp[2].replaceAll("//", "");
			}
		}

		return source;
	}

	private static String getPortFromUrl(String source) {
		if (ValidateUtil.isNotEmpty(source)) {
			String[] temp = source.split(":");
			if (temp != null && temp.length == 4) {
				return temp[3].split("/")[0];
			}
		}
		return source;
	}

	private static String getDBFromUrl(String source) {
		if (ValidateUtil.isNotEmpty(source)) {
			String[] temp = source.split(":");
			if (temp != null && temp.length == 4) {
				return temp[3].split("/")[1];
			}
		}
		return source;
	}
	
	private String mysqlDBUrl(CreateJavaModel model){
		String url = "jdbc:mysql://_ip_:_port_/_dbName_?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true";
		url = url.replaceAll("_ip_", model.getIp()).replaceAll("_port_", model.getPort()).replaceAll("_dbName_", model.getDbName());
		return url;
	}
	
	private List<FieldModel> getFieldsFromJSON(String json_string){
		if(ValidateUtil.isEmpty(json_string)){
			return null;
		}
		JSONArray jsonArray = null;
		try {
			jsonArray = JSONArray.parseArray(json_string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(jsonArray == null){
			return null;
		}
		
		List<FieldModel> fields = new ArrayList<FieldModel>();
		for(int i=0 ;i<jsonArray.size();i++){
			JSONObject x = (JSONObject) jsonArray.get(i);
			FieldModel field = new FieldModel();
			if(x.containsKey("IS_NULLABLE")){
				field.setCanBeNull(x.getString("IS_NULLABLE"));
			}
			if(x.containsKey("ENUMAT")){
				field.setEnumString(x.getString("ENUMAT"));
			}
			if(x.containsKey("COLUMN_NAME")){
				field.setFieldName(x.getString("COLUMN_NAME"));
			}
			if(x.containsKey("COLUMN_COMMENT")){
				field.setFieldRemark(x.getString("COLUMN_COMMENT"));
			}
			if(x.containsKey("DATA_TYPE")){
				field.setFieldType(x.getString("DATA_TYPE"));
			}
			if(x.containsKey("IS_EMAIL")){
				field.setIsEmail(x.getString("IS_EMAIL"));
			}
			if(x.containsKey("IS_IDNO")){
				field.setIsIdNo(x.getString("IS_IDNO"));
			}
			if(x.containsKey("IS_MOBILE")){
				field.setIsMobile(x.getString("IS_MOBILE"));
			}
			if(x.containsKey("MAX_LENGTH")){
				String t = x.getString("MAX_LENGTH");
				if(ValidateUtil.isNotEmpty(t)){
					field.setMaxLength(Integer.parseInt(t));
				}
			}
			if(x.containsKey("MIN_LENGTH")){
				String t = x.getString("MIN_LENGTH");
				if(ValidateUtil.isNotEmpty(t)){
					field.setMaxLength(Integer.parseInt(t));
				}
			}
			if(x.containsKey("REGEX")){
				field.setRegexString(x.getString("REGEX"));
			}
			fields.add(field);
		}
		System.out.println(fields);
		
		return fields;
		
	}
	
	/**
	 * 生成文件
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createFile")
	public Map<String, Object> createFile(CreateJavaModel model,String json_string, HttpServletRequest request) {
		Map<String, Object> contextReturn = getRootMap();
		String returnString = "生成成功，请查看菜单";
		mysqlDBUrl(model);//拼接数据库连接字符串
		model.setPfix(ResourceBundle.getBundle("config/default/createJava").getString("gpt.pfix"));
		model.setFields(getFieldsFromJSON(json_string));
		model.setTemplateFolder(request.getSession().getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"classes"+File.separator+"template");
		create(model);
		//判断是否生成菜单
		insertMenu(model);
	    contextReturn.put("success", true);
	    contextReturn.put("msg",returnString);
		return contextReturn;
	}

	private void insertMenu(CreateJavaModel model) {
		 if(model.getIsShwoMenu()!=null && model.getIsShwoMenu().equals("1")){
				try {
					//最后增加到Menu表当中
					List<SysMenuBtn> btnList=new ArrayList<SysMenuBtn>();
					SysMenuBtn smb=new SysMenuBtn();
					smb.setId(IdGenerator.generateId());
					smb.setBtnName("添加");
					smb.setBtnType("add");
					smb.setActionUrls("save.do");
					SysMenuBtn smb2=new SysMenuBtn();
					smb2.setId(IdGenerator.generateId());
					smb2.setBtnName("修改");
					smb2.setBtnType("edit");
					smb2.setActionUrls("getId.do|save.do");
					SysMenuBtn smb3=new SysMenuBtn();
					smb3.setId(IdGenerator.generateId());
					smb3.setBtnName("删除");
					smb3.setBtnType("remove");
					smb3.setActionUrls("delete.do");
					btnList.add(smb);
					btnList.add(smb2);
					btnList.add(smb3);
					SysMenu sm=new SysMenu();
					sm.setId(IdGenerator.generateId());
					sm.setName(model.getTableRemark());
					sm.setBtns(btnList);
					sm.setUrl("/"+model.getLowerName()+"/list.shtml");
					sm.setRank(99);
					sm.setActions("dataList.do");
					sm.setParentId("1");//暂时放在系统管理里边
					sm.setDeleted(0);
					@SuppressWarnings("resource")
					ApplicationContext appContent = new ClassPathXmlApplicationContext( new String[] { "spring-*.xml" });
					@SuppressWarnings("unchecked")
					SysMenuService<SysMenu> sysMenuService = (SysMenuService<SysMenu>) appContent.getBean("sysMenuService");
					sysMenuService.add(sm);
					System.out.println("成功添加到菜单表中，ID是"+sm.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		
	}

	private void create(CreateJavaModel model) {
		if("1".equals(model.getIsBean())){
			createBean(model);
		}
		if("1".equals(model.getIsController())){
			createController(model);
		}
		if("1".equals(model.getIsJs())){
			createJs(model);
		}
		if("1".equals(model.getIsListJsp())){
			createListJsp(model);
		}
		if("1".equals(model.getIsMapperJava())){
			createMapperJava(model);
		}
		if("1".equals(model.getIsMapperXMl())){
			createMapperXML(model);
		}
		if("1".equals(model.getIsService())){
			createService(model);
		}
		if("1".equals(model.getIsModel())){
			createModel(model);
		}
	}

	private void createService(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempService.java", root);
		content = content.replace("_#_", "$");
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"devplatform"+File.separator+"business"+File.separator+"service"+File.separator,model.getClassName()+"Service","java"), content);
	}

	private void createMapperXML(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempMapper.xml", root);
		content = content.replace("_$_", "$");
		content = content.replace("_#_", "#");
		System.out.println(content);
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"devplatform"+File.separator+"business"+File.separator+"mybatis"+File.separator,model.getClassName()+"Mapper","xml"), content);
		// TODO Auto-generated method stub 需要补充修改mybatis.XML的方法
	}

	private void createMapperJava(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempMapper.java", root);
		content = content.replace("_#_", "$");
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"devplatform"+File.separator+"business"+File.separator+"mapper"+File.separator,model.getClassName()+"Mapper","java"), content);
	}

	private void createListJsp(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempList.jsp", root);
		content = content.replace("_#_", "$");
		System.out.println("--------------------->jsp"+content);
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"webapp"+File.separator+"WEB-INF"+File.separator+"view"+File.separator+model.getLowerName()+File.separator,model.getLowerName()+"List","jsp"), content);
	}

	private void createJs(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempJs.js", root);
		content = content.replace("_#_", "$");
		System.out.println("--------------------->js"+content);
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"webapp"+File.separator+"js"+File.separator+model.getLowerName()+File.separator,model.getLowerName(),"js"), content);
	}

	private void createController(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempController.java", root);
		content = content.replace("_#_", "$");
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"devplatform"+File.separator+"business"+File.separator+"action"+File.separator,model.getClassName()+"Action","java"), content);
	}

	private void createBean(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempBean.java", root);
		content = content.replace("_#_", "$");
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"devplatform"+File.separator+"business"+File.separator+"bean"+File.separator,model.getClassName(),"java"), content);
	}
	private void createModel(CreateJavaModel model) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("bean", model);
		String content = FtlUtil.analysisTemplate(model.getTemplateFolder(), "TempModel.java", root);
		content = content.replace("_#_", "$");
		writeFile(createFile(model.getDevPath()+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"devplatform"+File.separator+"business"+File.separator+"model"+File.separator,model.getClassName()+"Model","java"), content);
	}

	private void writeFile(File beanFile,String content){
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile),"UTF-8"));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("文件出错", "0102");
		}
	}
	private File createFile(String targetPath,String fileName,String fileExt){
		
		File folder = new File(targetPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File beanFile = new File(targetPath, fileName +"."+ fileExt);
		try {
			beanFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(beanFile.getPath());
			throw new CustomException("文件出错", "0102");
		}
		return beanFile;
	}
}
