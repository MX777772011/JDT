package com.devplatform.${bean.serviceName}.dao;

import org.apache.ibatis.annotations.Update;

import com.devplatform.common.base.BaseMapper;
import com.devplatform.${bean.serviceName}.bean.${bean.className};



/**
 * ${bean.className} Mapper
 * 用于${bean.tableName}的数据库操作
 * @author LJY
 *
 */
public interface ${bean.className}Dao extends BaseMapper<${bean.className}> {
	
	@Update("update ${bean.tableName} set del_flag=1 where id = _#_{id}")
	public void deleteFlagById(Object id);
}
