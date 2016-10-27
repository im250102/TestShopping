package com.crazybookings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crazybookings.dao.RegisterDAO;
import com.crazybookings.persistence.Usr;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
    private RegisterDAO registerDAO;
	
	public List<Usr> getAllUsers() {
		return registerDAO.getAllUsers();
	}

	public void addUser(Usr usr) {
		registerDAO.addUser(usr);
	}

}
