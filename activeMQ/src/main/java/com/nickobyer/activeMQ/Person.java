/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月13日 上午10:57:59
 */
package com.nickobyer.activeMQ;

import java.io.Serializable;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class Person implements Serializable {

	private static final long serialVersionUID = -5530156273077724177L;

	private String name;

	private String age;

	/**
	 * @return age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age 要设置的 age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

}
