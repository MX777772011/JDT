package com.devplatform.supplier.dao;

import org.apache.ibatis.annotations.Update;

import com.devplatform.common.base.BaseMapper;
import com.devplatform.supplier.bean.EcCompanyInfo;



/**
 * EcCompanyInfo Mapper
 * 用于ec_company_info的数据库操作
 * @author zsb
 *
 */
public interface EcCompanyInfoDao extends BaseMapper<EcCompanyInfo> {
	
	@Update("update ec_company_info set del_flag=1 where id = ${id}")
	public void deleteFlagById(Object id);
}
