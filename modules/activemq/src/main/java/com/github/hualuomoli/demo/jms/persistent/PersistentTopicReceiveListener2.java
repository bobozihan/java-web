package com.github.hualuomoli.demo.jms.persistent;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.jms.core.topic.TopicMessageListener;

@Service(value = R.id.PersistentTopicReceiveListener2)
public class PersistentTopicReceiveListener2 extends TopicMessageListener {

	public PersistentTopicReceiveListener2() {
		super();
	}

	@Override
	public String getTopicName() {
		return "JMS.PERSISTENT";
	}

}
