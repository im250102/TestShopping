package com.crazybookings.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crazybookings.beans.Order;
import com.crazybookings.beans.Product;
import com.crazybookings.dao.ProductDAO;
import com.crazybookings.persistence.ProductPersist;


@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductDAO productDAO;
    
	private HashMap<String, Order> ordersMap = new HashMap<String, Order>();
	private Long id = 0L;
	
    public void addProduct(Product product) {
    	productDAO.addProduct(product);
    }
    
    @Cacheable("products")
    public Collection<ProductPersist> getAllProducts() {
    	return productDAO.getAllProducts();
    }
    
	public Map<String, Order> addProductToCart(Product product) {
		Order order = new Order(product.getQuantity(), product.getName(), product.getPrice());
		order.setId(++id);
		
		if(!ordersMap.containsKey(order.getName()))
			ordersMap.put(order.getName(), order);
		
		return ordersMap;
	}

	public Collection<ProductPersist> getProductsByName(String name) {
		return productDAO.getProducsByName(name);
	}

}
