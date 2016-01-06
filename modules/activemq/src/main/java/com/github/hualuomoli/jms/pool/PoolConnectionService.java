package com.github.hualuomoli.jms.pool;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.R;

@Service(value = R.id.PoolConnectionService)
public class PoolConnectionService {

	@Resource(name = "jmsSendPooledConnectionFactory")
	private ConnectionFactory jmsSendPooledConnectionFactory;

	@Resource(name = "jmsReceivePooledConnectionFactory")
	private ConnectionFactory jmsReceivePooledConnectionFactory;

	public ConnectionFactory getJmsReceivePooledConnectionFactory() {
		return jmsReceivePooledConnectionFactory;
	}

	public ConnectionFactory getJmsSendPooledConnectionFactory() {
		return jmsSendPooledConnectionFactory;
	}

}
