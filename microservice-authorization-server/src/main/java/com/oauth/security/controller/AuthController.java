package com.oauth.security.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.UnsupportedEncodingException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.security.properties.OAuth2Properties;

@RestController
@Slf4j
public class AuthController {

	@Autowired
	private OAuth2Properties oAuth2Properties;

	@GetMapping("/userJwt")
	public Object getCurrentUserJwt(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
		// log.info("【SecurityOauth2Application】 getCurrentUserJwt authentication={}",
		// JsonUtil.toJson(authentication));

		String header = request.getHeader("Authorization");
		String token = StringUtils.substringAfter(header, "bearer ");

		Claims claims = Jwts.parser().setSigningKey(oAuth2Properties.getJwtSigningKey().getBytes("UTF-8")).parseClaimsJws(token).getBody();
		String blog = (String) claims.get("blog");
		System.out.println(blog);
		return authentication;
	}

	@GetMapping("/userRedis")
	public Object getCurrentUserRedis(Authentication authentication) {
		return authentication;
	}

	@GetMapping("/user/me")
	public Principal user(Principal user) {
		return user;
	}
}
