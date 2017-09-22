/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年9月21日 下午2:39:18
 */
package com.nickobyer.eurekaclientfeign;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	HelloMapper mapper;

	@RequestMapping("/test")
	public String test(@RequestParam String name) {

		return mapper.test(name);
	}
}
