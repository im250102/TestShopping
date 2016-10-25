package com.crazybookings.service;

import java.util.Collection;

import com.crazybookings.persistence.ProductPersist;

public interface ProductService {
	
	 //public void addProduct(Product product);
	 
	 public ProductPersist getProduct();
	 
	 public Collection<ProductPersist> getAllProducts();
}
