package com.crazybookings.dao;

import java.util.List;

import com.crazybookings.persistence.Usr;

public interface RegisterDAO {



		  public void addUser(Usr usr);
		  
		  public List<Usr> getAllUsers();

}
