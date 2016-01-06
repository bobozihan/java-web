package com.github.hualuomoli.demo.jms.topic;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicMessageListener;

@Service(value = R.id.TopicReceiveListener)
public class TopicReceiveListener extends TopicMessageListener {

	public TopicReceiveListener() {
		super();
	}

}
