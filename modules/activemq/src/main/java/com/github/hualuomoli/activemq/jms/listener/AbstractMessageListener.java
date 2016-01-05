package com.github.hualuomoli.activemq.jms.listener;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

public abstract class AbstractMessageListener extends DefaultMessageListenerContainer implements MessageListener {

	@Resource(name = "connectionFactory")
	private ConnectionFactory connectionFactory;

	public AbstractMessageListener(String destinationName) {
		setDestinationName(destinationName);
		setMessageListener(this);
	}

	@Override
	public ConnectionFactory getConnectionFactory() {
		return this.connectionFactory;
	}

}
