package com.lti.externalAPIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mailAPI {
	@Autowired
	private MailSender mailSender;
	
	
	public String registerMail(String mailTo, String mailText) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("abhishek.sethi@lntinfotech.com");
		message.setTo("abhisethi.53@gmail.com");
		message.setSubject("Thank You for registering with Bank Of LTI");
		message.setText("Hello from JAVA");
		System.out.println(mailTo);
		System.out.println(mailText);
		System.out.println("Mail Successful");
		mailSender.send(message);
		return "Successfull";
	}
}
