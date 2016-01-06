package com.github.hualuomoli.demo.jms.queue;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.queue.QueueJmsTemplate;

@Service(value = R.id.QueueSendService)
public class QueueSendService extends QueueJmsTemplate {

	public QueueSendService() {
		super();
	}

}
