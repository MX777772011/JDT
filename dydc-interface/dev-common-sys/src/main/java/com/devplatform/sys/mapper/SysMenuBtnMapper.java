package com.devplatform.sys.mapper;

import java.util.List;

/**
 * SysMenuBtn Mapper
 * 
 * @author
 * 
 */
public interface SysMenuBtnMapper<T> extends BaseMapper<T> {

	public List<T> queryByMenuid(String menuid);

	public List<T> queryByMenuUrl(String url);

	public void deleteByMenuid(String menuid);

	public List<T> getMenuBtnByUser(String userid);

	public List<T> queryByAll();

	public List<T> getMenuBtnByRoleId(String roleid);
}
