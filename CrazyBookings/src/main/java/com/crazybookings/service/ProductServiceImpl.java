package com.crazybookings.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crazybookings.dao.ProductDAO;
import com.crazybookings.persistence.ProductPersist;


@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductDAO productDAO;
    
//    public void addProduct(Product product) {
//    	productDAO.addProduct(product);
//    }
    
    
    public ProductPersist getProduct(){
    	return productDAO.getProduct();
    }
    
    @Cacheable("products")
    @SuppressWarnings("unchecked")
	public Collection<ProductPersist> getAllProducts() {
    	return productDAO.getAllProducts();
    }

}
