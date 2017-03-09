package com.crazybookings.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crazybookings.beans.Email;
import com.crazybookings.mail.service.MailService;

 
@Controller
@RequestMapping("/contact")
public class ContactController {
    
	@Autowired
    private MailService mailService;
	
    @RequestMapping("/layout")
    public String getMainPartialPage() {
    	Logger.getLogger(getClass()).info("<CrazyBookings>Inside of Contact Controller<CrazyBookings>");
        return "contact/layout";
    }
    
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public @ResponseBody void addUser(@RequestBody Email email) {
    	Logger.getLogger(getClass()).info("<CrazyBookings>Sending email to" + email.getDestiny() +"<CrazyBookings>");
		
    	mailService.sendMail(email.getDestiny(), email.getSubject(), email.getMessage());

		Logger.getLogger(getClass()).info("<CrazyBookings>Email sent<CrazyBookings>");

	}
    
}

