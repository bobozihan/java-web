package com.github.hualuomoli.activemq.jms.core;

import com.github.hualuomoli.activemq.jms.DestinationName;

public class TopicJmsTemplate extends JmsTemplate {

	public TopicJmsTemplate() {
		super(DestinationName.TOPIC);
		setPubSubDomain(true);
	}

}
