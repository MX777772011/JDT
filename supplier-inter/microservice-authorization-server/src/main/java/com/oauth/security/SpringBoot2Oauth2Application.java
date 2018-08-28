package com.oauth.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 2018/4/28.
 *
 * @author szy
 * @since 1.0
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.oauth.security"})
public class SpringBoot2Oauth2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Oauth2Application.class, args);
    }


}
