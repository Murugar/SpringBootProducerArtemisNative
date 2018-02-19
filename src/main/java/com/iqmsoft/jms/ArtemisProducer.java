package com.iqmsoft.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Queue;

@Component
public class ArtemisProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	public void send(String msg){
		jmsTemplate.convertAndSend(queue, msg);
	}
	public void send(Person p){
		jmsTemplate.convertAndSend(queue, p);
	}


}