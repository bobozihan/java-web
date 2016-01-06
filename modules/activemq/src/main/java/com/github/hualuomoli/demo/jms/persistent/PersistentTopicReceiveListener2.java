package com.github.hualuomoli.demo.jms.persistent;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicPersistentMessageListener;

@Service(value = R.id.PersistentTopicReceiveListener2)
public class PersistentTopicReceiveListener2 extends TopicPersistentMessageListener {

	public PersistentTopicReceiveListener2() {
		super();
	}

}
