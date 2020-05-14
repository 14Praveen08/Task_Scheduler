package com.slydem.MailAtSpecificTime.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.slydem.MailAtSpecificTime.Model.User;

@Service
public class Registration {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public void NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(User user) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("actionking148@gmail.com");
		mail.setSubject("Sample Test Message");
		mail.setText("If you have received this, mailsender is working");
		
		javaMailSender.send(mail);
	}

}
