/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年9月21日 下午1:04:29
 */
package com.nickobyer.eurekaclientribbon1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@RestController
public class Controller {

	@Value("${server.port}")
	String port;

	@RequestMapping("/test")
	public String test(@RequestParam String name) {

		return "hello_" + name + "----" + port;
	}
}
