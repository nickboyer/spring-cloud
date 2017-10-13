/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月13日 上午10:15:35
 */
package com.nickobyer.activeMQ;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 消息发布
 * 
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@EnableScheduling
public class Sender {

	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	@Scheduled(fixedDelay = 1000)
	public void sendMsg() {
		Destination destination = new ActiveMQQueue("activeMQ");
		// jmsTemplate.convertAndSend(destination, "hello activeMQ");

		Person p = new Person("张三", "12");
		System.err.println("Sender" + p.toString());
		jmsTemplate.convertAndSend("activeMQ", SerializationUtils.serialize(p));
	}
}
