package com.devplatform.supplier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplatform.common.result.CommonResult;
import com.devplatform.supplier.feign.TestFeignService;
import com.devplatform.supplier.feign.bean.TestUser;

/**
 * delete_user的业务实现类
 * <br>
 * <b>功能：</b>DeleteUserService<br>
 * @author liyinchu
 */
@Service("deleteUserService")
public class TestService{
	protected final static Logger log= LoggerFactory.getLogger(TestService.class);

	@Autowired
    private TestFeignService testFeignService;



	public CommonResult queryById(long id) throws Exception {
		return testFeignService.findById(id);
	}



	public CommonResult add(TestUser bean) {
		
		return testFeignService.addOrUpdate(bean);
		
	}



	public CommonResult updateBySelective(TestUser bean) {
		return testFeignService.addOrUpdate(bean);
	}

}
