package com.slydem.Mail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slydem.Mail.Model.User;
import com.slydem.Mail.Service.RegistrationService;

@RestController
@RequestMapping("/core")
public class RegistrationController {
	
	
	@Autowired
	private RegistrationService registrationService;
	
	
	@RequestMapping("/confirm")
	public void signUpConfirm(){
		
		User user = new User();
		user.setFirstName("abc");
		user.setLastName("def");
		user.setEmailAddress("abc143@gmail.com");
		
		try {
			registrationService.sendNotification(user);
			System.out.println("Message Sent Successfully");
		}catch(MailException e) {
			System.out.println(e.getMessage());
			System.out.println("Application Failed!!");
		}
	}

}
