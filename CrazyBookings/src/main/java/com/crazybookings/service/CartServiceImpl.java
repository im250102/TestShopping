package com.crazybookings.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.crazybookings.beans.Order;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	private ArrayList<Order> orderList = new ArrayList<Order>();	
	
	public List<Order> getOrderList(Map<String, Order> ordersMap){
		if(ordersMap!=null && !ordersMap.isEmpty())
			orderList = new ArrayList<Order>(ordersMap.values());
		else 
			orderList.clear();
		return orderList;
	}

	public Map<String, Order>  deleteOrderFromCart(Long id, Map<String, Order> ordersMap) {
		Order orderFound = findOrderById(id, ordersMap);
		if(orderFound !=null){
			ordersMap.remove(orderFound.getName());
		}
		return ordersMap;
	}
	
	public Order findOrderById(Long id, Map<String, Order> ordersMap){
		Order orderFound = null;
		for(Order order : ordersMap.values()){
			if(order.getId() == id)
				orderFound = order;
		}
		return orderFound;
	}

}
