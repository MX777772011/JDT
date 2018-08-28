package com.devplatform.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.devplatform.common.annotation.Auth;
import com.devplatform.common.utils.HtmlUtil;

/**
 * 权限拦截器
 * 
 * @author
 * 
 */
public class PageAuthInterceptor extends HandlerInterceptorAdapter {
	protected final static Logger log = Logger.getLogger(PageAuthInterceptor.class);

	
	private void sendErr(HttpServletRequest request, HttpServletResponse response){
		HtmlUtil.writerHtml(response, "<script language=\"javascript\">alert('您还没有登录')</script>");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 不是.shtml 结尾的请求，一律不正常校验
		if (!request.getServletPath().endsWith(".shtml")) {
			if (!request.getServletPath().endsWith(".do")) {
				sendErr(request, response);
				return false;
			}else{
				return super.preHandle(request, response, handler);
			}
		}
		HandlerMethod method = (HandlerMethod) handler;
		Auth auth = method.getMethod().getAnnotation(Auth.class);
		// 如果auth为空或者方法需要验证
		if (auth == null || auth.verifyLogin()) {
			
		}
		return super.preHandle(request, response, handler);
	}
}
