package com.github.hualuomoli.demo.mq_spring.topic;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.activemq.jms.core.TopicJmsTemplate;

@Service(value = R.id.ProviderService)
public class ProviderService extends TopicJmsTemplate {

	/**
	  * 向指定队列发送消息
	  */
	public void publish(Destination topic, final String msg) {
		System.out.println("add message to " + topic.toString() + ",message is " + msg);
		this.send(topic, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

}
