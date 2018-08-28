package com.devplatform.sso.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.devplatform.common.result.CommonResult;
import com.devplatform.common.result.ResultUtil;
import com.devplatform.common.utils.Base64;
import com.devplatform.common.utils.ValidateUtil;
import com.devplatform.common.utils.db.Pager;
import com.devplatform.sso.bean.EcUser;
import com.devplatform.sso.constant.SSOResutlConstant;
import com.devplatform.sso.dao.EcUserDao;
import com.devplatform.sso.redis.RedisDao;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * ec_user的业务实现类 <br>
 * <b>功能：</b>EcUserService<br>
 * 
 * @author liyinchu
 */
@Service("ecUserService")
public class EcUserService {
	protected final static Logger log = LoggerFactory.getLogger(EcUserService.class);

	@Autowired
	private EcUserDao dao;
	
	@Autowired
	private RedisDao redisDao;

	public void add(EcUser t) throws Exception {
		dao.insert(t);// insert 以后，可以直接getid，获取到生成的id；
	}

	public void update(EcUser t) throws Exception {
		dao.updateByPrimaryKey(t);
	}

	public void updateBySelective(EcUser t) throws Exception {
		dao.updateByPrimaryKeySelective(t);
	}

	public void delete(Object... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			dao.deleteByPrimaryKey(id);
		}
	}

	public void deleteFlagById(Object... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			dao.deleteFlagById(id);
		}
	}

	public int queryByCount(EcUser t) throws Exception {
		return dao.selectCount(t);
	}

	public List<EcUser> queryByList(EcUser model) throws Exception {
		// TODO 这个方法不完善，需要开发重新写
		Integer rowCount = queryByCount(model);
		Pager p = new Pager();
		p.setPageSize(10);
		p.setRowCount(rowCount);
		Example example = new Example(EcUser.class);
		RowBounds rowBounds = new RowBounds(p.getPageOffset(), p.getPageSize());
		return dao.selectByExampleAndRowBounds(example, rowBounds);
	}

	public EcUser queryById(long id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}

	private String getToken(String username, String password) throws UnsupportedEncodingException {
		String temp = "";
		HttpResponse response = null;
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost("http://127.0.0.1:8888/oauth/token");
			String author = "Basic " + Base64.getBase64("suntray" + ":" + "suntray");
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
			httpPost.setHeader("Authorization", author);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("grant_type", "password"));
			params.add(new BasicNameValuePair("username", username));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("scope", "all"));
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			response = httpClient.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				HttpEntity entity = response.getEntity();
				temp = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return temp;

	}

	public CommonResult login(EcUser bean) throws UnsupportedEncodingException {
		EcUser queryUser = new EcUser();
		queryUser.setUsername(bean.getUsername());
		EcUser queryResult = dao.selectOne(queryUser);
		if (queryResult == null || queryResult.getDelFlag() == 1) {// 没有用户或已经逻辑删除
			return ResultUtil.getFailed(SSOResutlConstant.LOGIN_FAILED_NOUSER.key, SSOResutlConstant.LOGIN_FAILED_NOUSER.value);
		}
		if ("0".equals(queryResult.getState())) {// 状态已经禁用
			return ResultUtil.getFailed(SSOResutlConstant.LOGIN_FAILED_NOUSER.key, SSOResutlConstant.LOGIN_FAILED_NOUSER.value);
		}
		String token = getToken(String.valueOf(queryResult.getId()), bean.getPassword());
		if (ValidateUtil.isEmpty(token)) {// 权限服务返回错误
			return ResultUtil.getFailed(SSOResutlConstant.LOGIN_FAILED_ERRPWD.key, SSOResutlConstant.LOGIN_FAILED_ERRPWD.value);
		}
		
		redisDao.setEx(token, "user data and auth data", 7200);
		//TODO 查询用户的权限（菜单、按钮）
		//TODO 把用户信息和权限信息（菜单、按钮）存到redis中
		


		return ResultUtil.getSuccess(token);
	}
}
