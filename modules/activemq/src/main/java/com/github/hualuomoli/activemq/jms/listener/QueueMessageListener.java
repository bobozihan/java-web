package com.github.hualuomoli.activemq.jms.listener;

import com.github.hualuomoli.activemq.jms.DestinationName;

public abstract class QueueMessageListener extends AbstractMessageListener {

	public QueueMessageListener() {
		this(DestinationName.QUEUE);
	}

	public QueueMessageListener(String destinationName) {
		super(destinationName);
	}

}
