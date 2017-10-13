/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月13日 上午10:22:06
 */
package com.nickobyer.activeMQ;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
public class Receiver {

	@JmsListener(destination = "activeMQ")
	public void receiverMsg(@Payload byte[] p) {

		Person person = (Person) SerializationUtils.deserialize(p);
		System.out.println("activeMQ Receiver<" + person + ">");
	}
}
