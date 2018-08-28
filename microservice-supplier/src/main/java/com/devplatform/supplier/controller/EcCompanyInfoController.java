package com.devplatform.supplier.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


import com.devplatform.common.result.CommonResult;
import com.devplatform.common.result.ResultUtil;
import com.devplatform.common.utils.CustomException;
import com.devplatform.common.utils.ValidateUtil;


import com.devplatform.supplier.bean.EcCompanyInfo;
import com.devplatform.supplier.service.EcCompanyInfoService;

/**
 * EcCompanyInfo controller
 * 用于ec_company_info的接口
 * @author zsb
 *
 */
@Api(value = "EcCompanyInfoController", description = "系统自动生成接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping("/ecCompanyInfo") 
public class EcCompanyInfoController {
	
	protected final static Logger log= LoggerFactory.getLogger(EcCompanyInfoController.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private EcCompanyInfoService ecCompanyInfoService; 
	
	/**
	 * 列表页面列表数据获取
	 * @param model 承接对象
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation("请求数据列表")
	@RequestMapping(value = "/page",method = RequestMethod.GET) 
	public CommonResult page(EcCompanyInfo model){
	
		try {
			List<EcCompanyInfo> dataList = ecCompanyInfoService.queryByList(model);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("total", 5);// TODO
			jsonMap.put("rows", dataList);

			return ResultUtil.getSuccess(jsonMap);
		} catch (CustomException e) {
			e.printStackTrace();
			return ResultUtil.getFailed(e.getErrCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.getCommonFailed();
		}
	}
	
	/**
	 * 添加或修改数据
	 * @param bean 要操作的对象
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation("保存数据")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public CommonResult save(EcCompanyInfo bean){
		
		try {
			if (ValidateUtil.isEmpty(bean.getId())) {
//				bean.setCreateUserId(getUserIdFromToken(request));
//				bean.setUpdateUserId(getUserIdFromToken(request));
				bean.setCreateTime(new Date());
				bean.setUpdateTime(new Date());
				bean.setDelFlag(0);
				ecCompanyInfoService.add(bean);
			}else{
//				bean.setUpdateUserId(getUserIdFromToken(request));
				bean.setUpdateTime(new Date());
				ecCompanyInfoService.updateBySelective(bean);
			}
			return ResultUtil.getSuccess();
		} catch (CustomException e) {
			e.printStackTrace();
			return ResultUtil.getFailed(e.getErrCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.getCommonFailed();
		}
	}
	
	/**
	 * 获取数据
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("根据主键获取")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public CommonResult get(@PathVariable long id) {
		try {
			EcCompanyInfo bean = ecCompanyInfoService.queryById(id);
			if(bean == null){
				return ResultUtil.getFailed("010101", "没有找到数据");
			}
			return ResultUtil.getSuccess(bean);
		} catch (CustomException e) {
			e.printStackTrace();
			return ResultUtil.getFailed(e.getErrCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.getCommonFailed();
		}

	}
	
	
	
	/**
	 * 根据ID获取对象伪删除
	 * @param id[] 对象主键数组
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation("删除数据")
	@RequestMapping(value = "/delete", method = RequestMethod.PUT)
	public CommonResult delete(long... id){
		
		try {
			ecCompanyInfoService.deleteFlagById(id);
			return ResultUtil.getSuccess();
		} catch (CustomException e) {
			e.printStackTrace();
			return ResultUtil.getFailed(e.getErrCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.getCommonFailed();
		}
	}

}
