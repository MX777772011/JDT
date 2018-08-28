package com.devplatform.sys.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.sys.bean.SysRole;
import com.devplatform.sys.bean.SysRoleRel;
import com.devplatform.sys.bean.BaseBean.STATE;
import com.devplatform.sys.bean.SysRoleRel.RelType;
import com.devplatform.sys.mapper.SysRoleMapper;

/**
 * 
 * <br>
 * <b>功能：</b>SysRoleService<br>
 * <b>作者：</b><br>
 * <b>日期：</b> 2013-03-01 <br>
 */
@Service("sysRoleService")
public class SysRoleService<T> extends BaseService<T> {
	protected final static Logger log = Logger.getLogger(SysRoleService.class);

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleMenuRel(String roleId, String[] menuIds) throws Exception {
		if (roleId == null || menuIds == null || menuIds.length < 1) {
			return;
		}
		for (String menuid : menuIds) {
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(menuid);
			rel.setRelType(RelType.MENU.key);
			sysRoleRelService.add(rel);
		}
	}

	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleBtnRel(String roleId, String[] btnIds) throws Exception {
		if (roleId == null || btnIds == null || btnIds.length < 1) {
			return;
		}
		for (String btnid : btnIds) {
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(btnid);
			rel.setRelType(RelType.BTN.key);
			sysRoleRelService.add(rel);
		}
	}

	/**
	 * 添加
	 * 
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void add(SysRole role, String[] menuIds, String[] btnIds) throws Exception {
		super.add((T) role);
		addRoleMenuRel(role.getId(), menuIds);
		addRoleBtnRel(role.getId(), btnIds);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(String[] ids) throws Exception {
		super.delete(ids);
		for (String id : ids) {
			// 清除关联关系
			sysRoleRelService.deleteByRoleId(id);
		}
	}

	/**
	 * 修改
	 * 
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void update(SysRole role, String[] menuIds, String[] btnIds) throws Exception {
		super.update((T) role);
		// 如果角色被禁用则删除关联的用户关系
		if (STATE.DISABLE.key == role.getState()) {
			sysRoleRelService.deleteByRoleId(role.getId(), RelType.USER.key);
		}
		// 清除关联关系
		sysRoleRelService.deleteByRoleId(role.getId(), RelType.MENU.key);
		sysRoleRelService.deleteByRoleId(role.getId(), RelType.BTN.key);
		addRoleMenuRel(role.getId(), menuIds);
		addRoleBtnRel(role.getId(), btnIds);

	}

	/**
	 * 查询全部有效的权限
	 * 
	 * @return
	 */
	public List<T> queryAllList() {
		return getMapper().queryAllList();
	}

	/**
	 * 查询全部有效的权限
	 * 
	 * @return
	 */
	public List<T> queryByUserid(String userid) {
		return getMapper().queryByUserid(userid);
	}

	@Autowired
	private SysRoleMapper<T> mapper;

	public SysRoleMapper<T> getMapper() {
		return mapper;
	}

}
