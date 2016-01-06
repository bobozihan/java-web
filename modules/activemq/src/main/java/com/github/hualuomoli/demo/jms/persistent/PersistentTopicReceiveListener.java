package com.github.hualuomoli.demo.jms.persistent;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicMessageListener;

@Service(value = R.id.PersistentTopicReceiveListener)
public class PersistentTopicReceiveListener extends TopicMessageListener {

	public PersistentTopicReceiveListener() {
		super();
	}

	@Override
	public String getTopicName() {
		return "JMS.PERSISTENT";
	}

}
