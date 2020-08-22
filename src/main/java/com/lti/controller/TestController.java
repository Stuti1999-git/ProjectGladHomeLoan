package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
		
	@RequestMapping(path="/hello",produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayHello() {
		return "Hello from Spring Boot Test";
	}
}