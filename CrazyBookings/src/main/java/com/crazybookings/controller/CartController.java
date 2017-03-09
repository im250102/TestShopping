package com.crazybookings.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crazybookings.beans.Order;
import com.crazybookings.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
    @Autowired
    private CartService cartService;
    
	@RequestMapping("/layout")
    public String getMainPartialPage() {
    	
		Logger.getLogger(getClass()).info("<CrazyBookings>Inside of Cart Controller<CrazyBookings>");
        
		return "cart/layout";
    }
	
	/*Retrieve list of orders to be shown in cart */
    @RequestMapping("/orderList.json")
    public @ResponseBody List<Order> getOrderList(HttpSession httpSession) {
    	@SuppressWarnings("unchecked")
		HashMap<String, Order> ordersMap = (HashMap<String, Order>) httpSession.getAttribute("orders"); 
        return cartService.getOrderList(ordersMap);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteOrderFromCart(@PathVariable("id") Long id, HttpSession httpSession) {
    	
		Logger.getLogger(getClass()).info("<CrazyBookings>Removing order from cart<CrazyBookings>");
    	
    	//Retrieve Map from session
		HashMap<String, Order> ordersMap = (HashMap<String, Order>) httpSession.getAttribute("orders"); 

    	//Remove order from Cart
		cartService.deleteOrderFromCart(id, ordersMap);
    	
		Logger.getLogger(getClass()).info("<CrazyBookings>Removed order from cart<CrazyBookings>");
		
		httpSession.setAttribute("orders", ordersMap);		
		

    }

}
