package com.devplatform.sys.mapper;

import java.util.List;

import com.devplatform.sys.bean.SysLog;
import com.devplatform.sys.model.SysLogModel;

public interface SysLogMapper<T> extends BaseMapper<T> {

	public List<SysLog> foundByList(SysLogModel sysLogModel);
}
