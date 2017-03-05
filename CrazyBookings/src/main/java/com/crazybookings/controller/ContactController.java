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
    
	private Logger logger = Logger.getLogger(ContactController.class);
	
	@Autowired
    private MailService mailService;
	
    @RequestMapping("/layout")
    public String getMainPartialPage() {
        logger.info("This is an info log entry");
        logger.error("This is an error log entry");
        return "contact/layout";
    }
    
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public @ResponseBody void addUser(@RequestBody Email email) {
		mailService.sendMail(email.getDestiny(), email.getSubject(), email.getMessage());
    }
    
}

