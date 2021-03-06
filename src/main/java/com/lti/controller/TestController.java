package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@Autowired
	private MailSender mailSender;
	
	@RequestMapping(path="/hello",produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayHello() {
		return "Hello from Spring Boot Test";
	}
	
	@RequestMapping("/helloMail")
	public String hello() {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("abhishek.sethi@lntinfotech.com");
		message.setTo("abhisethi.53@gmail.com");
		message.setSubject("Test Mail");
		message.setText("Hi Hi Hi");
		mailSender.send(message);
		
		return "Welcome to Spring REST";
	}
}