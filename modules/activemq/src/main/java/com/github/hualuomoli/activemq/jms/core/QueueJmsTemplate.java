package com.github.hualuomoli.activemq.jms.core;

import com.github.hualuomoli.activemq.jms.DestinationName;

public class QueueJmsTemplate extends JmsTemplate {

	public QueueJmsTemplate() {
		this(DestinationName.QUEUE);
	}

	public QueueJmsTemplate(String destinationName) {
		super(destinationName);
	}

}
