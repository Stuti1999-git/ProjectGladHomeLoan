package com.lti.externalAPIs;

import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.Dto.ForgotPasswordDto;
import com.lti.status.EmailStatus;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;

@RestController
public class mailAPI {
	@Autowired
	private MailSender mailSender;

	@Autowired
	private HttpSession session;
	SimpleMailMessage message = new SimpleMailMessage();

	public String registerMail(String mailTo, String mailText) {

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

	public void sendOtpEmail(MailSender mailSender, int otp, String userEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("Reena.Kumari@lntinfotech.com");
		message.setTo(userEmail);
		message.setSubject("Verify Email");
		message.setText("Dear " + "\n\n" + "You have successfully verified your registered email." + "\n"
				+ "This is your otp " + otp + ". Use it to reset your password." + "\n\n" + "Have a good day." + "\n"
				+ "Bank of LTI");
		mailSender.send(message);

	}

	public void resetPasswordEmail(MailSender mailSender, String userEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("Reena.Kumari@lntinfotech.com");
		message.setTo(userEmail);
		message.setSubject(" Password updated");
		message.setText("Dear User!" + "\n\n" + "Your password has been successfully updated." + "\n\n"
				+ "Have a good day." + "\n" + "Bank of LTI");
		mailSender.send(message);
	}

}
