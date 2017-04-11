package com.crazybookings.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.crazybookings.dao.RegisterDAO;
import com.crazybookings.dao.RegisterDAOMock;
import com.crazybookings.persistence.Usr;

public class RegisterServiceImplTest {
		
    private RegisterDAOMock registerDAOMock;
	
	@Before
	public void initializeRegisterDAOMock(){
		registerDAOMock = new RegisterDAOMock();
	}
	
	@Test
	public void getAllUsers() {
	    System.out.println("Test mock Register - get All users ...");

		Assert.assertEquals(2, registerDAOMock.getAllUsers().size());
	}

}
