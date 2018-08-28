package com.devplatform.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.devplatform.common.annotation.Auth;

/**
 * 权限拦截器
 * 
 * @author
 * 
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	protected final static Logger log = Logger.getLogger(AuthInterceptor.class);

	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 不是.do 结尾的请求，不做处理
		if (!request.getServletPath().endsWith(".do")) {
			return super.preHandle(request, response, handler);
		}
		// 没有设备表示的请求，视为非法请求。
		HandlerMethod method = (HandlerMethod) handler;
		Auth auth = method.getMethod().getAnnotation(Auth.class);
		// 如果auth为空或者方法需要验证
		if (auth == null || auth.verifyLogin()) {
			
		}else{
			
		}
		
		
		
		return super.preHandle(request, response, handler);
	}
}
