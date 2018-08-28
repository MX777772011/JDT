package com.devplatform.sys.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devplatform.common.annotation.Module;
import com.devplatform.common.idgen.IdGenerator;
import com.devplatform.sys.bean.SysMenu;
import com.devplatform.sys.bean.SysRole;
import com.devplatform.sys.bean.SysRoleRel;
import com.devplatform.sys.bean.SysRoleRel.RelType;
import com.devplatform.sys.model.SysRoleModel;
import com.devplatform.sys.service.SysMenuService;
import com.devplatform.sys.service.SysRoleRelService;
import com.devplatform.sys.service.SysRoleService;
import com.devplatform.common.utils.HtmlUtil;

@Controller
@ResponseBody
@RequestMapping("/sysRole")
public class SysRoleAction extends BaseAction {

	protected final static Logger log = Logger.getLogger(SysRoleAction.class);

	// Servrice start
	@Autowired(required = false)
	private SysRoleService<SysRole> sysRoleService;

	// Servrice start
	@Autowired(required = false)
	private SysMenuService<SysMenu> sysMenuService;
	@Autowired(required = false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/role")
	public ModelAndView list(SysRoleModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("sys/sysRole", context);
	}

	/**
	 * ilook 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void datalist(SysRoleModel model, HttpServletResponse response)
			throws Exception {
		List<SysRole> dataList = sysRoleService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Module(remark=("保存角色"),module=("角色管理"))
	@RequestMapping("/save")
	public void save(SysRole bean, String[] menuIds, String[] btnIds,
			HttpServletResponse response) throws Exception {
		if (bean.getId() == null || "".equals(bean.getId())) {
			bean.setId(IdGenerator.generateId());
			sysRoleService.add(bean, menuIds, btnIds);
		} else {
			sysRoleService.update(bean, menuIds, btnIds);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	@RequestMapping("/getId")
	public void getId(String id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		SysRole bean = sysRoleService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		// 获取权限关联的菜单
		String[] menuIds = null;
		List<SysMenu> menuList = sysMenuService.getMenuByRoleId(id);
		if (menuList != null) {
			menuIds = new String[menuList.size()];
			int i = 0;
			for (SysMenu item : menuList) {
				menuIds[i] = item.getId();
				i++;
			}
		}
		// 获取权限下关联的按钮
		String[] btnIds = null;
		List<SysRoleRel> btnList = sysRoleRelService.queryByRoleId(id,
				RelType.BTN.key);
		if (btnList != null) {
			btnIds = new String[btnList.size()];
			int i = 0;
			for (SysRoleRel item : btnList) {
				btnIds[i] = item.getObjId();
				i++;
			}
		}

		// 将对象转成Map
		@SuppressWarnings("unchecked")
		Map<String, Object> data = BeanUtils.describe(bean);
		data.put("menuIds", menuIds);
		data.put("btnIds", btnIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtil.writerJson(response, context);
	}

	@Module(remark=("删除角色"),module=("角色管理"))
	@RequestMapping("/delete")
	public void delete(String[] id, HttpServletResponse response)
			throws Exception {
		sysRoleService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

	@RequestMapping("/loadRoleList")
	public void loadRoleList(HttpServletResponse response) throws Exception {
		List<SysRole> roloList = sysRoleService.queryAllList();
		HtmlUtil.writerJson(response, roloList);
	}

}
