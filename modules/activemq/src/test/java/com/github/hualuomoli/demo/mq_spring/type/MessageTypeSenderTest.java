package com.github.hualuomoli.demo.mq_spring.type;

import javax.annotation.Resource;

import org.junit.Test;

import com.github.hualuomoli.junit4.SpringTestRunner;

public class MessageTypeSenderTest extends SpringTestRunner {

	@Resource(name = R.id.MessageTypeSender)
	private MessageTypeSender messageTypeSender;

	@Test
	public void testMe() {
		messageTypeSender.sendTextMessage();
		messageTypeSender.sendMapMessage();
		messageTypeSender.sendObjectMessage();
		messageTypeSender.sendBytesMessage();
		messageTypeSender.sendStreamMessage();
	}

}
