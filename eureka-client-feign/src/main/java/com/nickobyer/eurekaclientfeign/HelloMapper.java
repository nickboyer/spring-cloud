/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年9月21日 下午2:37:31
 */
package com.nickobyer.eurekaclientfeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@FeignClient(value = "eureka-client-1", fallback = MyHystrix.class)
public interface HelloMapper {

	@RequestMapping("/test")
	String test(@RequestParam(value = "name") String name);
}
