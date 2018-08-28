package com.devplatform.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.sys.bean.SysRoleRel;
import com.devplatform.sys.bean.SysUser;
import com.devplatform.sys.bean.SysRoleRel.RelType;
import com.devplatform.sys.mapper.SysOrgMapper;
import com.devplatform.sys.mapper.SysUserMapper;
import com.devplatform.sys.model.BaseModel;
import com.devplatform.sys.model.SysUserModel;

/**
 * 
 * <br>
 * <b>功能：</b>SysUserService<br>
 * <b>作者：</b><br>
 * <b>日期：</b> 2013-03-01 <br>
 */
@Service("sysUserService")
public class SysUserService<T> extends BaseService<T> {
	
	protected final static Logger log = Logger.getLogger(SysUserService.class);

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	@Autowired
	private SysOrgMapper<T> orgMapper;
	@Autowired
	private SysUserMapper<SysUser> mapper;

	@SuppressWarnings("unchecked")
	public SysUserMapper<T> getMapper() {
		return (SysUserMapper<T>) mapper;
	}
	@Override
	public void delete(Object[] ids) throws Exception {
		super.delete(ids);
		for (Object id : ids) {
			sysRoleRelService.deleteByObjId((String) id, RelType.USER.key);
		}
	}

	/**
	 * 检查登录
	 * 
	 * @param email
	 * @param pwd
	 * @return
	 */
	public T queryLogin(String email, String pwd) {
		SysUserModel model = new SysUserModel();
		model.setEmail(email);
		model.setPwd(pwd);
		return getMapper().queryLogin(model);
	}

	/**
	 * 查询邮箱总数，检查是否存在
	 * 
	 * @param email
	 * @return
	 */
	public int getUserCountByEmail(String email) {
		return getMapper().getUserCountByEmail(email);
	}

	/**
	 * 查询用户权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<SysRoleRel> getUserRole(String userId) {
		return sysRoleRelService.queryByObjId(userId, RelType.USER.key);
	}

	/**
	 * 添加用户权限
	 * 
	 * @param userId
	 * @param roleIds
	 * @throws Exception
	 */
	public void addUserRole(String userId, String[] roleIds) throws Exception {
		if (userId == null ) {
			return;
		} 
		// 清除关联关系
		sysRoleRelService.deleteByObjId(userId, RelType.USER.key);
		if(roleIds == null || roleIds.length < 1){
			return;//清除了关联关系，就返回
		} 
		for (String roleId : roleIds) {
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(userId);
			rel.setRelType(RelType.USER.key);
			sysRoleRelService.add(rel);
		}
	}
	
	/**
	 * 查询用户列表
	 * 
	 * @param 
	 * @param 
	 * @throws Exception
	 */
	@Override
	public List<T> queryByList(BaseModel sysUserModel) throws Exception {
		SysUserModel model= (SysUserModel)sysUserModel;
		if(model.getOrgId()!=null){
			List<String> childIds=this.getOrgByOrgId(model.getOrgId());
			childIds.add(model.getOrgId());//add FatherId in it
			model.setSysOrgIdList(childIds);
		}
		Integer rowCount = queryByCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryByList(model);
	}
	
	

	/**
	 * 根据pid递归查询id
	 * 
	 * @param 
	 * @param 
	 * @throws Exception
	 */
	public List<String> getOrgByOrgId(String id){
		List<String> list=new ArrayList<String>();
		List<String> childList=new ArrayList<String>();
		  childList = orgMapper.getOrgByOrgId(id);
		 if(null!=childList && childList.size()>0){
				for (String childId : childList) {
					list.add(childId);
					list.addAll(getOrgByOrgId(childId));
				}
			}
		return   list;
	}
	
	
	public List<T> queryByListAll(BaseModel model) throws Exception {
		return getMapper().queryByListAll(model);
	}
	/**
	 * 查询用户 
	 * @param user
	 * @return
	 */
	public SysUser getUserByOrgIdOrNickName(SysUser user) {
		return	getMapper().getUserByOrgIdOrNickName(user);
	}
	
	
}
