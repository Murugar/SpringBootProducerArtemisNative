package com.iqmsoft;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@ComponentScan({"com.iqmsoft"})
@EnableScheduling
public class SpringBootArtemisApp {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootArtemisApp.class, args);
	}

	@Bean
	public ActiveMQQueue queue(){
		return new ActiveMQQueue("artemis-queue-test");
	}

}
