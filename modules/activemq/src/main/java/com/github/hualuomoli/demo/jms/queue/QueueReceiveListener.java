package com.github.hualuomoli.demo.jms.queue;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.queue.QueueMessageListener;

@Service(value = R.id.QueueReceiveListener)
public class QueueReceiveListener extends QueueMessageListener {

	public QueueReceiveListener() {
		super();
	}

}
