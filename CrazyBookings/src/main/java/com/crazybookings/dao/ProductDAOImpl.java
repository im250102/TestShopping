package com.crazybookings.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    	ProductPersist productPersist = new ProductPersist();
    	productPersist.setName(product.getName());
    	productPersist.setPrice(product.getPrice());
    	productPersist.setImage(product.getImage());
    	entityManager.persist(productPersist);
    }
    
    public ProductPersist getProduct(){
    	ProductPersist product = entityManager.find(ProductPersist.class, new Long(11));
    	return product;
    }
    
    @SuppressWarnings("unchecked")
	public Collection<ProductPersist> getAllProducts() {
        Query query = entityManager.createQuery("SELECT e FROM ProductPersist e");
        Collection<ProductPersist> products = query.getResultList();
        return products;
    }

	public Collection<ProductPersist> getProducsByName(String name) {
		Query query = entityManager.createQuery("SELECT e FROM ProductPersist e where e.name=:arg1");
		query.setParameter("arg1", name);
        Collection<ProductPersist> products = query.getResultList();
        return products;
	}
}
