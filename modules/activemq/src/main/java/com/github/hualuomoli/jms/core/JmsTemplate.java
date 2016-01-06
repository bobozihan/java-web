package com.github.hualuomoli.jms.core;

import java.io.Serializable;

import javax.jms.BytesMessage;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.MessageCreator;

public abstract class JmsTemplate extends org.springframework.jms.core.JmsTemplate {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public JmsTemplate() {
		super();
		setDefaultDestinationName(getDefaultDestinationName());
		addConfig();
	}

	public abstract void addConfig();

	public abstract String getDestinationName();

	public abstract ConnectionFactory getConnectionFactory();

	@Override
	public String getDefaultDestinationName() {
		return "JMS";
	}

	public void sendMessage(final String textMessage) {

		if (logger.isInfoEnabled())
			logger.info("send message:{}", textMessage);

		super.send(getDestinationName(), new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(textMessage);
			}
		});
	}

	public void sendMessage(final Serializable objectMessage) {

		if (logger.isInfoEnabled())
			logger.info("send message:{}", objectMessage);

		super.send(getDestinationName(), new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(objectMessage);
			}
		});
	}

	public void sendMessage(final byte[] bytes) {

		if (logger.isInfoEnabled())
			logger.info("send message:{}", new String(bytes));
		super.send(getDestinationName(), new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				BytesMessage message = session.createBytesMessage();
				message.writeBytes(bytes);
				return message;
			}
		});
	}

}
