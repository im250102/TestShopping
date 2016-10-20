package com.crazybookings.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crazybookings.beans.User;
import com.crazybookings.persistence.Usr;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{
	
    @PersistenceContext
    private EntityManager entityManager;
	
    private static List<User> userList = new ArrayList<User>();

    @Transactional
    public void addUser(User user) {
        Usr userpersist = new Usr();
        userpersist.setName(user.getName());        
        try{
        	entityManager.persist(userpersist);
        }catch(Exception e){
        	System.out.println("error " + e);
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
    	userList = entityManager.createQuery("select u from Usr u").getResultList();
    	return userList;
    }
    


}
