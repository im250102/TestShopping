package com.crazybookings.service;

import java.util.Collection;
import java.util.Map;

import com.crazybookings.beans.Order;
import com.crazybookings.beans.Product;
import com.crazybookings.persistence.ProductPersist;

public interface ProductService {
	
	 public void addProduct(Product product);
	 
	 public Collection<ProductPersist> getAllProducts();
	 
	 public Collection<ProductPersist> getProductsByName(String name);
	 
  	 public Map<String, Order> addProductToCart (Product product);

}
