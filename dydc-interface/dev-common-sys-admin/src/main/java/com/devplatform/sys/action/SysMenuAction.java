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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.devplatform.common.annotation.Module;
import com.devplatform.common.idgen.IdGenerator;
import com.devplatform.common.utils.HtmlUtil;
import com.devplatform.sys.bean.BaseBean.DELETED;
import com.devplatform.sys.bean.SysMenu;
import com.devplatform.sys.bean.SysMenuBtn;
import com.devplatform.sys.bean.TreeNode;
import com.devplatform.sys.model.SysMenuModel;
import com.devplatform.sys.service.SysMenuBtnService;
import com.devplatform.sys.service.SysMenuService;
import com.devplatform.sys.utils.TreeUtil;

@Controller
@ResponseBody
@RequestMapping("/sysMenu")
public class SysMenuAction extends BaseAction {

	protected final static Logger log = Logger.getLogger(SysMenuAction.class);

	// Servrice start
	@Autowired(required = false)
	// 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysMenuService<SysMenu> sysMenuService;

	@Autowired
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

	/**
	 * 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/menu")
	public ModelAndView menu(SysMenuModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysMenu> dataList = sysMenuService.queryByList(model);
		context.put("menuList",dataList);
		return forword("sys/sysMenu", context);
	}

	/**
	 * 顶级菜单 json
	 * 
	 * @param menuId
	 *            此菜单id不查询，可以为空
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/rootMenuJson")
	public void rootMenu(String menuId, HttpServletResponse response)
			throws Exception {
		List<SysMenu> dataList = sysMenuService.getRootMenu(menuId);
		if (dataList == null) {
			dataList = new ArrayList<SysMenu>();
		}
		HtmlUtil.writerJson(response, dataList);
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
	@ResponseBody
	public Map<String, Object> dataList(SysMenuModel model, HttpServletResponse response)
			throws Exception {
		if (model.getSort() == null) {
			model.setSort("rank");
			model.setOrder("asc");
		}	
		List<SysMenu> dataList = sysMenuService.queryByList(model);
		
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		return jsonMap;
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Module(remark=("保存菜单"),module=("菜单管理"))
	@RequestMapping("/save")
	public void save(SysMenu bean,HttpServletRequest request,
			HttpServletResponse response,MultipartFile file,String oldpath) throws Exception {
		// 设置菜单按钮数据
		List<SysMenuBtn> btns = getReqBtns(request);
		bean.setBtns(btns);
		if (bean.getId() == null || "".equals(bean.getId())) {
			bean.setDeleted(DELETED.NO.key);
//			String reladdress=FileUploadUtil.upload(request, file, "/icon/",null);
//			bean.setIcon(reladdress);
			bean.setId(IdGenerator.generateId());
			sysMenuService.add(bean);
			
		} else {
//			String reladdress=FileUploadUtil.upload(request, file, "/icon/",oldpath);
//				bean.setIcon(reladdress);
				sysMenuService.update(bean);
		}
		sendSuccessMessage(response, "保存成功~请您刷新页面查看新菜单");
	}

	@RequestMapping("/getId")
	public void getId(String id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		SysMenu bean = sysMenuService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		List<SysMenuBtn> btns = sysMenuBtnService.queryByMenuid(id);
		bean.setBtns(btns);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@Module(remark=("删除菜单"),module=("菜单管理"))
	@RequestMapping("/delete")
	public void delete(String[] id, HttpServletResponse response)
			throws Exception {
		if (id != null && id.length > 0) {
			sysMenuService.delete(id);
			sendSuccessMessage(response, "删除成功");
		} else {
			sendFailureMessage(response, "未选中记录");
		}
	}

	@RequestMapping("/getMenuTree")
	public void getMenuTree(String id, HttpServletResponse response)
			throws Exception {
		List<TreeNode> menuTree = treeMenu();
		HtmlUtil.writerJson(response, menuTree);
	}

	/**
	 * 构建树形菜单
	 * 
	 * @return
	 */
	public List<TreeNode> treeMenu() {
		List<SysMenu> rootMenus = sysMenuService.getRootMenu(null);// 根节点
		List<SysMenu> childMenus = sysMenuService.getChildMenu();// 子节点
		List<SysMenuBtn> childBtns = sysMenuBtnService.queryByAll();
		TreeUtil util = new TreeUtil(rootMenus, childMenus, childBtns);
		return util.getTreeNode();
	}

	/**
	 * 获取请求的菜单按钮数据
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<SysMenuBtn> getReqBtns(HttpServletRequest request) throws Exception {
		List<SysMenuBtn> btnList = new ArrayList<SysMenuBtn>();
		String[] btnId = request.getParameterValues("btnId");
		String[] btnName = request.getParameterValues("btnName");
		String[] btnType = request.getParameterValues("btnType");
		String[] actionUrls = request.getParameterValues("actionUrls");
		String[] deleteFlag = request.getParameterValues("deleteFlag");
		if (btnId == null || btnId.length < 1) {
			return null;
		}

		for (int i = 0; i < btnId.length; i++) {
			if (StringUtils.isNotBlank(btnName[i])
					&& StringUtils.isNotBlank(btnType[i])) {
				SysMenuBtn btn = new SysMenuBtn();
				if (StringUtils.isNotBlank(btnId[i])) {
					btn.setId(btnId[i]);
				}
				btn.setId(IdGenerator.generateId());
				btn.setBtnName(btnName[i]);
				btn.setBtnType(btnType[i]);
				btn.setActionUrls(actionUrls[i]);
				btn.setDeleteFlag(deleteFlag[i]);
				btnList.add(btn);
			}
		}
		return btnList;
	}
}
