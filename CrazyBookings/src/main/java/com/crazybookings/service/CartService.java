package com.crazybookings.service;

import java.util.List;
import java.util.Map;

import com.crazybookings.beans.Order;

public interface CartService {	
	
	public List<Order> getOrderList(Map<String, Order> ordersMap);
	
	public Map<String, Order>  deleteOrderFromCart (Long id, Map<String, Order> ordersMap);

}
