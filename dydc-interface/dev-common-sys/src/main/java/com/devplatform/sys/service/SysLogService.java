package com.devplatform.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.sys.bean.SysLog;
import com.devplatform.sys.mapper.SysLogMapper;
import com.devplatform.sys.model.SysLogModel;

@Service("sysLogService")
public class SysLogService<T> extends BaseService<T>{

	@Autowired
	private SysLogMapper<T> mapper;
	
	public SysLogMapper<T> getMapper() {
		return mapper;
	}
	
	public void add(T log) throws Exception{
		super.add(log);
	}
	
	public List<SysLog> foundByList(SysLogModel sysLogModel) throws Exception{
		return mapper.foundByList(sysLogModel);
	}
}
