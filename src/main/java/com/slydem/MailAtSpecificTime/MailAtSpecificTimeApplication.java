package com.slydem.MailAtSpecificTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.slydem.MailAtSpecificTime.Model.User;
import com.slydem.MailAtSpecificTime.Service.Registration;

@SpringBootApplication
@EnableScheduling
public class MailAtSpecificTimeApplication {

	int count=1;
	
	@Autowired
	private Registration registration;
	
	public static void main(String[] args) {
		SpringApplication.run(MailAtSpecificTimeApplication.class, args);
	}
	
	@Scheduled(cron = "0 0/1 * 1/1 *  *")
	public void signUpConfirm(){
		
		User user = new User();
		user.setFirstName("abc");
		user.setLastName("def");
		user.setEmailAddress("abc143@gmail.com");
		
		try {
			registration.sendNotification(user);
			System.out.println("Message Sent Successfully");
			System.out.println(count++);
		}catch(MailException e) {
			System.out.println(e.getMessage());
			System.out.println("Application Failed!!");
		}
	}

}
