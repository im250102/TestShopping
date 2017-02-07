package com.crazybookings.mail.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.crazybookings.mail.service.MailService;

public class MailServiceTest {
	
	ApplicationContext context = null;
	
	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext("file:src\\main\\resources\\spring\\beans.xml");
	}
	
	@Test
	public void sendMailTest(){
		
		System.out.println("Probando a enviar un correo electronico ");

		//Get the mailer instance
        MailService mailer = (MailService) context.getBean("mailService");
 
        //Send a composed mail
        mailer.sendMail("ignacio.martin1083@gmail.com", "Test Subject", "Testing body");
		
        System.out.println("Correo enviado correctamente ");
	}
	
}
