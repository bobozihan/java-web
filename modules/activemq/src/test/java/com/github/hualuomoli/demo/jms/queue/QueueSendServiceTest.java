package com.github.hualuomoli.demo.jms.queue;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.junit.Test;

import com.github.hualuomoli.junit4.SpringTestRunner;

public class QueueSendServiceTest extends SpringTestRunner {

	@Resource(name = R.id.QueueSendService)
	private QueueSendService queueSendService;

	@Test
	public void testSendTextMessage() throws InterruptedException, UnsupportedEncodingException {
		for (int i = 0; i < 10; i++) {
			queueSendService.sendMessage("this is text message. index is " + (i + 1));
			// queueSendService.sendMessage("测试字节流".getBytes("UTF-8"));
		}

		// 等待listener消费完
		Thread.sleep(10 * 1000);

	}

}
