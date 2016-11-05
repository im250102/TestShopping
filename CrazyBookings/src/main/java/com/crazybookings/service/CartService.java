package com.crazybookings.service;

import java.util.HashMap;
import java.util.List;

import com.crazybookings.beans.Order;

public interface CartService {
	
	
	public List<Order> getOrderList(HashMap<String, Order> ordersMap);
	
	public HashMap<String, Order>  deleteOrderFromCart (Long id, HashMap<String, Order> ordersMap);

}
