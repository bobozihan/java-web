package com.github.hualuomoli.demo.jms.topic;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicMessageListener;

@Service(value = R.id.TopicReceiveListener2)
public class TopicReceiveListener2 extends TopicMessageListener {

	public TopicReceiveListener2() {
		super();
	}

}
