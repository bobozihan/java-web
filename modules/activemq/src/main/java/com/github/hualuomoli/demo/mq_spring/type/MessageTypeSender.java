package com.github.hualuomoli.demo.mq_spring.type;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.StreamMessage;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.activemq.jms.core.QueueJmsTemplate;

@Service(value = R.id.MessageTypeSender)
public class MessageTypeSender extends QueueJmsTemplate {

	public MessageTypeSender() {
		super("queue-type");
	}

	public void sendTextMessage() {
		this.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("文本类型的消息");
			}
		});
	}

	public void sendMapMessage() {
		this.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString("name", "小西山");
				message.setBoolean("ok", false);
				return message;
			}

		});

	}

	public void sendObjectMessage() {
		this.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(new Demo());
			}

		});
	}

	public void sendBytesMessage() {
		this.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				BytesMessage message = session.createBytesMessage();
				message.writeBytes("BytesMessage 字节消息".getBytes());
				return message;
			}
		});
	}

	public void sendStreamMessage() {
		this.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				String str = "StreamMessage 流消息";
				StreamMessage message = session.createStreamMessage();
				message.writeString(str);
				message.writeInt(521);
				return message;
			}
		});
	}

}
