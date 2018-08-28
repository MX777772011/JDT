package com.devplatform.supplier.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devplatform.common.result.CommonResult;
import com.devplatform.supplier.feign.bean.TestUser;

@FeignClient("microservice-message")
public interface TestFeignService {

	@RequestMapping(value = "/deleteUser/get/{id}", method = RequestMethod.GET)
	public CommonResult findById(@PathVariable("id") long id);

	@RequestMapping(value = "/deleteUser/save", method = RequestMethod.POST)
	public CommonResult addOrUpdate(TestUser bean);

}
