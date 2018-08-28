package com.devplatform.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.devplatform.common.result.ResultUtil;
import com.devplatform.zuul.redis.RedisDao;
import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AuthFilter extends ZuulFilter {

	@Autowired
	private RedisDao redisDao;

	/**
	 * 过滤器类型，pre代表在方法执行前先执行
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器执行顺序，数字越大优先级越低
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

	/**
	 * 是否要过滤
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器执行方法
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String requestURI = request.getRequestURI();
		if (!needAuth(requestURI, ctx)) {// 不需要过滤的
			return null;
		}
		if (hasAuth(requestURI, ctx)) {// 具备权限
			return null;
		} else {
			ctx.getResponse().setCharacterEncoding("UTF-8");
			ctx.getResponse().setContentType("text/json");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			String s = new Gson().toJson(ResultUtil.getFailed("401", "您没有权限访问该服务"));
			System.out.println(s);
			ctx.setResponseBody(s);
			return null;
		}

	}

	private boolean hasAuth(String requestURI, RequestContext ctx) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean needAuth(String requestURI, RequestContext ctx) {
		return true;
	}
}
