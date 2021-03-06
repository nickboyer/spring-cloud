/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月12日 下午2:36:25
 */
package com.nickobyer.rabbitMQ.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@RabbitListener(queues = "topic.message") // 启用Rabbit队列监听foo key.
public class TopicReceiver2 {

	@RabbitHandler
	public void reveiceMsg(@Payload String msg) {

		System.out.println("Receive<" + msg + ">-----------------------");
	}
}
