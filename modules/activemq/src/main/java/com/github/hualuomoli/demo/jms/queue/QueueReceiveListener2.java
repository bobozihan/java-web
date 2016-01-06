package com.github.hualuomoli.demo.jms.queue;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.queue.QueueMessageListener;

@Service(value = R.id.QueueReceiveListener2)
public class QueueReceiveListener2 extends QueueMessageListener {

	public QueueReceiveListener2() {
		super();
	}

}
