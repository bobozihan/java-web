package com.github.hualuomoli.demo.mq_spring.topic;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Topic;

import org.junit.Test;

import com.github.hualuomoli.activemq.jms.DestinationName;
import com.github.hualuomoli.junit4.SpringTestRunner;

public class ProviderServiceTest extends SpringTestRunner {

	@Resource(name = R.id.ProviderService)
	private ProviderService providerService;

	@Test
	public void testPublish() throws InterruptedException {
		Destination destination = new Topic() {

			@Override
			public String getTopicName() throws JMSException {
				return DestinationName.TOPIC;
			}

			@Override
			public String toString() {
				try {
					return this.getTopicName();
				} catch (JMSException e) {
					e.printStackTrace();
				}
				return null;
			}

		};

		// 生产10个数据
		for (int i = 0; i < 10; i++) {
			providerService.publish(destination, "使用spring的方式发送第" + (i + 1) + "次消息");
		}

		System.out.println("^^^^^^^^^^^^^^^^^^^^^");

		// 等待listener消费完
		Thread.sleep(10 * 1000);
	}

}
