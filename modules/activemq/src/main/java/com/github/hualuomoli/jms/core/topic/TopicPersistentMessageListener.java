package com.github.hualuomoli.jms.core.topic;

public abstract class TopicPersistentMessageListener extends TopicMessageListener {

	@Override
	public void addConfig() {
		super.addConfig();
		// persistent
		setClientId(getClientID());
		setSubscriptionDurable(true);
	}

	@Override
	public String getTopicName() {
		return "JMS.PERSISTENT";
	}

	public String getClientID() {
		return this.getClass().getName();
	}

}
