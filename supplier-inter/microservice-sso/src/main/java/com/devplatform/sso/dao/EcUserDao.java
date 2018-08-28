package com.devplatform.sso.dao;

import org.apache.ibatis.annotations.Update;

import com.devplatform.common.base.BaseMapper;
import com.devplatform.sso.bean.EcUser;



/**
 * EcUser Mapper
 * 用于ec_user的数据库操作
 * @author liyinchu
 *
 */
public interface EcUserDao extends BaseMapper<EcUser> {
	
	@Update("update ec_user set del_flag=1 where id = #{id}")
	public void deleteFlagById(Object id);
}
