/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月12日 下午5:07:35
 */
package com.nickobyer.rabbitMQ.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Configuration
public class TopicRabbitConfig {

	final static String message = "topic.message";
	final static String messages = "topic.messages";

	@Bean
	public Queue queueMessage() {
		return new Queue(TopicRabbitConfig.message);
	}

	@Bean
	public Queue queueMessages() {
		return new Queue(TopicRabbitConfig.messages);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("topicExchange");
	}

	@Bean
	Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}

	@Bean
	Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}
}