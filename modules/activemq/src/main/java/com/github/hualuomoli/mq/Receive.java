package com.github.hualuomoli.mq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Receive {

	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue destination = session.createQueue("example.C");

		MessageConsumer consumer = session.createConsumer(destination);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				System.out.println("111111111");
				System.out.println(message);
				try {
					session.commit();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
