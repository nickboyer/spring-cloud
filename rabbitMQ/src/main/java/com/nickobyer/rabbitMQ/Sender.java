/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月12日 下午2:47:24
 */
package com.nickobyer.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nickobyer.rabbitMQ.entry.Person;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@EnableScheduling
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(fixedDelay = 3000) // 3s执行1次此方法;
	public void run() throws Exception {

		Person p = new Person("zhangsan", "12");

		// 发布、订阅模式
		// System.out.println("start.....................");
		// rabbitTemplate.convertAndSend("topicExchange", "topic.messages", "hello rabbit");
		// 广播模式
		System.out.println("start.....................");
		rabbitTemplate.convertAndSend("fanoutExchange", "fanout.a", p);
	}

}
