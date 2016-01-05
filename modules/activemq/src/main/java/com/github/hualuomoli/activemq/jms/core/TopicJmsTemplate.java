package com.github.hualuomoli.activemq.jms.core;

import com.github.hualuomoli.activemq.jms.DestinationName;

public class TopicJmsTemplate extends JmsTemplate {

	public TopicJmsTemplate() {
		this(DestinationName.TOPIC);
	}

	public TopicJmsTemplate(String destinationName) {
		super(destinationName);
		setPubSubDomain(true);
	}

}
