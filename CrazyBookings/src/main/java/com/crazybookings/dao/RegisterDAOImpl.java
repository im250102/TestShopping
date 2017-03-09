package com.crazybookings.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crazybookings.persistence.Usr;

@Component
public class RegisterDAOImpl implements RegisterDAO {
	
  @PersistenceContext
  private EntityManager entityManager;
	
  private List<Usr> userList = new ArrayList<Usr>();

  @Transactional
  public void addUser(Usr usr) {      
	  try{      
		  entityManager.persist(usr);
	  } catch (Exception e) {
	      Logger.getLogger(getClass()).error("Error inserting user", e);
	  }
  }
  
  @SuppressWarnings("unchecked")
  public List<Usr> getAllUsers() {	  
	  	try {
	  		userList = entityManager.createQuery("select u from Usr u").getResultList();
	  	} catch (Exception e) {
	    	Logger.getLogger(getClass()).error("Error retrieving users ", e);
	    }	  	
	  	return userList;
  }

  @Transactional
  public void deleteUser(String name) {
	  	try {
	        Query query = entityManager.createQuery("DELETE FROM Usr U WHERE U.name = :p");
	        query.setParameter("p", name);
	        query.executeUpdate();
	    } catch (Exception e) {
	    	Logger.getLogger(getClass()).error("Error deleting user" ,e );
		}
  }

}
