package com.crazybookings.service;

import java.util.Collection;
import java.util.HashMap;

import com.crazybookings.beans.Order;
import com.crazybookings.beans.Product;
import com.crazybookings.persistence.ProductPersist;

public interface ProductService {
	
	 public void addProduct(Product product);
	 
	 public ProductPersist getProduct();
	 
	 public Collection<ProductPersist> getAllProducts();
	 
	 public Collection<ProductPersist> getProductsByName(String name);
	 
  	 public HashMap<String, Order> addProductToCart (Product product);

}
