package com.github.hualuomoli.demo.jms.custom.persistent;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 持久化topic的生产者没有任何的不同
 * @author 刘保全
 *
 */
public class PersistentTopicSend {

	public static void main(String[] args) throws InterruptedException {
		PersistentTopicSend pb = new PersistentTopicSend();
		String msg = "persistent";
		pb.sendMessage(msg);
		System.out.println("发送消息结束：" + msg);
	}

	/**
	 * 使用JMS向MQ发送消息
	 * 
	 * @param msg 消息内容
	 * @throws InterruptedException 
	 */
	public void sendMessage(String msg) throws InterruptedException {
		// defualt user & password both are null
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		// DEFAULT_BROKER_URL =failover://tcp://localhost:61616
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;
		String subject = "JMS.PERSISTENT.TOPIC";

		// 1. 初始化连接工厂
		ConnectionFactory contectionFactory = new ActiveMQConnectionFactory(user, password, url);
		try {
			// 2. 创建连接
			Connection connection = contectionFactory.createConnection();
			connection.start();
			// 3.创建会话
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 4. 创建要发布的主题，和Queue的区别就在此
			Destination destination = session.createTopic(subject);
			// 5. MessageProducer负责发送消息
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage();
			// 6. 发送消息
			for (int i = 0; i < 60; i++) {
				String tmp = i + ":" + msg;
				message.setStringProperty("hello", tmp);
				// 6. 发送消息
				producer.send(message);
				System.out.println("send: " + tmp);
				Thread.sleep(1000);
				//只有commit之后，消息才会进入队列
				session.commit();

			}

			// 7. 关闭会话和连接
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
