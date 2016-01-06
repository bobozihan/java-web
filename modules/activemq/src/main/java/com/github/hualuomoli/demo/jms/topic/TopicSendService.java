package com.github.hualuomoli.demo.jms.topic;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicJmsTemplate;

@Service(value = R.id.TopicSendService)
public class TopicSendService extends TopicJmsTemplate {

	public TopicSendService() {
		super();
	}

}
