package com.github.hualuomoli.mq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Send {

	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		System.out.println("start...");

		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue destination = session.createQueue("example.C");

		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);

		TextMessage message = session.createTextMessage("测试");
		producer.send(message);
		session.commit();

		connection.close();
		System.out.println("send text ok.");
	}

}
