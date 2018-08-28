package com.devplatform.sys.interceptor;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.devplatform.common.annotation.Module;
import com.devplatform.sys.bean.SysLog;
import com.devplatform.sys.bean.SysUser;
import com.devplatform.sys.mapper.SysLogMapper;
import com.devplatform.common.utils.DateUtil;
import com.devplatform.sys.utils.SessionUtils;
import com.google.gson.Gson;

/**
 * 日志拦截器
 * 
 * @author
 * 
 */
@ContextConfiguration(locations = { "classpath:spring-common.xml" })
public class LogInterceptor extends HandlerInterceptorAdapter {
	protected final static Logger log = Logger.getLogger(LogInterceptor.class);

	@Autowired
	private SysLogMapper<SysLog> mapper;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		HandlerMethod method = (HandlerMethod) handler; // 获取到的当前操作方法名
		Module logModule = method.getMethod().getAnnotation(Module.class);// 获取自定义注解数据
		if (logModule != null) {// 如果logModule为空或者方法需要验证
			String path = request.getServletPath(); // 操作路径
			SysUser user = SessionUtils.getUser(request); // 当前操作人员
			Map<String,String[]> map = request.getParameterMap();
			if (user != null) {
				SysLog log = new SysLog();
				log.setOperationTime(DateUtil.getDateByString(""));
				log.setUserId(user.getId());
				log.setOperation(logModule.remark().toString()); // 获取到的操作方法名
				log.setUrl(path);
				log.setModuleName(logModule.module().toString());// 获取到的模块名
				String json = new Gson().toJson(map);
				log.setDetails(json.toString());
				mapper.add(log);
			}
		}
	}
}
