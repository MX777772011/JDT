package com.devplatform.business.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.devplatform.business.bean.${bean.className};
import com.devplatform.business.model.${bean.className}Model;
import com.devplatform.business.service.${bean.className}Service;
import com.devplatform.common.utils.HtmlUtil;
import com.devplatform.common.utils.ValidateUtil;
import com.devplatform.sys.action.BaseAction;
import com.devplatform.sys.constant.ResultCodeEnum;
import com.devplatform.sys.utils.ResultUtil;
import com.devplatform.sys.utils.SessionUtils;

 
@Controller
@RequestMapping("/${bean.lowerName}") 
public class ${bean.className}Action extends BaseAction{
	
	protected final static Logger log= Logger.getLogger(${bean.className}Action.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private ${bean.className}Service<${bean.className}> ${bean.lowerName}Service; 
	
	
	
	
	
	/**
	 * 进入列表页面
	 * @param model 承接对象
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView list(${bean.className}Model model) throws Exception{
		Map<String,Object> context = getRootMap();
		return forword("${bean.lowerName}/${bean.lowerName}List",context); 
	}
	
	/**
	 * 进入增加页面
	 * @param model 承接对象
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(${bean.className}Model model) throws Exception {
		Map<String, Object> context = getRootMap();
		context.put("id", model.getId());
		return forword("${bean.lowerName}/${bean.lowerName}Add", context);
	}
	/**
	 * 列表页面列表数据获取
	 * @param model 承接对象
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void datalist(${bean.className}Model model) throws Exception{
		List<${bean.className}> dataList = ${bean.lowerName}Service.queryByList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean 要操作的对象
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(${bean.className} bean) throws Exception{
		//后台验证数据
		<#list bean.fields as field>
		<#if field.canBeNull =="true"> 
		if(ValidateUtil.isEmpty(bean.${field.getMethodName}())){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.STRING_NOT_NULL.key,"${field.fieldRemark }"+ResultCodeEnum.STRING_NOT_NULL.value, null);
		}
		</#if>
		<#if field.isIdNo?? && field.isIdNo == "true">
		if(ValidateUtil.isIdCard(bean.${field.getMethodName}())){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.IDNO_FORMAT_ERROR.key,"${field.fieldRemark }"+ResultCodeEnum.IDNO_FORMAT_ERROR.value, null);
		}
		</#if>
		<#if field.isMobile?? && field.isMobile == "true"> 
		if(ValidateUtil.isMobile(bean.${field.getMethodName}())){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.PHONE_FORMAT_ERROR.key,"${field.fieldRemark }"+ResultCodeEnum.PHONE_FORMAT_ERROR.value, null);
		}
		</#if>
		<#if field.isEmail?? && field.isEmail == "true"> 
		if(ValidateUtil.isEmail(bean.${field.getMethodName}())){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.EMAIL_FORMAT_ERROR.key,"${field.fieldRemark }"+ResultCodeEnum.EMAIL_FORMAT_ERROR.value, null);
		}
		</#if>
		<#if field.fieldType =="varchar">
			<#if field.maxLength??> 
		if(ValidateUtil.isLonger(bean.${field.getMethodName}(),10)){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.LONGER_NOT_LENGTH.key,"${field.fieldRemark }"+ResultCodeEnum.LONGER_NOT_LENGTH.value, null);
		}
			</#if>
			<#if field.minLength??>
		if(ValidateUtil.isShorter(bean.${field.getMethodName}(),10)){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.SHORTER_NOT_LENGTH.key,"${field.fieldRemark }"+ResultCodeEnum.SHORTER_NOT_LENGTH.value, null);
		}
			</#if>
		</#if>
		<#if field.fieldType =="bigint" || field.fieldType == "int" || field.fieldType =="double">
			<#if field.maxLength??> 
		if(ValidateUtil.isGreeter(bean.${field.getMethodName}(),${field.maxLength})){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.GREATER_MAX.key,"${field.fieldRemark }"+ResultCodeEnum.GREATER_MAX.value, null);
		}
		    </#if>
			<#if field.minLength??>
		if(ValidateUtil.isGreeter(${field.minLength},bean.${field.getMethodName}())){
			ResultUtil.sendJsonData(response, true, ResultCodeEnum.LESSER_MIN.key,"${field.fieldRemark }"+ResultCodeEnum.LESSER_MIN.value, null);
		}
			</#if>
		</#if>
	</#list>
		
		if(bean.getId() == null){
			bean.setLastModifyBy(SessionUtils.getUserId(request));
			bean.setCreateBy(SessionUtils.getUserId(request));
			bean.setLastModifyAt(new Date());
			bean.setCreateAt(new Date());
			${bean.lowerName}Service.add(bean);
		}else{
			bean.setLastModifyBy(SessionUtils.getUserId(request));
			bean.setCreateBy(SessionUtils.getUserId(request));
			${bean.lowerName}Service.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 根据ID获取对象
	 * @param id 对象主键
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/getId")
	public void getId(String id) throws Exception{
		Map<String,Object> context = new HashMap<String,Object>();
		${bean.className} bean = ${bean.lowerName}Service.queryById(id);
		if(bean == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	
	
	/**
	 * 根据ID获取对象
	 * @param id[] 对象主键数组
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public void delete(Integer[] id) throws Exception{
		${bean.lowerName}Service.deleteFlagById(id);
		sendSuccessMessage(response, "删除成功");
	}

}
