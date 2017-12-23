package com.easywork.mycrm.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
@Component
public class MySender {
	@Autowired
	@Qualifier("jmsQueueTemplate")
	JmsTemplate jmstpl;

	public void send(String dest,String msg) {
		jmstpl.send(dest,new MessageCreator() {

			@Override
			public Message createMessage(Session arg0) throws JMSException {
				TextMessage text = arg0.createTextMessage(msg);
				return text;
			}
		});
	}

}
