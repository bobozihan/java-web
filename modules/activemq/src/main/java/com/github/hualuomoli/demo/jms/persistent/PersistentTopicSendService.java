package com.github.hualuomoli.demo.jms.persistent;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicJmsTemplate;

@Service(value = R.id.PersistentTopicSendService)
public class PersistentTopicSendService extends TopicJmsTemplate {

	public PersistentTopicSendService() {
		super();
	}

	@Override
	public String getTopicName() {
		return "JMS.PERSISTENT";
	}

}
