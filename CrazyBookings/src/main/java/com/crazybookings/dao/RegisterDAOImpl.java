package com.crazybookings.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crazybookings.persistence.Usr;

@Component
public class RegisterDAOImpl implements RegisterDAO {
	
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

  @Transactional
  public void deleteUser(String name) {
      Query query = entityManager.createQuery("DELETE FROM Usr U WHERE U.name = :p");
      query.setParameter("p", name);
      int deleted = query.executeUpdate();
  }

}
