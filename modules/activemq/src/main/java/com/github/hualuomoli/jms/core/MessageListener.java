package com.github.hualuomoli.jms.core;

import javax.jms.BytesMessage;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public abstract class MessageListener extends DefaultMessageListenerContainer implements javax.jms.MessageListener {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public MessageListener() {
		super();
		setDestinationName(getDestinationName());
		setMessageListener(this);
		addConfig();
	}

	public abstract void addConfig();

	public abstract String getDestinationName();

	public abstract ConnectionFactory getConnectionFactory();

	@Override
	public void onMessage(Message message) {

		try {
			if (message instanceof TextMessage) {
				this.onTextMessage((TextMessage) message);
				return;
			}
			if (message instanceof ObjectMessage) {
				this.onObjectMessage((ObjectMessage) message);
				return;
			}
			if (message instanceof BytesMessage) {
				this.onBytesMessage((BytesMessage) message);
				return;
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public void onTextMessage(TextMessage message) throws JMSException {
		if (logger.isInfoEnabled())
			logger.info("get text message:{}", message.getText());
	}

	public void onObjectMessage(ObjectMessage message) {
		if (logger.isInfoEnabled())
			logger.info("get object message:{}", message);
	}

	public void onBytesMessage(BytesMessage message) throws JMSException {
		byte[] datas = new byte[1024];
		int length = -1;
		while ((length = message.readBytes(datas)) != -1) {
			if (logger.isInfoEnabled())
				logger.info("get bytes message:{}", new String(datas, 0, length));
		}
	}
}
