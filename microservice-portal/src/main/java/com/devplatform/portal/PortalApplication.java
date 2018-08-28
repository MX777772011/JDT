package com.devplatform.portal;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.devplatform.**.dao")// 指定mybatis的mapper接口所在的包
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
public class PortalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

}
