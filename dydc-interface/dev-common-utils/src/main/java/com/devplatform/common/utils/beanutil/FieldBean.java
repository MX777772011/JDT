package com.devplatform.common.utils.beanutil;

import com.devplatform.common.utils.CustomException;

public class FieldBean {
	
	/**
	 * column配置表的主键
	 */
	private Long id;
	/**
	 * table配置表的表主键
	 */
	private Long tableId;
	/**
	 * 数据库字段类型
	 */
	private String jdbcType;
	
	/**
	 * 数据库字段名
	 */
	private String jdbcName;

	/**
	 * 主键 1.主键、0.普通、2.外键
	 */
	private String key;

	/**
	 * java类的字段类型
	 */
	private String javaType;
	
	/**
	 * java类的字段名称
	 */
	private String javaName;
	
	/**
	 * java类的get方法的名称
	 */
	private String getMethodName;
	
	/**
	 * java类的set方法的名称
	 */
	private String setMethodName;
	
	/**
	 * 录入限制
	 */
	private String limitType;
	
	/**
	 * 页面类型
	 */
	private Integer pageType;
	
	/**
	 * 页面类型
	 */
	private String dataSource;
	
	/**
	 * 页面显示名称（备注）
	 */
	private String pageName;
	
	/**
	 * 是否在列表显示
	 */
	private String isShowList;
	
	/**
	 * 是否查询条件
	 */
	private String isQuery;

	/**
	 * 是否模糊查询
	 */
	private String isLike;
	
	/**
	 * 是否排序
	 */
	private String isOrder;
	
	/**
	 * 排序方式
	 */
	private String orderType;
	
	private Integer seq;
	
	public String getJavaType() {
		if(jdbcType!=null){
			if(jdbcType.indexOf("(")!=-1){
				javaType = jdbcType.substring(0, jdbcType.indexOf("("));
			}else{
				javaType = jdbcType;
			}
		}
		if(GeneratorConstant.TYPE_MAP.get(javaType.toUpperCase())==null){
			return "";
		}else{
			return GeneratorConstant.TYPE_MAP.get(javaType.toUpperCase());
		}
	}
	public String getJdbcType() {
		return jdbcType;
	}
	
	
	public String getJavaName() {
		if(jdbcName!=null){
			StringBuffer sb = new StringBuffer(jdbcName.length());
			String newstring = jdbcName.toLowerCase();
			String[] newArray = newstring.split("_");
			sb.append(newArray[0]);
			String temp = null;
			for (int i = 1; i < newArray.length; i++) {
				temp = newArray[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			javaName = sb.toString();
		}
		return javaName;
	}
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getGetMethodName() {
		if(jdbcName!=null){
			StringBuffer sb = new StringBuffer(jdbcName.length());
			String newstring = jdbcName.toLowerCase();
			String[] newArray = newstring.split("_");
			String temp = null;
			for (int i = 0; i < newArray.length; i++) {
				temp = newArray[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			getMethodName = "get"+sb.toString();
			return getMethodName;
		}
		throw new CustomException("数据库字段名称不能为空", "0101");
	}
	public String getSetMethodName() {
		if(jdbcName!=null){
			StringBuffer sb = new StringBuffer(jdbcName.length());
			String newstring = jdbcName.toLowerCase();
			String[] newArray = newstring.split("_");
			String temp = null;
			for (int i = 0; i < newArray.length; i++) {
				temp = newArray[i].trim();
				sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			}
			setMethodName = "set"+sb.toString();
			return setMethodName;
		}
		throw new CustomException("数据库字段名称不能为空", "0101");
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getTableId() {
		return tableId;
	}


	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}


	public String getJdbcName() {
		return jdbcName;
	}


	public void setJdbcName(String jdbcName) {
		this.jdbcName = jdbcName;
	}


	public String getLimitType() {
		return limitType;
	}


	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}


	public Integer getPageType() {
		return pageType;
	}


	public void setPageType(Integer pageType) {
		this.pageType = pageType;
	}


	public String getDataSource() {
		return dataSource;
	}


	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}


	public String getPageName() {
		return pageName;
	}


	public void setPageName(String pageName) {
		this.pageName = pageName;
	}


	public String getIsShowList() {
		return isShowList;
	}


	public void setIsShowList(String isShowList) {
		this.isShowList = isShowList;
	}


	public String getIsQuery() {
		return isQuery;
	}


	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}


	public void setGetMethodName(String getMethodName) {
		this.getMethodName = getMethodName;
	}


	public void setSetMethodName(String setMethodName) {
		this.setMethodName = setMethodName;
	}
	
	
	public String getIsLike() {
		return isLike;
	}
	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}
	
	
	public String getIsOrder() {
		return isOrder;
	}
	public void setIsOrder(String isOrder) {
		this.isOrder = isOrder;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	@Override
	public String toString() {
		return "FieldBean [id=" + id + ", tableId=" + tableId + ", jdbcType="
				+ jdbcType + ", jdbcName=" + jdbcName + ", key=" + key
				+ ", javaType=" + getJavaType() + ", javaName=" + getJavaName()
				+ ", getMethodName=" + getGetMethodName() + ", setMethodName="
				+ getSetMethodName() + ", limitType=" + limitType + ", pageType="
				+ pageType + ", dataSource=" + dataSource + ", pageName="
				+ pageName + ", isShowList=" + isShowList + ", isQuery="
				+ isQuery +", isLike="+isLike+ ", isOrder="+isOrder+", orderType="+orderType+", seq="+seq+"]\n";
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	
}
