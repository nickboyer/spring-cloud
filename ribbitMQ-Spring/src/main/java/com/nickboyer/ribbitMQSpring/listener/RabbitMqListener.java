/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月18日 下午4:57:45
 */
package com.nickboyer.ribbitMQSpring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class RabbitMqListener implements MessageListener {

	Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.springframework.amqp.core.MessageListener#onMessage(org.springframework.amqp.core.Message)
	 */
	@Override
	public void onMessage(Message message) {

		logger.error("接收到消息:" + new String(message.getBody()));

	}

}
