package com.github.hualuomoli.demo.mq_spring.type;

import java.util.Enumeration;

import javax.jms.BytesMessage;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.activemq.jms.listener.QueueMessageListener;

@Service(value = R.id.MessageTypeReciever)
public class MessageTypeReciever extends QueueMessageListener {

	public MessageTypeReciever() {
		super("queue-type");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message message) {

		try {
			// 如果是文本消息
			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				System.out.println("receive text message:" + tm.getText());
			}

			// 如果是Map消息
			if (message instanceof MapMessage) {
				MapMessage mm = (MapMessage) message;
				System.out.println("receive map message:");
				Enumeration<String> names = mm.getMapNames();
				while (names.hasMoreElements()) {
					String name = names.nextElement();
					System.out.println("\t" + name + " = " + mm.getString(name));
				}
			}

			// 如果是Object消息
			if (message instanceof ObjectMessage) {
				ObjectMessage om = (ObjectMessage) message;
				Demo demo = (Demo) om.getObject();

				System.out.println("receive object message:" + demo);
			}

			// 如果是bytes消息
			if (message instanceof BytesMessage) {
				BytesMessage bm = (BytesMessage) message;

				byte[] b = new byte[1024];
				int len = -1;
				while ((len = bm.readBytes(b)) != -1) {
					System.out.println("receive byte message:" + new String(b, 0, len));
				}
			}

			// 如果是Stream消息
			if (message instanceof StreamMessage) {
				StreamMessage sm = (StreamMessage) message;
				System.out.println("receive stream message:");
				System.out.println("\t" + sm.readString());
				System.out.println("\t" + sm.readInt());
			}
		} catch (Exception e) {
		}
	}

}
