package com.crazybookings.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crazybookings.beans.Product;
import com.crazybookings.persistence.ProductPersist;

@Component
public class ProductDAOImpl implements ProductDAO{
	
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void addProduct(Product product) {    	
        try {
        	ProductPersist productPersist = new ProductPersist();
        	productPersist.setName(product.getName());
        	productPersist.setPrice(product.getPrice());
        	productPersist.setImage(product.getImage());
        	entityManager.persist(productPersist);
        } catch (Exception e) {
        	Logger.getLogger(getClass()).error("Error inserting product ", e);
        }
    }
    
    @SuppressWarnings("unchecked")
	public Collection<ProductPersist> getAllProducts() {
    	Collection<ProductPersist> products = null;
    	try {
            Query query = entityManager.createQuery("SELECT e FROM ProductPersist e");
            products = query.getResultList();            
    	} catch (Exception e) {
        	Logger.getLogger(getClass()).error("Error retrieving products ", e);
   		}
    	return products;
    }

	@SuppressWarnings("unchecked")
	public Collection<ProductPersist> getProducsByName(String name) {
		Collection<ProductPersist> products = null;
    	try {
    		Query query = entityManager.createQuery("SELECT e FROM ProductPersist e where e.name=:arg1");
    		query.setParameter("arg1", name);
            products = query.getResultList();
            return products;
    	} catch (Exception e) {
        	Logger.getLogger(getClass()).error("Error finding product by name", e);
   		}
		return products;

	}
}
