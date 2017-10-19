/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月12日 下午2:47:24
 */
package com.nickobyer.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nickobyer.rabbitMQ.entry.MQConstant;
import com.nickobyer.rabbitMQ.entry.Person;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Component
@EnableScheduling
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	int a = 0;

	@Scheduled(fixedDelay = 3000) // 3s执行1次此方法;
	public void run() throws Exception {

		Person p = new Person("zhangsan", "12");

		// // 发布、订阅模式
		// System.out.println("start.....................");
		// rabbitTemplate.convertAndSend("topicExchange", "topic.messages", "hello rabbit");
		// // 广播模式
		// System.out.println("start.....................");
		// rabbitTemplate.convertAndSend("fanoutExchange", "fanout.a", p);
		// // 直连模式
		System.out.println("start.....................");
		rabbitTemplate.convertAndSend(MQConstant.DEFAULT_EXCHANGE, MQConstant.HELLO_QUEUE_NAME, "测试directReceiver");

		// // 延迟消息
		// MessagePostProcessor processor = new MessagePostProcessor() {
		// @Override
		// public Message postProcessMessage(Message message) throws AmqpException {
		// message.getMessageProperties().setExpiration("5000");
		// return message;
		// }
		// };
		// rabbitTemplate.convertAndSend(MQConstant.DEFAULT_EXCHANGE, MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME, "测试延迟队列1", processor);
		// SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// rabbitTemplate.convertAndSend(MQConstant.DEFAULT_EXCHANGE, MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME, "测试延迟队列2", processor);
		//
		// System.out.println("第" + a++ + "次发送时间" + s.format(new Date()));
	}

}
