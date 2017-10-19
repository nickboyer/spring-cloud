/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月18日 下午4:23:20
 */
package com.nickboyer.ribbitMQSpring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nickboyer.ribbitMQSpring.entry.MQConstant;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@EnableScheduling
public class Sender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	Logger logger = LoggerFactory.getLogger(Sender.class);

	int a = 1;

	@Scheduled(fixedDelay = 3000) // 3s执行1次此方法;
	public void run() throws Exception {

		MessagePostProcessor processor = new MessagePostProcessor() {

			@Override
			public Message postProcessMessage(Message msg) throws AmqpException {

				msg.getMessageProperties().setExpiration("5000");

				return msg;
			}
		};

		amqpTemplate.convertSendAndReceive(MQConstant.DEFAULT_EXCHANGE, MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME, "测试延迟队列", processor);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.error("第" + a++ + "次发送时间" + s.format(new Date()));
	}

}
