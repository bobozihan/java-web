package com.github.hualuomoli.jms.core.queue;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import com.github.hualuomoli.jms.R;
import com.github.hualuomoli.jms.constant.DestinationName;
import com.github.hualuomoli.jms.core.MessageListener;
import com.github.hualuomoli.jms.pool.PoolConnectionService;

public abstract class QueueMessageListener extends MessageListener implements Queue {

	@Resource(name = R.id.PoolConnectionService)
	private PoolConnectionService poolConnectionService;

	public QueueMessageListener() {
		super();
	}

	@Override
	public void addConfig() {
	}

	@Override
	public String getDestinationName() {
		return getQueueName();
	}

	@Override
	public String getQueueName() {
		return DestinationName.QUEUE;
	}

	@Override
	public ConnectionFactory getConnectionFactory() {
		return poolConnectionService.getJmsSendPooledConnectionFactory();
	}

}
