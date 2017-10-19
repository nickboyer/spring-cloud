/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月18日 上午10:25:52
 */
package com.nickobyer.rabbitMQ.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.nickobyer.rabbitMQ.entry.MQConstant;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@RabbitListener(queues = MQConstant.HELLO_QUEUE_NAME)
public class DirectReceiver {

	@RabbitListener
	public void receiverMsg(String p) {
		System.out.println("Receive<direct.a><" + p + ">-----------------------");
	}
}
