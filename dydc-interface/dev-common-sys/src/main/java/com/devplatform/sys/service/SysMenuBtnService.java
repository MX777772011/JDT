package com.devplatform.sys.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.sys.mapper.SysMenuBtnMapper;

/**
 * 
 * <br>
 * <b>功能：</b>SysMenuBtnService<br>
 * <b>作者：</b><br>
 * <b>日期：</b> 2013-03-01 <br>
 */
@Service("sysMenuBtnService")
public class SysMenuBtnService<T> extends BaseService<T> {
	protected final static Logger log = Logger.getLogger(SysMenuBtnService.class);

	public List<T> queryByAll() {
		return getMapper().queryByAll();
	}

	public List<T> queryByMenuid(String menuid) {
		return getMapper().queryByMenuid(menuid);
	}

	public List<T> queryByMenuUrl(String url) {
		return getMapper().queryByMenuUrl(url);
	}

	public void deleteByMenuid(String menuid) {
		getMapper().deleteByMenuid(menuid);
	}

	public List<T> getMenuBtnByUser(String userid) {
		return getMapper().getMenuBtnByUser(userid);
	}

	@Autowired
	private SysMenuBtnMapper<T> mapper;

	public SysMenuBtnMapper<T> getMapper() {
		return mapper;
	}

	public List<T> getMenuBtnByRoleId(String roleid) {
		return getMapper().getMenuBtnByRoleId(roleid);
	}

}
