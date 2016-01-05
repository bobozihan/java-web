package com.github.hualuomoli.activemq.jms.listener;

import com.github.hualuomoli.activemq.jms.DestinationName;

public abstract class TopicMessageListener extends AbstractMessageListener {

	public TopicMessageListener() {
		super(DestinationName.TOPIC);
		setPubSubDomain(true);
	}

}
