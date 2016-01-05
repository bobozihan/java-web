package com.github.hualuomoli.demo.mq_spring.queue;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.activemq.jms.core.QueueJmsTemplate;

@Service(value = R.id.ProducerService)
public class ProducerService extends QueueJmsTemplate {

	/**
	  * 向指定队列发送消息
	  */
	public void sendMessage(Destination queue, final String msg) {
		System.out.println("add message to " + queue.toString() + ",message is " + msg);
		this.send(queue, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

}
