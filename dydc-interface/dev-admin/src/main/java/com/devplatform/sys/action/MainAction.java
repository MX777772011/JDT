package com.devplatform.sys.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devplatform.business.mina.server.SessionWarehouse;
import com.devplatform.business.utils.SendMessageUtil;
import com.devplatform.common.annotation.Auth;
import com.devplatform.common.annotation.Module;
import com.devplatform.common.utils.Constant.SuperAdmin;
import com.devplatform.common.utils.DateUtil;
import com.devplatform.common.utils.HtmlUtil;
import com.devplatform.common.utils.MethodUtil;
import com.devplatform.common.utils.URLUtils;
import com.devplatform.sys.bean.BaseBean.DELETED;
import com.devplatform.sys.bean.BaseBean.STATE;
import com.devplatform.sys.bean.SysMenu;
import com.devplatform.sys.bean.SysMenuBtn;
import com.devplatform.sys.bean.SysUser;
import com.devplatform.sys.bean.TreeNode;
import com.devplatform.sys.model.SiteMainModel;
import com.devplatform.sys.service.SysMenuBtnService;
import com.devplatform.sys.service.SysMenuService;
import com.devplatform.sys.service.SysUserService;
import com.devplatform.sys.utils.SessionUtils;
import com.devplatform.sys.utils.TreeUtil;

@Controller
public class MainAction extends BaseAction {
	private final static Logger log = Logger.getLogger(MainAction.class);

	@Autowired(required = false)
	private SysMenuService<SysMenu> sysMenuService;
	
	@Autowired(required = false)
	private SysUserService<SysUser> sysUserService;
	
	@Autowired(required = false)
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;
	
	/**
	 * 访问登录页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("login", context);
	}
	/**
	 * 测试请求
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/test")
	public void test(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String sn = "BC00D09B05087DDD";
		SendMessageUtil instance = SendMessageUtil.getInstance(sn);
		while(true){  
            if(scanner.hasNext()){  
                String next = scanner.next();
                try {
                	if ("#".equals(next)) {
                		scanner.close();
						break;
					}else if("end".equals(next)){
						instance.Send();
						Object data2 = SessionWarehouse.getData(sn, instance.getCmd());
						System.out.println(data2);
					}
                	int indexOf = next.indexOf(":");
                    String name = next.substring(0,indexOf);
                    String val = next.substring(indexOf+1);
                    Class<? extends SendMessageUtil> clazz = instance.getClass();
                    Method[] declaredMethods = clazz.getDeclaredMethods();
                    for (Method method : declaredMethods) {
    					if(method.getName().equals("set"+name.substring(0, 1).toUpperCase() + name.substring(1))){
    						method.invoke(instance, val);
    						System.out.println("设置参数："+name+":"+val);
    					}
    				}
				} catch (Exception e) {
					// TODO: handle exception
					continue;
				}
            }
        }
	}
	

	/**
	 * 访问示例界面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/demoForm")
	public ModelAndView demoForm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("demoForm", context);
	}

	/**
	 * 登录
	 * 
	 * @param email
	 *            邮箱登录账号
	 * @param pwd
	 *            密码
	 * @param verifyCode
	 *            验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Module(remark=("用户登录"))
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/toLogin")
	public void toLogin(String email, String pwd, String verifyCode,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		String vcode = SessionUtils.getValidateCode(request);
//		SessionUtils.removeValidateCode(request);// 清除验证码，确保验证码只能用一次
//		if (StringUtils.isBlank(verifyCode)) {
//			sendFailureMessage(response, "验证码不能为空.");
//			return;
//		}
//		if (!verifyCode.toLowerCase().equals(vcode)) {
//			sendFailureMessage(response, "验证码输入错误.");
//			return;
//		}
		if (StringUtils.isBlank(email)) {
			sendFailureMessage(response, "账号不能为空.");
			return;
		}
		if (StringUtils.isBlank(pwd)) {
			sendFailureMessage(response, "密码不能为空.");
			return;
		}
		String msg = "用户登录日志:";
		SysUser user = sysUserService.queryLogin(email, MethodUtil.MD5(pwd));
		if (user == null) {
			// 记录错误登录日志
			log.debug(msg + "[" + email + "]" + "账号或者密码输入错误.");
			sendFailureMessage(response, "账号或者密码输入错误.");
			return;
		}
		if (STATE.DISABLE.key == user.getState()) {
			sendFailureMessage(response, "账号已被禁用.");
			return;
		}
		// 登录次数加1 修改登录时间
		int loginCount = 0;
		if (user.getLoginCount() != null) {
			loginCount = user.getLoginCount();
		}
		user.setLoginCount(loginCount + 1);
		user.setLoginTime(DateUtil.getDateByString(""));
		sysUserService.updateBySelective(user);
		// 设置User到Session
		SessionUtils.setUser(request, user);
		// 记录成功登录日志
		log.debug(msg + "[" + email + "]" + "登录成功");
		sendSuccessMessage(response, "登录成功.");
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SessionUtils.removeUser(request);
		response.sendRedirect(URLUtils.get("msUrl") + "/login.shtml");
	}

	/**
	 * 获取Action下的按钮
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/getActionBtn")
	public void getActionBtn(String url, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> actionTypes = new ArrayList<String>();
		// 判断是否超级管理员
		if (SessionUtils.isAdmin(request)) {
			result.put("allType", true);
		} else {
//			String menuUrl = URLUtils.getReqUri(url);// 旧版用iframe时的写法
			String menuUrl = url;//新的写法，直接传过来即可
			
			menuUrl = StringUtils.remove(menuUrl, request.getContextPath());
			// 获取权限按钮
			actionTypes = SessionUtils.getMemuBtnListVal(request, StringUtils
					.trim(menuUrl));
			result.put("allType", false);
			result.put("types", actionTypes);
		}
		result.put(SUCCESS, true);
		HtmlUtil.writerJson(response, result);
	}

	/**
	 * 修改密码
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/modifyPwd")
	public void modifyPwd(String oldPwd, String newPwd,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysUser user = SessionUtils.getUser(request);
		if (user == null) {
			sendFailureMessage(response, "对不起,登录超时.");
			return;
		}
		SysUser bean = sysUserService.queryById(user.getId());
		if (bean.getId() == null || DELETED.YES.key == bean.getDeleted()) {
			sendFailureMessage(response, "对不起,用户不存在.");
			return;
		}
		if (StringUtils.isBlank(newPwd)) {
			sendFailureMessage(response, "密码不能为空.");
			return;
		}
		// 不是超级管理员，匹配旧密码
		if (!MethodUtil.ecompareMD5(oldPwd, bean.getPwd())) {
			sendFailureMessage(response, "旧密码输入不匹配.");
			return;
		}
		bean.setPwd(MethodUtil.MD5(newPwd));
		sysUserService.update(bean);
		sendSuccessMessage(response, "修改成功.");
	}

	/**
	 * ilook 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/main")
	public ModelAndView main(SiteMainModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser user = SessionUtils.getUser(request);
		List<SysMenu> rootMenus = null;
		List<SysMenu> childMenus = null;
		List<SysMenuBtn> childBtns = null;
		
		/********************以上是微信部分代码(若项目不用可以直接删除或者注释)*****************************/
		if (user != null && SuperAdmin.YES.key == user.getSuperAdmin()) {
			rootMenus = sysMenuService.getRootMenu(null);// 查询所有根节点
			childMenus = sysMenuService.getChildMenu();// 查询所有子节点
			
		} else {
			rootMenus = sysMenuService.getRootMenuByUser(user.getId());// 根节点
			childMenus = sysMenuService.getChildMenuByUser(user.getId());// 子节点
			childBtns = sysMenuBtnService.getMenuBtnByUser(user.getId());// 按钮操作
			
			buildData(childMenus, childBtns, request); // 构建必要的数据
		}
		
		context.put("user", user);
		context.put("menuList", treeMenu(rootMenus, childMenus));
		return forword("main", context);
	}
	/**
	 * 
	 * 获取验证码s
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = false,verifyURL = false)
	@ResponseBody
	@RequestMapping(value="/getVerifyCode")
	public void getVerifyCode(@RequestBody String phone, HttpServletRequest request) throws Exception {
		int count = sysUserService.getUserCountByEmail(phone);
		if (count > 0) {
			sendFailureMessage(response, "用户已存在。");
			return;
		}
		String vode = String.valueOf(Math.round(Math.random()*10000));
		SessionUtils.setValidateCode(request, vode);
		sendSuccessMessage(response, vode);
	}
	/**
	 * 构建树形数据
	 * 
	 * @return
	 */
	private List<TreeNode> treeMenu(List<SysMenu> rootMenus,
			List<SysMenu> childMenus) {
		TreeUtil util = new TreeUtil(rootMenus, childMenus);
		return util.getTreeNode();
	}

	/**
	 * 构建树形数据
	 * 
	 * @return
	 */
	private void buildData(List<SysMenu> childMenus,
			List<SysMenuBtn> childBtns, HttpServletRequest request) {
		// 能够访问的url列表
		List<String> accessUrls = new ArrayList<String>();
		// 菜单对应的按钮
		@SuppressWarnings("rawtypes")
		Map<String, List> menuBtnMap = new HashMap<String, List>();
		for (SysMenu menu : childMenus) {
			// 判断URL是否为空
			if (StringUtils.isNotBlank(menu.getUrl())) {
				List<String> btnTypes = new ArrayList<String>();
				for (SysMenuBtn btn : childBtns) {
					if (menu.getId().equals(btn.getMenuid())) {
						btnTypes.add(btn.getBtnType());
						URLUtils.getBtnAccessUrls(menu.getUrl(), btn
								.getActionUrls(), accessUrls);
					}
				}
				menuBtnMap.put(menu.getUrl(), btnTypes);
				URLUtils.getBtnAccessUrls(menu.getUrl(), menu.getActions(),
						accessUrls);
				accessUrls.add(menu.getUrl());
			}
		}
		SessionUtils.setAccessUrl(request, accessUrls);// 设置可访问的URL
		SessionUtils.setMemuBtnMap(request, menuBtnMap); // 设置可用的按钮
	}
}
