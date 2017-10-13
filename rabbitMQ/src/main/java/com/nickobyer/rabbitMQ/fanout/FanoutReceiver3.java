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

import com.nickobyer.rabbitMQ.entry.Person;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@RabbitListener(queues = "fanout.c")
public class FanoutReceiver3 {

	@RabbitHandler
	public void reveiceMsg(@Payload Person msg) {

		System.out.println("Receive<fanout.c><" + msg + ">-----------------------");
	}
}
