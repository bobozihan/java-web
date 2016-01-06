package com.github.hualuomoli.demo.jms.custom.persistent;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 1、设置连接的clientID
 * 2、使用session.createDurableSubscriber(topic, clientID);获取MessageConsumer
 * @author 刘保全
 *
 */
public class PersistentTopicRececive {

	public static void main(String[] args) throws InterruptedException {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = ActiveMQConnection.DEFAULT_BROKER_URL;
		String subject = "JMS.PERSISTENT.TOPIC";
		String clientID = "aaa";
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
		connectionFactory.setUseAsyncSend(true); // 
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.setClientID(clientID); //持久订阅需要设置这个。
			connection.start();
			final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic(subject);
			// MessageConsumer负责接受消息
			MessageConsumer consumer = session.createDurableSubscriber(topic, clientID);
			consumer.setMessageListener(new MessageListener() {

				public void onMessage(Message msg) {
					TextMessage message = (TextMessage) msg;
					try {
						String hello = message.getStringProperty("hello");
						System.out.println("订阅者---SecondSubscriber---收到消息：\t" + hello);
						session.commit();
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
			// 为了测试效果，注释掉了两行代码，使Session和connection一直处于打开状态
			Thread.sleep(60 * 1000);
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
