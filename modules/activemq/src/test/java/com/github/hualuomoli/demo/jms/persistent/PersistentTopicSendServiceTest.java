package com.github.hualuomoli.demo.jms.persistent;

import javax.annotation.Resource;

import org.junit.Test;

import com.github.hualuomoli.junit4.SpringTestRunner;

public class PersistentTopicSendServiceTest extends SpringTestRunner {

	@Resource(name = R.id.PersistentTopicSendService)
	private PersistentTopicSendService persistentTopicSendService;

	@Test
	public void testSendMessageString() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			persistentTopicSendService.sendMessage("this is text message. index is " + (i + 1));
		}

		// 等待listener消费完
		Thread.sleep(10 * 1000);
	}

}
