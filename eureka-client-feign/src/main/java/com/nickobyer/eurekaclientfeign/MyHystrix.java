/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年9月21日 下午2:54:15
 */
package com.nickobyer.eurekaclientfeign;

import org.springframework.stereotype.Component;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
public class MyHystrix implements HelloMapper {

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.nickobyer.eurekaclientfeign.HelloMapper#test(java.lang.String)
	 */
	@Override
	public String test(String name) {

		return "sorry," + name;
	}

}
