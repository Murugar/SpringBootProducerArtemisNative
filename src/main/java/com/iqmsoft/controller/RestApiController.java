package com.iqmsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iqmsoft.jms.ArtemisProducer;
import com.iqmsoft.jms.Person;

import java.lang.invoke.MethodType;

@RestController
public class RestApiController {
	
	@Autowired
	ArtemisProducer producer;
	
	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		producer.send(msg);
		return "Done";
	}
	@RequestMapping(value="/produce",method = RequestMethod.POST)
	public String produce(@RequestBody  Person p){
		producer.send(p);
		return "Send Person Done" + p.toString();
	}
}