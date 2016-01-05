package com.github.hualuomoli.demo.mq_spring.queue;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.github.hualuomoli.activemq.jms.listener.QueueMessageListener;

@Service(value = R.id.ConsumerService2)
public class ConsumerService2 extends QueueMessageListener {

	//当收到消息时，自动调用该方法。
	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("===============收到了文本消息：" + tm.getText());
			Thread.sleep(1000); // 休眠一秒,模拟业务处理
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
