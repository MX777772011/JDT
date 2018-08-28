package com.oauth.security.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devplatform.common.result.CommonResult;


@FeignClient("microservice-sso")
public interface UserFeignService {

	
	@RequestMapping(value = "/authget/{id}", method = RequestMethod.GET)
	public CommonResult findById(@PathVariable("id") long id);
	
}
