/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月12日 下午5:21:47
 */
package com.nickobyer.rabbitMQ.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 
 * 
 * 
 * @title
 * @description
 * @since JDK1.8
 */
@Configuration
public class FanoutRabbitConfig {

	@Bean
	public Queue a() {
		return new Queue("fanout.a");
	}

	@Bean
	public Queue b() {
		return new Queue("fanout.b");
	}

	@Bean
	public Queue c() {
		return new Queue("fanout.c");
	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}

	@Bean
	Binding bindingA(Queue a, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(a).to(fanoutExchange);
	}

	@Bean
	Binding bindingB(Queue b, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(b).to(fanoutExchange);
	}

	@Bean
	Binding bindingC(Queue c, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(c).to(fanoutExchange);
	}

}
