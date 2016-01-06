package com.github.hualuomoli.jms.core.topic;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Topic;

import com.github.hualuomoli.jms.R;
import com.github.hualuomoli.jms.constant.DestinationName;
import com.github.hualuomoli.jms.core.MessageListener;
import com.github.hualuomoli.jms.pool.PoolConnectionService;

public abstract class TopicMessageListener extends MessageListener implements Topic {

	@Resource(name = R.id.PoolConnectionService)
	private PoolConnectionService poolConnectionService;

	public TopicMessageListener() {
		super();
	}

	@Override
	public void addConfig() {
		setPubSubDomain(true);
	}

	@Override
	public String getDestinationName() {
		return getTopicName();
	}

	@Override
	public String getTopicName() {
		return DestinationName.TOPIC;
	}

	@Override
	public ConnectionFactory getConnectionFactory() {
		return poolConnectionService.getJmsSendPooledConnectionFactory();
	}

}
