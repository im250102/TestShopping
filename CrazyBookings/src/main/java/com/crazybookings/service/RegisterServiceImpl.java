package com.crazybookings.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crazybookings.persistence.Usr;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{
	
    @PersistenceContext
    private EntityManager entityManager;
	
    private static List<Usr> userList = new ArrayList<Usr>();

    @Transactional
    public void addUser(Usr usr) {
        try{
        	entityManager.persist(usr);
        }catch(Exception e){
        	System.out.println("error " + e);
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<Usr> getAllUsers() {
    	userList = entityManager.createQuery("select u from Usr u").getResultList();
    	return userList;
    }

}
