package com.softeer.caart.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
@EnableFeignClients("com.softeer.caart.global.feign")
public class FeignConfig {

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	// @Bean
	// public RequestInterceptor requestInterceptor() {
	// 	return requestTemplate -> requestTemplate.header("Content-type",
	// 		"application/x-www-form-urlencoded;charset=utf-8");
	// }
}

