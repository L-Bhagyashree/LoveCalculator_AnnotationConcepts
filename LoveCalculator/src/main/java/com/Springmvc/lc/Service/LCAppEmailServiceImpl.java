package com.Springmvc.lc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String userName,String userEmail, String result) {
		// TODO Auto-generated method stub
		
		SimpleMailMessage newEmail=new SimpleMailMessage();
		newEmail.setTo(userEmail);
		newEmail.setSubject("Love Calculator Application Result");
		newEmail.setText("Hi"+userName+" The result predicted by the LC App is"+ " result");
		javaMailSender.send(newEmail);

	}



}
