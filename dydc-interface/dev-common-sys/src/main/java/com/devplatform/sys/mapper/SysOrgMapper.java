package com.devplatform.sys.mapper;

import java.util.List;
import com.devplatform.sys.bean.SysOrg;
import com.devplatform.sys.model.SysOrgModel;


public interface SysOrgMapper<T> extends BaseMapper<T> {

	public List<T> getOrgList();
		
	public void updateOrgNodes(SysOrg sysOrg);
	
	public void addOrgNodes(SysOrg sysOrg);
	
	public SysOrg getOrgById(String id);
	
	public void zTreeOnDrop(SysOrg sysOrg);
	
	public List<String> getOrgByOrgId(String id);
	
	public List<SysOrg> queryByUser(SysOrgModel orgModel);	
}
