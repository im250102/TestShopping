package com.crazybookings.dao;

import java.util.ArrayList;
import java.util.List;

import com.crazybookings.persistence.Usr;

public class RegisterDAOMock {

	private List<Usr> userList = null;
	  
	  public List<Usr> getAllUsers() {	  
		  userList = new ArrayList<Usr>();
		  
		  Usr user = new Usr();		 
		  user.setId(new Long(1));
		  user.setName("Nacho");
		  user.setEmail("ignacio.martin@gmail.com");
		  userList.add(user);
		  
		  Usr user2 = new Usr();
		  user2.setId(new Long(2));
		  user2.setName("Yolanda");
		  user2.setEmail("yolanda.martin@gmail.com");
		  userList.add(user2);		  
		  
		  return userList;
	  }

	
}
