/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月18日 上午11:38:27
 */
package com.nickobyer.rabbitMQ.direct;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.nickobyer.rabbitMQ.entry.MQConstant;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@RabbitListener(queues = MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME)
public class DirectReceiver1 {

	int a = 0;

	@RabbitHandler
	public void process(String content) {

		System.out.println("===============================" + content);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("第" + a++ + "次接受时间" + s.format(new Date()));
	}
}
