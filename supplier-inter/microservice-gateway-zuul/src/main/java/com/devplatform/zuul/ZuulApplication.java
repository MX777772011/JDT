package com.devplatform.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.devplatform.zuul.filter.AuthFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
    @Bean
    public AuthFilter preZuulFilter() {
        return new AuthFilter();
    }
}
