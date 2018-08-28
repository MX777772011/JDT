package com.devplatform.sys.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class MainAction extends BaseAction {
	protected final static Logger log = Logger.getLogger(MainAction.class);

//	@Autowired(required = false)
//	private RedisUtilsService redisUtilsService;
//
//	/**
//	 * 用户登录的接口
//	 * 
//	 * @param lb
//	 *            登录时，传递过来的对象
//	 * @throws Exception
//	 *             抛出异常
//	 */
//	@Auth(verifyLogin = false, verifyURL = false)
//	@RequestMapping("/toLogin")
//	@ResponseBody
//	public void toLogin(LoginBean lb) throws Exception {
//		try {
//			String redis_loginLock_key = redisUtilsService.getLoginLock(lb.getUsername());// 获取锁
//			if (StringUtil.isNotEmpty(redis_loginLock_key)) {// 判断锁
//				ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_FAILED.key, "请不要重复点击登录按钮", null);
//				return;
//			} else {
//				redisUtilsService.lockLogin(lb.getUsername());// add 加锁
//			}
//			// 开始调用登录sso接口,添加service
//			SSOLoginResultBean sso_login_result_bean = SSOUtil.ssologin(lb);
//			// 调用获取用户信息接口
//			SSOFindResultBean findResult = SSOUtil.ssoFind(lb.getUsername());
//			// 判断有没有此用户，如果没有则添加，有则返回
//			TAppUser tAppUser = tAppUserService.login(findResult);
//			String login_user_json_str = redisUtilsService.loginDeal(tAppUser, lb.getMachine_code());
//			ResultUtil.sendJsonData(response, true, sso_login_result_bean.getCode(), sso_login_result_bean.getMsg(), login_user_json_str);
//			// 删掉key
//			redisUtilsService.realseLoginLock(lb.getUsername());
//		} catch (CustomException e) {
//			// 删掉key
//			e.printStackTrace();
//			redisUtilsService.realseLoginLock(lb.getUsername());
//			ResultUtil.sendJsonData(response, false, e.getErrCode(), e.getMessage(), null);
//		} catch (Exception e) {
//			// 删掉key
//			e.printStackTrace();
//			redisUtilsService.realseLoginLock(lb.getUsername());
//			ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_FAILED, null);
//		} finally {
//			redisUtilsService.realseLoginLock(lb.getUsername());
//		}
//	}
//
//	/**
//	 * 用户注册接口
//	 * 
//	 * @param regBean
//	 *            注册时，接口入参
//	 * @throws Exception
//	 */
//	// //@Module(remark = ("用户注册"))
//	@Auth(verifyLogin = false, verifyURL = false)
//	@RequestMapping("/register")
//	@ResponseBody
//	public void register(RegBean regBean) throws Exception {
//		try {
//			if(ValidateUtil.isNotEmpty(regBean.getNickname()) && !isNickname(regBean.getNickname())){
//				ResultUtil.sendJsonData(response, false, ResultCodeEnum.REG_ERR_NICKNAME_EXIST1.key, "昵称包含特殊字符，请输入有效昵称", null);
//				return;
//			}
//			
//			String redis_loginLock_key = redisUtilsService.getLoginLock(regBean.getUsername());// 获取锁
//			if (StringUtil.isNotEmpty(redis_loginLock_key)) {// 判断锁
//				ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_FAILED.key, "请不要重复点击注册按钮", null);
//				return;
//			} else {
//				redisUtilsService.lockLogin(regBean.getUsername());// add 加锁
//			}
//			SSOLoginResultBean reg_result_bean = SSOUtil.ssoReg(regBean);
//			SSOFindResultBean findResult = SSOUtil.ssoFind(regBean.getUsername());
//			// 判断有没有此用户，如果没有则添加，有则返回
//			TAppUser tAppUser = tAppUserService.login(findResult);
//			String reg_user_json_str = redisUtilsService.loginDeal(tAppUser, regBean.getMachine_code());
//			ResultUtil.sendJsonData(response, true, reg_result_bean.getCode(), reg_result_bean.getMsg(), reg_user_json_str);
//			// 删掉key
//			redisUtilsService.realseLoginLock(regBean.getUsername());
//		} catch (CustomException e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, e.getErrCode(), e.getMessage(), null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_FAILED, null);
//		} finally {
//			redisUtilsService.realseLoginLock(regBean.getUsername());
//		}
//	}
//
//	/**
//	 * 用户登出接口
//	 * 
//	 * @param logoutBean
//	 *            登出时，入参
//	 * @throws Exception
//	 */
//	// //@Module(remark = ("用户登出"))
//	@Auth(verifyLogin = true, verifyURL = false)
//	@RequestMapping("/logout")
//	@ResponseBody
//	public void logout(UserBean logoutBean) throws Exception {
//		try {
//			String machineCode = logoutBean.getMachine_code();
//			redisUtilsService.logout(logoutBean.getUser_id() + "_" + machineCode);
//			ResultUtil.sendJsonData(response, true, ResultCodeEnum.COMMON_SUCCESS, null);
//		} catch (CustomException e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, e.getErrCode(), e.getMessage(), null);
//		}
//	}
//
//	/**
//	 * 发送短信验证码接口，bean中linkType取值说明： 0表示注册激活 2表示找回密码
//	 * 
//	 * @param bean
//	 *            发送参数
//	 * @throws Exception
//	 */
//	// //@Module(remark = ("发送手机验证码"))
//	@Auth(verifyLogin = false, verifyURL = false)
//	@RequestMapping("/putPhoneCode")
//	@ResponseBody
//	public void putPhoneCode(SMSBean bean) throws Exception {
//		try {
//			if (ValidateUtil.isEmpty(bean.getPhone())) {
//				ResultUtil.sendJsonData(response, false, "1003", "请输入手机号", null);
//				return;
//			}
//			if (ValidateUtil.isEmpty(bean.getLinkType())) {
//				ResultUtil.sendJsonData(response, false, "1003", "输入参数不完整", null);
//				return;
//			}
//			if (bean.getLinkType() != 0 && bean.getLinkType() != 2) {
//				ResultUtil.sendJsonData(response, false, "1003", "输入参数错误", null);
//				return;
//			}
//			SSOFindResultBean findResultBean = SSOUtil.find(bean.getPhone());
//			if (bean.getLinkType() == 0 && findResultBean != null) {// 注册
//				ResultUtil.sendJsonData(response, false, "1002", "该手机号已注册过嘤嘤嘤", null);
//				return;
//			}
//			if (bean.getLinkType() == 2 && findResultBean == null) {// 找回密码
//				ResultUtil.sendJsonData(response, false, "1105", "手机号不存在", null);
//				return;
//			}
//			// 发送短信
//			SSOSMSResultBean sms_send_result = SSOUtil.sendSMS(bean);
//			if (sms_send_result.getCode().equals("0")) {
//				ResultUtil.sendJsonData(response, true, sms_send_result.getCode(), sms_send_result.getMsg(), null);
//			} else {
//				ResultUtil.sendJsonData(response, false, sms_send_result.getCode(), sms_send_result.getMsg(), null);
//			}
//		} catch (CustomException e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, e.getErrCode(), e.getMessage(), null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_FAILED, null);
//		}
//	}
//
//	/**
//	 * 修改用户信息
//	 * 
//	 * @param userBean
//	 *            接口传递的要修改的用户信息
//	 * @throws Exception
//	 */
//	// ////@Module(remark = ("修改用户信息"))
//	@Auth(verifyLogin = true, verifyURL = false)
//	@RequestMapping("/updateUser")
//	@ResponseBody
//	public void updateUser(UserBean userBean) throws Exception {
//		try {
//			if(userBean.getType() == null){
//				ResultUtil.sendJsonData(response, false, "1003", "输入参数不完整", null);
//			}
//			if(userBean.getType() != 1 && userBean.getType() != 2 && userBean.getType() != 3 && userBean.getType() != 4){
//				ResultUtil.sendJsonData(response, false, "1003", "输入参数不正确", null);
//			}
//			
//			// 在redis 中获取数据
//			TAppUser redisUserBean = redisUtilsService.getLoginUser(RedisUtilsService.REDIS_USER + userBean.getUser_id() + "_" + userBean.getMachine_code());
//			if (redisUserBean != null && redisUserBean.getAuName() != null) {
//				userBean.setUsername(redisUserBean.getAuName());
//			}
//			
//			
//			if (userBean.getType() == 1) {//修改手机号
//				updateMobile(userBean);
//				return;
//			}
//			if (userBean.getType() == 2) {//修改昵称
//				if(ValidateUtil.isNotEmpty(userBean.getNickname()) && !isNickname(userBean.getNickname())){
//					ResultUtil.sendJsonData(response, false, ResultCodeEnum.REG_ERR_NICKNAME_EXIST1.key, "昵称包含特殊字符，请输入有效昵称", null);
//					return;
//				}
//				updateNick(userBean);
//				return;
//			}
//			if (userBean.getType() == 3) {//修改密码
//				updatePassword(userBean);
//				return;
//			}
//			if (userBean.getType() == 4) {// 如果是修改头像则直接修改头像
//				updateHeadIcon(userBean);
//				return;
//			}
//		} catch (CustomException e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, e.getErrCode(), e.getMessage(), null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_FAILED.key, e.getMessage(), null);
//		}
//	}
//
//	/**
//	 * 修改用户头像
//	 * @param userBean 用户基本信息
//	 * @throws Exception
//	 */
//	private void updateHeadIcon(UserBean userBean) throws Exception{
//		TAppUser dbuser = tAppUserService.queryById(userBean.getUser_id());
//		String qnheadIcon = FileUploadQiNiuUtils.uploadQiNiuFile(BundleUtil.FILE_ABSOLUTE_PREFIX+userBean.getAuHeadIcon(), FileUploadQiNiuUtils.HEAD_ICON_PREFIX+FileUploadQiNiuUtils.getFileNameByPath(userBean.getAuHeadIcon()));
//		dbuser.setAuHeadIcon(BundleUtil.PUBLISH_QINIU_DOMAINNAME + qnheadIcon);
//		tAppUserService.updateBySelective(dbuser);
//		ResultUtil.sendJsonData(response, true, ResultCodeEnum.COMMON_SUCCESS, dbuser);
//	}
//	
//	/**
//	 * 修改用户手机号
//	 * @param userBean 用户信息
//	 * @throws Exception
//	 */
//	private void updateMobile(UserBean userBean) throws Exception {
//		if (userBean.getPhone() != null) {
//			userBean.setMobile(userBean.getPhone());
//		}
//		String data = JSON.toJSONString(userBean);
//		String sendResult = HttpsUtil.doPostSSL(BundleUtil.SSO_URL + BundleUtil.SSO_UPDATE_MOBILE, data);
//		UserBean stud = JSON.parseObject(sendResult, UserBean.class);
//		if (stud.getCode().equals("0")) {
//			TAppUser find_result_bean = tAppUserService.queryById(userBean.getUser_id());
//			find_result_bean.setAuMobile(userBean.getPhone());
//			find_result_bean.setAuName(userBean.getPhone());
//			tAppUserService.updateBySelective(find_result_bean);
//			String reg_user_json_str = redisUtilsService.loginDeal(find_result_bean, userBean.getMachine_code());
//			ResultUtil.sendJsonData(response, true, stud.getCode(), stud.getMsg(), reg_user_json_str);
//		} else {
//			ResultUtil.sendJsonData(response, false, stud.getCode(), stud.getMsg(), null);
//		}
//	}
//
//	/**
//	 * 修改用户昵称
//	 * @param userBean
//	 * @throws Exception
//	 */
//	public void updateNick(UserBean userBean) throws Exception {
//		
//		if(ValidateUtil.isNotEmpty(userBean.getNickname()) && !isNickname(userBean.getNickname())){
//			ResultUtil.sendJsonData(response, false, ResultCodeEnum.REG_ERR_NICKNAME_EXIST1.key, "昵称包含特殊字符，请输入有效昵称", null);
//			return;
//		}
//		
//		String data = JSON.toJSONString(userBean);
//		String sendResult = HttpsUtil.doPostSSL(BundleUtil.SSO_URL + BundleUtil.SSO_UPDATE_NICK, data);
//		UserBean stud = JSON.parseObject(sendResult, UserBean.class);
//		if (stud.getCode().equals("0")) {
//			TAppUser find_result_bean = tAppUserService.queryById(userBean.getUser_id());
//			find_result_bean.setAuNickName(userBean.getNickname());
//			tAppUserService.updateBySelective(find_result_bean);
//			String reg_user_json_str = redisUtilsService.loginDeal(find_result_bean, userBean.getMachine_code());
//			ResultUtil.sendJsonData(response, true, stud.getCode(), stud.getMsg(), reg_user_json_str);
//		} else {
//			ResultUtil.sendJsonData(response, false, stud.getCode(), stud.getMsg(), sendResult);
//		}
//	}
//	
//	/**
//	 * 修改密码
//	 * @param userBean
//	 * @throws Exception
//	 */
//	public void updatePassword(UserBean userBean) throws Exception {
//		String data = JSON.toJSONString(userBean);
//		String sendResult = HttpsUtil.doPostSSL(BundleUtil.SSO_URL + BundleUtil.SSO_UPDATE_PASSWORD, data);
//		UserBean stud = JSON.parseObject(sendResult, UserBean.class);
//		if (stud.getCode().equals("0")) {
//			TAppUser find_result_bean = tAppUserService.queryById(userBean.getUser_id());
//			String reg_user_json_str = redisUtilsService.loginDeal(find_result_bean, userBean.getMachine_code());
//			ResultUtil.sendJsonData(response, true, stud.getCode(), stud.getMsg(), reg_user_json_str);
//		} else {
//			ResultUtil.sendJsonData(response, false, stud.getCode(), stud.getMsg(), sendResult);
//		}
//	}
//
//	/**
//	 * 忘记密码接口
//	 * 
//	 * @param userBean
//	 * @throws Exception
//	 */
//	// //@Module(remark = ("修改用户信息"))
//	@Auth(verifyLogin = false, verifyURL = false)
//	@RequestMapping("/updateUserPassword")
//	@ResponseBody
//	public void updateUserPassword(UserBean userBean) throws Exception {
//		try {
//			userBean.setLinkType(2);
//			userBean.setUsername(userBean.getPhone());
//			String data = JSON.toJSONString(userBean);
//			String sendResult = HttpsUtil.doPostSSL(BundleUtil.SSO_URL + BundleUtil.SSO_UPDATE_PASSWORD_PHONE_CODE, data);
//			UserBean stud = JSON.parseObject(sendResult, UserBean.class);
//			if (stud.getCode().equals("0")) {
//				ResultUtil.sendJsonData(response, true, stud.getCode(), stud.getMsg(), null);
//			} else {
//				ResultUtil.sendJsonData(response, false, stud.getCode(), stud.getMsg(), null);
//			}
//		} catch (CustomException e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, e.getErrCode(), e.getMessage(), null);
//		}
//	}
//
//	/**
//	 * 
//	 * @param userBean
//	 * @throws Exception
//	 */
//	@Auth(verifyLogin = false, verifyURL = false)
//	@RequestMapping("/findUserInfo")
//	@ResponseBody
//	public void findUserInfo(UserBean userBean) throws Exception {
//		try {
//			//如果未登录，直接返回
//			if(ValidateUtil.isEmpty(userBean.getUser_id())){
//				ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_SUCCESS, null);
//				return ;
//			}
//			//取登录用户
//			String userKey = RedisUtilsService.REDIS_USER + userBean.getUser_id() + "_" + userBean.getMachine_code();
//			TAppUser redisUserBean = redisUtilsService.getLoginUser(userKey);
//			//取缓存中激活状态
//			String levfour = redisUtilsService.get(RedisDaoImpl.REDIS_ACTIVE+userBean.getUser_id()+"_four");
//			
//			if(isActive(levfour)){//四级已激活
//				redisUserBean.setCetFour(1);
//			}else{//如果缓存没有，或者失效，取数据库中状态
//				TUserCode fouractive = tAppUserService.getTUserCodeByUserId(userBean.getUser_id(), BundleUtil.SSO_LEVELFOURSIX);
//				if(fouractive == null || fouractive.getValidDate().getTime()<System.currentTimeMillis()){//没有激活激活，或者激活记录时间小于当前时间（已过期）
//					redisUserBean.setCetFour(0);
//				}else{
//					redisUserBean.setCetFour(1);
//					//更新缓存
//					redisUtilsService.set(RedisDaoImpl.REDIS_ACTIVE+userBean.getUser_id()+"_four",  fouractive == null ? "":String.valueOf(fouractive.getValidDate().getTime()));
//				}
//			}
//			String levsix = redisUtilsService.get(RedisDaoImpl.REDIS_ACTIVE+userBean.getUser_id()+"_six");
//			if(isActive(levsix)){//六级已激活
//				redisUserBean.setCetSix(1);
//			}else{//如果缓存没有，或者失效，取数据库中状态
//				TUserCode sixactive = tAppUserService.getTUserCodeByUserId(userBean.getUser_id(), BundleUtil.SSO_LEVELFOURSIX);
//				if(sixactive == null || sixactive.getValidDate().getTime()<System.currentTimeMillis()){//没有激活激活，或者激活记录时间小于当前时间（已过期）
//					redisUserBean.setCetSix(0);
//				}else{
//					redisUserBean.setCetSix(1);
//					//更新缓存
//					redisUtilsService.set(RedisDaoImpl.REDIS_ACTIVE+userBean.getUser_id()+"_six",  sixactive == null ? "":String.valueOf(sixactive.getValidDate().getTime()));
//				}
//			}
//			ResultUtil.sendJsonData(response, true, ResultCodeEnum.COMMON_SUCCESS, redisUserBean);
//		} catch (CustomException e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, e.getErrCode(), e.getMessage(), null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ResultUtil.sendJsonData(response, false, ResultCodeEnum.COMMON_FAILED.key, e.getMessage(), null);
//		}
//	}
//	/**
//	 * 
//	 * @param key 应该是 long类型的时间戳
//	 * @return
//	 */
//	private boolean isActive(String key){
//		if(ValidateUtil.isEmpty(key)){//key不存在
//			return false;
//		}
//		try {
//			long activeTime = Long.parseLong(key);
//			return System.currentTimeMillis()<=activeTime;
//		} catch (Exception e) {//不是时间戳格式
//			e.printStackTrace();
//			return false;
//		}
//		
//	}
//	/**
//	 * 校验昵称特殊字符
//	 * @param Nickname
//	 * @return
//	 */
//	private boolean isNickname(String Nickname){
//		String sss= "^[a-zA-Z0-9\u2f00-\u2fdf\u4e00-\u9fa5\uff00-\uffff\u3000\u3400-\u4DB5\uf900-\ufaff\ue863\\[\\],.{}()<>?/\\|`~\"'@#$%&*《》（）+=_¥￥。，、;:：；【】…？！!”“’‘• \\r\\n\\t\\\\-]*$";
//			return Nickname.matches(sss);
//		
//	}
}
