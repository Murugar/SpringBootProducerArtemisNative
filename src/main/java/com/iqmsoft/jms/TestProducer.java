package com.iqmsoft.jms;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {
	
	@Value("${jms.queue.destination}")
	String destinationQueue;
	
	@Autowired
	private JmsTemplate jms;
	
	
	@Scheduled(fixedRate=1000)
	public void send() throws JMSException {
		System.out.println("sending message to " + this.destinationQueue);
		this.jms.convertAndSend(this.destinationQueue, "message");
	}
}
