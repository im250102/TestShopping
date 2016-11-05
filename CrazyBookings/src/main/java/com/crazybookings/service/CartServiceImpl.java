package com.crazybookings.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crazybookings.beans.Order;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	private ArrayList<Order> orderList = new ArrayList<Order>();	
//	private HashMap<String, Order> ordersMap = new HashMap<String, Order>();
	private static Long id = 0L;
	
	public List<Order> getOrderList(HashMap<String, Order> ordersMap){
		if(ordersMap!=null && !ordersMap.isEmpty())
			orderList = new ArrayList<Order>(ordersMap.values());
		else 
			orderList.clear();
		return orderList;
	}

	public HashMap<String, Order>  deleteOrderFromCart(Long id, HashMap<String, Order> ordersMap) {
		Order orderFound = findOrderById(id, ordersMap);
		if(orderFound !=null){
			ordersMap.remove(orderFound.getName());
			id --;
		}
		return ordersMap;
	}
	
	public Order findOrderById(Long id, HashMap<String, Order> ordersMap){
		Order orderFound = null;
		for(Order order : ordersMap.values()){
			if(order.getId() == id)
				orderFound = order;
		}
		return orderFound;
	}




}
