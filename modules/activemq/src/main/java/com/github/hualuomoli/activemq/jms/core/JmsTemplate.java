package com.github.hualuomoli.activemq.jms.core;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;

public abstract class JmsTemplate extends org.springframework.jms.core.JmsTemplate {

	@Resource(name = "connectionFactory")
	private ConnectionFactory connectionFactory;

	public JmsTemplate(String destinationName) {
		super();
		setDefaultDestinationName(destinationName);
	}

	@Override
	public ConnectionFactory getConnectionFactory() {
		return this.connectionFactory;
	}

}
