/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月12日 下午5:27:45
 */
package com.nickobyer.rabbitMQ.fanout;

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
@RabbitListener(queues = "fanout.a")
public class FanoutReceiver1 {

	@RabbitHandler
	public void reveiceMsg(@Payload String msg) {

		System.out.println("Receive<fanout.a><" + msg + ">-----------------------");
	}
}
