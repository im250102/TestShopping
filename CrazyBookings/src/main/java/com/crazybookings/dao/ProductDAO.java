package com.crazybookings.dao;

import java.util.Collection;

import com.crazybookings.beans.Product;
import com.crazybookings.persistence.ProductPersist;

public interface ProductDAO {
	
	 public void addProduct(Product product);
	 
	 public ProductPersist getProduct();
	 
	 public Collection<ProductPersist> getAllProducts();
	 
}
