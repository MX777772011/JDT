package com.devplatform.business.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.business.mapper.${bean.className}Mapper;
import com.devplatform.sys.service.BaseService;

/**
 * ${bean.tableRemark}的业务实现类
 * <br>
 * <b>功能：</b>${bean.className}Service<br>
 * @author 代码生成器产生
 */
@Service("${bean.lowerName}Service")
public class ${bean.className}Service<T> extends BaseService<T> {
	protected final static Logger log= Logger.getLogger(${bean.className}Service.class);

	@Autowired
	private ${bean.className}Mapper<T> mapper;

		
	public ${bean.className}Mapper<T> getMapper() {
		return mapper;
	}

}
