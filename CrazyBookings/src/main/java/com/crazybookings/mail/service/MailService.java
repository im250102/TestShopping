package com.crazybookings.mail.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
 
@Service("mailService")
public class MailService 
{
    @Autowired
    private MailSender mailSender;
     
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to, String subject, String body) 
    {	
        try {
    	
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("test");
            message.setText(body);
            mailSender.send(message);
    		
    	} catch (MailException e) {
        	Logger.getLogger(getClass()).error("Error sending email " ,e);
    	}
    }
}