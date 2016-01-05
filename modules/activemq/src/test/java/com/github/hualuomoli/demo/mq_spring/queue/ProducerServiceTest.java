package com.github.hualuomoli.demo.mq_spring.queue;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;

import org.junit.Test;

import com.github.hualuomoli.activemq.jms.DestinationName;
import com.github.hualuomoli.junit4.SpringTestRunner;

public class ProducerServiceTest extends SpringTestRunner {

	@Resource(name = R.id.ProducerService)
	private ProducerService producerService;

	@Test
	public void testSendMessageDestinationString() throws InterruptedException {

		Destination destination = new Queue() {
			@Override
			public String getQueueName() throws JMSException {
				return DestinationName.QUEUE;
			}

			@Override
			public String toString() {
				try {
					return this.getQueueName();
				} catch (JMSException e) {
					e.printStackTrace();
				}
				return null;
			}
		};

		// 生产10个数据
		for (int i = 0; i < 10; i++) {
			producerService.sendMessage(destination, "使用spring的方式发送第" + (i + 1) + "次消息");
		}

		System.out.println("^^^^^^^^^^^^^^^^^^^^^");

		// 等待listener消费完
		Thread.sleep(10 * 1000);

	}

}
