package com.github.hualuomoli.demo.jms.persistent;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicPersistentMessageListener;

@Service(value = R.id.PersistentTopicReceiveListener)
public class PersistentTopicReceiveListener extends TopicPersistentMessageListener {

	public PersistentTopicReceiveListener() {
		super();
	}

}
