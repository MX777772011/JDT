package com.devplatform.${bean.serviceName}.bean;

import com.devplatform.common.bean.BaseBean;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Table;


/**
 * ${bean.className} Mapper
 * 用于${bean.tableName}的数据库对应文件
 * @author LJY
 *
 */
@Table(name = "${bean.tableName}")
@SuppressWarnings("serial")
public class ${bean.className} extends BaseBean {
	
	<#list bean.fields as field>
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	<#if field.fieldJavaName=="id">
	@Id
	@GeneratedValue(generator = "JDBC")
	<#else>
	@Column(name = "${field.fieldName}")
	</#if>
	private ${field.fieldJavaType} ${field.fieldJavaName};//${field.fieldRemark}//<#if field.fieldJavaType=="java.util.Date">日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改</#if>
	</#list>

	<#list bean.fields as field>
	/**
	 * ${field.fieldJavaName}/${field.fieldRemark}的getter方法
	 */
	public ${field.fieldJavaType} ${field.getMethodName}(){
		return ${field.fieldJavaName};
	}
	/**
	 * ${field.fieldJavaName}/${field.fieldRemark}的setter方法
	 */
	public void ${field.setMethodName}(${field.fieldJavaType} ${field.fieldJavaName}){
		this.${field.fieldJavaName} = ${field.fieldJavaName};
	}
	</#list>
}
