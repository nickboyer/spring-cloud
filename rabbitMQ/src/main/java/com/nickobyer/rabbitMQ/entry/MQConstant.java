/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年10月18日 上午11:12:05
 */
package com.nickobyer.rabbitMQ.entry;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public final class MQConstant {

	private MQConstant() {
	}

	// exchange name
	public static final String DEFAULT_EXCHANGE = "KSHOP";

	// DLX QUEUE
	public static final String DEFAULT_DEAD_LETTER_QUEUE_NAME = "kshop.dead.letter.queue";

	// DLX repeat QUEUE 死信转发队列
	public static final String DEFAULT_REPEAT_TRADE_QUEUE_NAME = "kshop.repeat.trade.queue";

	// Hello 测试消息队列名称
	public static final String HELLO_QUEUE_NAME = "hello";

	public static final String ROUTING_KEY_1 = "key1";

}