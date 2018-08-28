package com.devplatform.common.utils.generate;

import java.util.List;

import com.devplatform.common.utils.ValidateUtil;

public class CreateJavaModel {
	private int dbType;// 数据库类型
	private String ip;// 数据库ip
	private String port;// 数据库端口
	private String dbName;// 数据库名称
	private String username;// 用户名
	private String dbpwd;// 密码
	private String tableName;// 要生成的表名
	private String pfix;// 表名前缀
	private String tableRemark;// 表备注信息
	private String devPath;// 生成文件的存放路径
	private String templateFolder;//模板地址
	private String currentIndex;
	private String isShwoMenu;// 是否生成菜单
	private String isAddJsp;
	private String isBean;
	private String isController;
	private String isEditjsp;
	private String isJs;
	private String isListJsp;
	private String isMapperJava;
	private String isMapperXMl;
	private String isService;
	private String isModel;
	
	private String className;
	private String lowerName;
	private List<FieldModel> fields;// 列的集合
	private String serviceName;


	
	public String getLowerName() {
		String tempName = String.valueOf(this.tableName).toLowerCase();
		if(tempName!=null){
			if(ValidateUtil.isNotEmpty(pfix)){
				if(tempName.toLowerCase().indexOf(pfix.toLowerCase())!=-1){
					tempName = tempName.substring(tempName.toLowerCase().indexOf(pfix.toLowerCase())+pfix.length());
				}
			}
			StringBuffer sb = new StringBuffer(tempName.length());
			String tableNew = tempName.toLowerCase();
			String[] tables = tableNew.split("_");
			String temp = null;
			for (int i = 0; i < tables.length; i++) {
				temp = tables[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			lowerName = sb.toString();
			lowerName = lowerName.substring(0, 1).toLowerCase()+lowerName.substring(1);
		}
		return lowerName;
	}

	public void setLowerName(String lowerName) {
		this.lowerName = lowerName;
	}

	public String getClassName() {
		String tempName = String.valueOf(this.tableName).toLowerCase();
		if(tempName!=null){
			if(ValidateUtil.isNotEmpty(pfix)){
				if(tempName.toLowerCase().indexOf(pfix.toLowerCase())!=-1){
					tempName = tempName.substring(tempName.toLowerCase().indexOf(pfix.toLowerCase())+pfix.length());
				}
			}
			StringBuffer sb = new StringBuffer(tempName.length());
			String tableNew = tempName.toLowerCase();
			String[] tables = tableNew.split("_");
			String temp = null;
			for (int i = 0; i < tables.length; i++) {
				temp = tables[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			className = sb.toString();
		}
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	public String getDevPath() {
		return devPath;
	}

	public void setDevPath(String devPath) {
		this.devPath = devPath;
	}

	public int getDbType() {
		return dbType;
	}

	public void setDbType(int dbType) {
		this.dbType = dbType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDbpwd() {
		return dbpwd;
	}

	public void setDbpwd(String dbpwd) {
		this.dbpwd = dbpwd;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPfix() {
		return pfix;
	}

	public void setPfix(String pfix) {
		this.pfix = pfix;
	}

	public String getTableRemark() {
		return tableRemark;
	}

	public void setTableRemark(String tableRemark) {
		this.tableRemark = tableRemark;
	}

	public String getIsShwoMenu() {
		return isShwoMenu;
	}

	public void setIsShwoMenu(String isShwoMenu) {
		this.isShwoMenu = isShwoMenu;
	}

	public String getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}

	public List<FieldModel> getFields() {
		return fields;
	}

	public void setFields(List<FieldModel> fields) {
		this.fields = fields;
	}

	public String getIsAddJsp() {
		return isAddJsp;
	}

	public void setIsAddJsp(String isAddJsp) {
		this.isAddJsp = isAddJsp;
	}

	public String getIsBean() {
		return isBean;
	}

	public void setIsBean(String isBean) {
		this.isBean = isBean;
	}

	public String getIsController() {
		return isController;
	}

	public void setIsController(String isController) {
		this.isController = isController;
	}

	public String getIsEditjsp() {
		return isEditjsp;
	}

	public void setIsEditjsp(String isEditjsp) {
		this.isEditjsp = isEditjsp;
	}

	public String getIsJs() {
		return isJs;
	}

	public void setIsJs(String isJs) {
		this.isJs = isJs;
	}

	public String getIsListJsp() {
		return isListJsp;
	}

	public void setIsListJsp(String isListJsp) {
		this.isListJsp = isListJsp;
	}

	public String getIsMapperJava() {
		return isMapperJava;
	}

	public void setIsMapperJava(String isMapperJava) {
		this.isMapperJava = isMapperJava;
	}

	public String getIsMapperXMl() {
		return isMapperXMl;
	}

	public void setIsMapperXMl(String isMapperXMl) {
		this.isMapperXMl = isMapperXMl;
	}

	public String getIsService() {
		return isService;
	}

	public String getIsModel() {
		return isModel;
	}

	public void setIsModel(String isModel) {
		this.isModel = isModel;
	}

	public void setIsService(String isService) {
		this.isService = isService;
	}

	public String getTemplateFolder() {
		return templateFolder;
	}

	public void setTemplateFolder(String templateFolder) {
		this.templateFolder = templateFolder;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	
	
}
