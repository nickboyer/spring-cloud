/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年9月21日 下午2:00:02
 */
package com.nickobyer.eurekaclientribbon2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;

	// @HystrixCommand(fallbackMethod = "hiError")
	public String hiService(String name) {

		return restTemplate.getForObject("http://eureka-client-1/test?name=" + name, String.class);
	}

	public String hiError(String name) {
		return "hi," + name + ",sorry,error!";
	}
}
