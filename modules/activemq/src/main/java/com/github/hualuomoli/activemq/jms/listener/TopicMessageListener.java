package com.github.hualuomoli.activemq.jms.listener;

import com.github.hualuomoli.activemq.jms.DestinationName;

public abstract class TopicMessageListener extends AbstractMessageListener {

	public TopicMessageListener() {
		this(DestinationName.TOPIC);
	}

	public TopicMessageListener(String destinationName) {
		super(DestinationName.TOPIC);
		setPubSubDomain(true);
	}
}
