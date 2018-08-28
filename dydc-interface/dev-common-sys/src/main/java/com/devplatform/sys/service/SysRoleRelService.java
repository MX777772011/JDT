package com.devplatform.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.sys.bean.SysRoleRel;
import com.devplatform.sys.mapper.SysRoleRelMapper;

/**
 * 
 * <br>
 * <b>功能：</b>SysRoleRelService<br>
 * <b>作者：</b><br>
 * <b>日期：</b> 2013-03-01 <br>
 */
@Service("sysRoleRelService")
public class SysRoleRelService<T> extends BaseService<T> {
	protected final static Logger log = Logger.getLogger(SysRoleRelService.class);

	public List<SysRoleRel> queryByRoleId(String roleId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		return getMapper().queryByRoleId(param);
	}

	public List<SysRoleRel> queryByObjId(String objId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		return getMapper().queryByObjId(param);
	}

	/**
	 * 根据关联对象id,关联类型删除
	 * 
	 * @param objId
	 * @param relType
	 */
	public void deleteByObjId(String objId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		getMapper().deleteByObjId(param);
	}

	/**
	 * 根据角色id删除
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(String roleId) {
		deleteByRoleId(roleId, null);
	}

	/**
	 * 根据角色id,关联类型删除
	 * 
	 * @param roleId
	 * @param relType
	 */
	public void deleteByRoleId(String roleId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		getMapper().deleteByRoleId(param);
	}

	@Autowired
	private SysRoleRelMapper<T> mapper;

	public SysRoleRelMapper<T> getMapper() {
		return mapper;
	}

}
