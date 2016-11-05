package com.crazybookings.dao;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crazybookings.persistence.Usr;

public class RegisterDAOImplTest {

	private static EntityManager entityManager;
	
	private static EntityManagerFactory entityManagerFactory;
	
	private RegisterDAOImpl registerDAO = null;
	
	private Usr usr = null;
	
	  
	@Before
	public void setUp() throws Exception {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("tutorialPU");
		entityManager = entityManagerFactory.createEntityManager();

		Usr usr = new Usr();
		usr.setName("Loco");
		usr.setEmail("loco@gmail.com");
	}

	@Test
	public void test() {
	   try{
		   registerDAO.addUser(usr);
	   }catch(Exception e){
		   fail("Error");
	   }
		
	}
	
	@After
	public void after() throws Exception {

		  entityManager.getTransaction().commit();
	}

}
