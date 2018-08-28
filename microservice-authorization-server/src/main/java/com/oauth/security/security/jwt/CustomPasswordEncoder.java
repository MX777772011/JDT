package com.oauth.security.security.jwt;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.devplatform.common.utils.PasswordUtil;

/**
 * Created on 2018/7/17. 配置密码加密方式，用来JWT验证用户密码
 *
 * @author szy
 * @since 1.0
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return PasswordUtil.hashPwd(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		try {
			String md5Pwd = PasswordUtil.hashPwd(rawPassword.toString());
			if (encodedPassword.equals(md5Pwd)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

}
