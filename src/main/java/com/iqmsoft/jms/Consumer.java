package com.iqmsoft.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Consumer { 


	@JmsListener(destination = "${jms.queue.destination}")
	public void receive(Message message){
		if(message.getPayload() instanceof String){
			System.out.println("Received Message: " + message.getPayload().toString());
		}else if (message.getPayload() instanceof Person){
			System.out.println("Received Person: " + message.getPayload().toString());
		}else {
			System.err.println("Message Type Unkown !");
		}
	}



}
