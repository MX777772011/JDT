package com.devplatform.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.sys.bean.SysMenu;
import com.devplatform.sys.bean.SysMenuBtn;
import com.devplatform.sys.bean.SysRoleRel;
import com.devplatform.sys.bean.SysRoleRel.RelType;
import com.devplatform.sys.mapper.SysMenuMapper;

/**
 * 
 * <br>
 * <b>功能：</b>SysMenuService<br>
 * <b>作者：</b><br>
 * <b>日期：</b>2013-03-01<br>
 * 
 */
@Service("sysMenuService")
public class SysMenuService<T> extends BaseService<T> {
	protected final static Logger log = Logger.getLogger(SysMenuService.class);

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	@Autowired
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

	@Autowired
	private SysMenuMapper<T> mapper;

	/**
	 * 保存菜单btn
	 * 
	 * @param btns
	 * @throws Exception
	 */
	public void saveBtns(String menuid, List<SysMenuBtn> btns) throws Exception {
		if (btns == null || btns.isEmpty()) {
			return;
		}
		for (SysMenuBtn btn : btns) {
			if (btn.getId() != null && "1".equals(btn.getDeleteFlag())) {
				sysMenuBtnService.delete(btn.getId());
				continue;
			}
			btn.setMenuid(menuid);
			if (btn.getId() == null) {
				sysMenuBtnService.add(btn);
			} else {
				sysMenuBtnService.update(btn);
			}
		}

	}

	@Override
	public void add(T t) throws Exception {
		super.add(t);
		SysMenu menu = (SysMenu) t;
		saveBtns(menu.getId(), (menu).getBtns());
	}

	@Override
	public void update(T t) throws Exception {
		super.update(t);
		SysMenu menu = (SysMenu) t;
		saveBtns(menu.getId(), menu.getBtns());
	}

	@Override
	public void updateBySelective(T t) throws Exception {
		super.updateBySelective(t);
		SysMenu menu = (SysMenu) t;
		saveBtns(menu.getId(), menu.getBtns());
	}

	/**
	 * 查询所有系统菜单列表
	 * 
	 * @return
	 */
	public List<T> queryByAll() {
		return mapper.queryByAll();
	}

	/**
	 * 获取顶级菜单
	 * 
	 * @return
	 */
	public List<T> getRootMenu(String menuId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("menuId", menuId);
		return mapper.getRootMenu(map);
	}

	/**
	 * 获取子菜单
	 * 
	 * @return
	 */
	public List<T> getChildMenu() {
		return mapper.getChildMenu();
	}

	/**
	 * 根据用户id查询父菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public List<T> getRootMenuByUser(String userId) {
		return getMapper().getRootMenuByUser(userId);
	}

	/**
	 * 根据用户id查询子菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public List<T> getChildMenuByUser(String userId) {
		return getMapper().getChildMenuByUser(userId);
	}

	/**
	 * 根据权限id查询菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public List<T> getMenuByRoleId(String roleId) {
		return getMapper().getMenuByRoleId(roleId);
	}

	@Override
	public void delete(Object[] ids) throws Exception {
		super.delete(ids);
		// 删除关联关系
		for (Object id : ids) {
			sysRoleRelService.deleteByObjId((String) id, RelType.MENU.key);
			sysMenuBtnService.deleteByMenuid((String) id);
		}
	}

	public SysMenuMapper<T> getMapper() {
		return mapper;
	}

	public List<SysMenu> queryAllMenuWithChild() throws Exception {
		@SuppressWarnings("unchecked")
		List<SysMenu> list = (List<SysMenu>) getMapper().queryByAll();
		List<SysMenu> flist = new ArrayList<SysMenu>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getParentId() == null) {
				flist.add(list.get(i));
			}
		}
		for (int i = 0; i < flist.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (flist.get(i).getId().equals(list.get(j).getParentId())) {
					flist.get(i).getChildList().add(list.get(j));
				}
			}
		}

		return flist;
	}

	/**
	 * 根据权限id查询菜单(仅含父菜单)
	 * 
	 * @param roleId
	 * @return
	 */
	public List<T> getRootMenuByRoleId(String roleId) {
		return getMapper().getRootMenuByRoleId(roleId);
	}
}
