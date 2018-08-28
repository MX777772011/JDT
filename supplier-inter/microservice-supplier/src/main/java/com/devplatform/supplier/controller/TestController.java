package com.devplatform.supplier.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devplatform.common.result.CommonResult;
import com.devplatform.common.result.ResultUtil;
import com.devplatform.common.utils.CustomException;
import com.devplatform.common.utils.ValidateUtil;
import com.devplatform.supplier.feign.bean.TestUser;
import com.devplatform.supplier.service.TestService;

/**
 * DeleteUser controller 用于delete_user的接口
 * 
 * @author liyinchu
 *
 */
@Api(value = "DeleteUserController", description = "系统自动生成接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping("/testsupplier")
public class TestController {

	@Autowired
	private TestService testService;
	
	
	/**
	 * 列表页面列表数据获取
	 * 
	 * @param model
	 *            承接对象
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("请求数据列表")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public CommonResult get(@PathVariable long id) {

		try {
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("total", 5);// TODO
			jsonMap.put("rows", testService.queryById(id));
			return ResultUtil.getSuccess(jsonMap);
		} catch (CustomException e) {
			e.printStackTrace();
			return ResultUtil.getFailed(e.getErrCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.getCommonFailed();
		}
	}
	
	
	@ApiOperation("保存数据")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public CommonResult save(TestUser bean){
		try {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.YEAR, 1);
			if (ValidateUtil.isEmpty(bean.getId())) {
				bean.setCreateUserId(1L);
				bean.setUpdateUserId(1L);
				bean.setCreateTime(c.getTime());
				bean.setUpdateTime(new Date());
				bean.setDelFlag(0);
				testService.add(bean);
			}else{
				bean.setUpdateUserId(2L);
				bean.setUpdateTime(new Date());
				testService.updateBySelective(bean);
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

}
