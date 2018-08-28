package com.devplatform.sys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devplatform.common.annotation.Auth;
import com.devplatform.common.annotation.Module;
import com.devplatform.common.idgen.IdGenerator;
import com.devplatform.common.utils.Constant;
import com.devplatform.common.utils.HtmlUtil;
import com.devplatform.common.utils.MethodUtil;
import com.devplatform.common.utils.ResultUtil;
import com.devplatform.sys.bean.BaseBean.DELETED;
import com.devplatform.sys.bean.BaseBean.STATE;
import com.devplatform.sys.bean.SysOrg;
import com.devplatform.sys.bean.SysRole;
import com.devplatform.sys.bean.SysRoleRel;
import com.devplatform.sys.bean.SysUser;
import com.devplatform.sys.model.SysUserModel;
import com.devplatform.sys.service.SysOrgService;
import com.devplatform.sys.service.SysRoleService;
import com.devplatform.sys.service.SysUserService;
import com.devplatform.sys.utils.SessionUtils;

@Controller
@ResponseBody
@RequestMapping("/sysUser")
public class SysUserAction extends BaseAction {

	protected final static Logger log = Logger.getLogger(SysUserAction.class);

	// Servrice start
	@Autowired(required = false)
	// 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysUserService<SysUser> sysUserService;

	// Servrice start
	@Autowired(required = false)
	private SysRoleService<SysRole> sysRoleService;

	@Autowired(required=false)
	private SysOrgService<SysOrg> orgService;
	
	 /**
	 * ilook 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysUserModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		// 设置页面数据
		context.put("roleList", sysRoleService.queryAllList());
		
		return forword("sys/sysUser", context);
	}

	/**
	 * json 列表页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(SysUserModel model, HttpServletResponse response)
			throws Exception {
		List<SysUser> dataList = new ArrayList<SysUser>();
			 dataList = sysUserService.queryByList(model);
			for (SysUser user : dataList) {
				List<SysRole> list = sysRoleService.queryByUserid(user.getId());
				user.setRoleStr(rolesToStr(list));
			}

			// 设置页面数据
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("total", model.getPager().getRowCount());
			jsonMap.put("rows", dataList);
			HtmlUtil.writerJson(response, jsonMap);
		
		
	}

	/**
	 * 角色列表转成字符串
	 * 
	 * @param list
	 * @return
	 */
	private String rolesToStr(List<SysRole> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			SysRole role = list.get(i);
			str.append(role.getRoleName());
			if ((i + 1) < list.size()) {
				str.append(",");
			}
		}
		return str.toString();
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Module(remark=("保存用户"),module=("用户管理"))
	@RequestMapping("/save")
	public void save(HttpServletResponse response,@Validated SysUser bean, BindingResult result)
			throws Exception {
		if(result.hasErrors()){
			sendFailureMessage(response, ResultUtil.getErrorMessage(result));
			return;
		}
		int count = sysUserService.getUserCountByEmail(bean.getEmail());
		if (bean.getId() == null || "".equals(bean.getId())) {
			if (count > 0) {
				sendFailureMessage(response, "用户已存在。");
				return;
			}
			bean.setDeleted(DELETED.NO.key);
			bean.setPwd(MethodUtil.MD5(Constant.SITE_USER_BASEPASSWORD));// 初始化密码
			bean.setId(IdGenerator.generateId());
			sysUserService.add(bean);
		} else {
			if (count > 1) {
				sendFailureMessage(response, "用户已存在。");
				return;
			}
			sysUserService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	@RequestMapping("/getId")
	public void getId(String id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser bean = sysUserService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@Module(remark=("删除用户"),module=("用户管理"))
	@RequestMapping("/delete")
	public void delete(String[] id, HttpServletResponse response)
			throws Exception {
		sysUserService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Module(remark=("修改密码"),module=("用户管理"))
	@RequestMapping("/updatePwd")
	public void updatePwd(String id, String oldPwd, String newPwd,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		boolean isAdmin = SessionUtils.isAdmin(request); // 是否超级管理员
			SysUser bean = sysUserService.queryById(id);
			if (bean.getId() == null || DELETED.YES.key == bean.getDeleted()) {
				sendFailureMessage(response, "對不起，用戶不存在。");
				return;
			}
			if (StringUtils.isBlank(newPwd)) {
				sendFailureMessage(response, "密碼是必填。");
				return;
			}
			// 不是超级管理员，匹配旧密码
			if (!isAdmin && !MethodUtil.ecompareMD5(oldPwd, bean.getPwd())) {
				sendFailureMessage(response, "错误的旧密码。");
				return;
			}
			bean.setPwd(MethodUtil.MD5(newPwd));
			sysUserService.updateBySelective(bean);
			sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 用户授权页面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userRole")
	public ModelAndView userRole(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		context.put("roleList", sysRoleService.queryAllList());
		return forword("/sys/sysUserRole", context);
	}
	@Auth(verifyLogin = false,verifyURL = false)
	@Module(remark=("注册用户"),module=("APP操作"))
	@RequestMapping(value="/saveForApp")
	public void saveForApp(HttpServletResponse response,SysUser bean,String verifyCode, HttpServletRequest request)
			throws Exception {
		
		if(verifyCode==null||!verifyCode.equals(SessionUtils.getValidateCode(request))){
			sendFailureMessage(response, "验证码输入有误~");
			return;
		}
		int count = sysUserService.getUserCountByEmail(bean.getEmail());
		if (count > 0) {
			sendFailureMessage(response, "用户已存在。");
			return;
		}
		bean.setDeleted(DELETED.NO.key);
		bean.setPwd(MethodUtil.MD5(bean.getPwd()));// 初始化密码
		bean.setId(IdGenerator.generateId());
		sysUserService.add(bean);
		SessionUtils.removeValidateCode(request);
		sendSuccessMessage(response, "注册成功~");
	}
	@Module(remark=("修改用户"),module=("APP操作"))
	@RequestMapping("/updateForApp")
	public void updateForApp(HttpServletResponse response, SysUser bean, HttpServletRequest result)
			throws Exception {
		SysUser user = SessionUtils.getUser(result);
		int count = sysUserService.getUserCountByEmail(bean.getEmail());
		if (count > 1) {
			sendFailureMessage(response, "用户已存在。");
			return;
		}
		bean.setId(user.getId());
		sysUserService.updateBySelective(bean);
		sendSuccessMessage(response, "修改成功~");
	}
	@Auth(verifyLogin = false,verifyURL = false)
	@Module(remark=("修改密码"),module=("APP操作"))
	@RequestMapping("/updatePwdUsePhone")
	public void updatePwdUsePhone(String phone, String newPwd,String verifyCode,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(verifyCode==null||!verifyCode.equals(SessionUtils.getValidateCode(request))){
			sendFailureMessage(response, "验证码输入有误~");
			return;
		}
		SessionUtils.removeValidateCode(request);
		SysUserModel model = new SysUserModel();
		model.setPhone(phone);
		List<SysUser> dataList = sysUserService.queryByList(model);
		if(dataList==null||dataList.size()==0){
			sendFailureMessage(response, "用户名或密码错误~");
		}else{
			SysUser sysUser = dataList.get(0);
			sysUser.setPwd(MethodUtil.MD5(newPwd));
			sysUserService.updateBySelective(sysUser);
			sendSuccessMessage(response, "保存成功~");
		}
		
	}
	/**
	 * 用户授权列表
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/userList")
	public void userList(SysUserModel model, HttpServletResponse response)
			throws Exception {
		model.setState(STATE.ENABLE.key);
		dataList(model, response);
	}
	
	
	/**
	 * json 列表页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryUser")
	public ModelAndView querUser(SysUserModel model,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = getRootMap();
		context.put("nameobj", request.getParameter("nameobj"));
		context.put("idobj", request.getParameter("idobj"));
		context.put("callback", request.getParameter("callback"));
		context.put("excludeManager", request.getParameter("excludeManager"));
		return forword("sys/queryUser", context);
	}
	

	/**
	 * 查询用户信息
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getUser")
	public void getUser(String id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser bean = sysUserService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		String[] roleIds = null;
		List<SysRoleRel> roles = sysUserService.getUserRole(bean.getId());
		if (roles != null) {
			roleIds = new String[roles.size()];
			int i = 0;
			for (SysRoleRel rel : roles) {
				roleIds[i] = rel.getRoleId();
				i++;
			}
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", bean.getId());
		data.put("email", bean.getEmail());
		data.put("roleIds", roleIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtil.writerJson(response, context);
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Module(remark=("用户授权"),module=("用户管理"))
	@RequestMapping("/addUserRole")
	public void addUserRole(String id, String roleIds[],
			HttpServletResponse response) throws Exception {
		sysUserService.addUserRole(id, roleIds);
		sendSuccessMessage(response, "保存成功");
	}
	 
}
