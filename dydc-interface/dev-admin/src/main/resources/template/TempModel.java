package com.devplatform.business.model;
import com.devplatform.sys.model.BaseModel;


public class ${bean.className}Model extends BaseModel {
	
	<#list bean.fields as field>
	private ${field.fieldJavaType} ${field.fieldJavaName};//${field.fieldRemark}
	</#list>
	<#list bean.fields as field>
	/**
	 * ${field.fieldRemark}的getter方法
	 */
	public ${field.fieldJavaType} ${field.getMethodName}(){
		return ${field.fieldJavaName};
	}
	/**
	 * ${field.fieldRemark}的setter方法
	 */
	public void ${field.setMethodName}(${field.fieldJavaType} ${field.fieldJavaName}){
		this.${field.fieldJavaName} = ${field.fieldJavaName};
	}
	</#list>
}
