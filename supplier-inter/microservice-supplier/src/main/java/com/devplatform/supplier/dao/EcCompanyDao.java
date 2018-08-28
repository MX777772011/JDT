package com.devplatform.supplier.dao;

import org.apache.ibatis.annotations.Update;

import com.devplatform.common.base.BaseMapper;
import com.devplatform.supplier.bean.EcCompany;



/**
 * EcCompany Mapper
 * 用于ec_company的数据库操作
 * @author zsb
 *
 */
public interface EcCompanyDao extends BaseMapper<EcCompany> {
	
	@Update("update ec_company set del_flag=1 where id = ${id}")
	public void deleteFlagById(Object id);
}
