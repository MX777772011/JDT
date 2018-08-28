package com.oauth.security.security.jwt;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.devplatform.common.result.CommonResult;
import com.devplatform.common.utils.ValidateUtil;
import com.oauth.security.feign.UserFeignService;

/**
 * Created on 2018/7/17.
 *
 * @author szy
 * @since 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserFeignService userFeignService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserAccount userAccount = userService.getUserByid(username);
//		 return new User(
//		 userAccount.getUsername(), // 用户名
//		 userAccount.getPassword(), // 密码
//		 AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));//权限集合
		if(ValidateUtil.isEmpty(username)||!ValidateUtil.isLong(username)){
			return new User("no user", "no password", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
		}
		long id = Long.parseLong(username);
		CommonResult userResult = userFeignService.findById(id);
		if(!userResult.getCode().equals("200")){
			return new User("no user", "no password", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
		}
		@SuppressWarnings("rawtypes")
		Map ecu = (Map) userResult.getData();
		
		return new User(username, String.valueOf(ecu.get("password")), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));


	}
}
