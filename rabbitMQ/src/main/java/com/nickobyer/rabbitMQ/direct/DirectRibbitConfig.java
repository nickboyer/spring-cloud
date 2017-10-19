/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月18日 上午10:18:34
 */
package com.nickobyer.rabbitMQ.direct;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nickobyer.rabbitMQ.entry.MQConstant;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Configuration
public class DirectRibbitConfig {

	// 信道配置
	@Bean
	public DirectExchange defaultExchange() {
		return new DirectExchange(MQConstant.DEFAULT_EXCHANGE, true, false);
	}

	/********************* hello 队列 测试 *****************/
	@Bean
	public Queue queue() {
		Queue queue = new Queue(MQConstant.HELLO_QUEUE_NAME, true);
		// Map<String, Object> arguments = new HashMap<>();
		// arguments.put("x-dead-letter-exchange", MQConstant.DEFAULT_EXCHANGE);
		// arguments.put("x-dead-letter-routing-key", MQConstant.HELLO_QUEUE_NAME);
		// Queue queue = new Queue(MQConstant.HELLO_QUEUE_NAME, true, false, false, arguments);
		return queue;
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(defaultExchange()).with(MQConstant.HELLO_QUEUE_NAME);
	}

	@Bean
	public Queue repeatTradeQueue() {
		Queue queue = new Queue(MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME, true, false, false);
		return queue;
	}

	@Bean
	public Binding drepeatTradeBinding() {
		return BindingBuilder.bind(repeatTradeQueue()).to(defaultExchange()).with(MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME);
	}

	@Bean
	public Queue deadLetterQueue() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", MQConstant.DEFAULT_EXCHANGE);
		arguments.put("x-dead-letter-routing-key", MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME);
		Queue queue = new Queue(MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME, true, false, false, arguments);
		System.out.println("arguments :" + queue.getArguments());
		return queue;
	}

	@Bean
	public Binding deadLetterBinding() {
		return BindingBuilder.bind(deadLetterQueue()).to(defaultExchange()).with(MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME);
	}

}
