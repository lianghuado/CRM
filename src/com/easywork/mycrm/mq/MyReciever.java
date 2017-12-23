package com.easywork.mycrm.mq;

import javax.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
@Component
public class MyReciever {
	@Autowired
	@Qualifier("jmsQueueTemplate")
	JmsTemplate jmstpl;
	
	public String rev(String dest){
		Message receive = jmstpl.receive(dest);
		return dest;
	}
}
