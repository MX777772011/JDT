package com.devplatform.sso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.devplatform.sso.bean.EcUser;
import com.devplatform.sso.constant.SSOResutlConstant;
import com.devplatform.sso.service.EcUserService;

/**
 * EcUser controller 用于ec_user的接口
 * 
 * @author liyinchu
 *
 */
@Api(value = "LoginController", description = "登录注册相关接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping("/")
public class LoginController {

	protected final static Logger log = LoggerFactory.getLogger(LoginController.class);

	// Servrice start
	@Autowired(required = false)// 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private EcUserService ecUserService;

	/**
	 * 添加或修改数据
	 * 
	 * @param bean
	 *            要操作的对象
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("注册接口")
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public CommonResult reg(EcUser bean) {
		// 后台验证数据

		// TODO id后台验证
		// TODO createUserId后台验证
		// TODO updateUserId后台验证
		// TODO createTime后台验证
		// TODO updateTime后台验证
		// TODO remark后台验证
		// TODO userType后台验证
		// TODO username后台验证
		// TODO password后台验证
		// TODO delFlag后台验证
		// TODO companyId后台验证
		// TODO email后台验证
		// TODO phone后台验证
		// TODO uuid后台验证
		// TODO originalPassword后台验证
		// TODO verify后台验证
		// TODO state后台验证

		try {
			if (ValidateUtil.isEmpty(bean.getId())) {
				// bean.setCreateUserId(getUserIdFromToken(request));
				// bean.setUpdateUserId(getUserIdFromToken(request));
				bean.setCreateTime(new Date());
				bean.setUpdateTime(new Date());
				bean.setDelFlag(0);
				ecUserService.add(bean);
			} else {
				// bean.setUpdateUserId(getUserIdFromToken(request));
				bean.setUpdateTime(new Date());
				ecUserService.updateBySelective(bean);
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
	 * 登录
	 * 
	 * @param bean
	 *            要操作的对象
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("登录接口")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CommonResult login(EcUser bean) {
		// 后台验证数据
		try {
			if (ValidateUtil.isEmpty(bean.getUsername()) || ValidateUtil.isEmpty(bean.getPassword())) {
				return ResultUtil.getFailed(SSOResutlConstant.LOGIN_FAILED_NULL.key, SSOResutlConstant.LOGIN_FAILED_NULL.value);
			}
			return ecUserService.login(bean);
		} catch (CustomException e) {
			e.printStackTrace();
			return ResultUtil.getFailed(e.getErrCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.getCommonFailed();
		}
	}
	/**
	 * 获取用户信息接口
	 * 
	 * @param id 要操作的对象
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("根据id获取用户信息接口")
	@RequestMapping(value = "/authget/{id}", method = RequestMethod.GET)
	public CommonResult authget(@PathVariable long id) {
		// 后台验证数据
		try {
			EcUser queryUser = ecUserService.queryById(id);
			if(queryUser == null){
				return ResultUtil.getFailed(SSOResutlConstant.LOGIN_FAILED_NOUSER.key,SSOResutlConstant.LOGIN_FAILED_NOUSER.value);
			}
			return ResultUtil.getSuccess(queryUser);
		} catch (CustomException e) {
			e.printStackTrace();
			return ResultUtil.getFailed(e.getErrCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.getCommonFailed();
		}
	}
	
	
	

}
