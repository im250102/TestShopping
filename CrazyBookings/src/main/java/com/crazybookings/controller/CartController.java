package com.crazybookings.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

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
    	
    	//Recuperar Map de session
		HashMap<String, Order> ordersMap = (HashMap<String, Order>) httpSession.getAttribute("orders"); 

    	//De esa map, eliminar esa ordern
		cartService.deleteOrderFromCart(id, ordersMap);
    	
		httpSession.setAttribute("orders", ordersMap);
		
		//Set en session de nuevo
		
//    	HashMap<String, Order> ordersMap = cartService.deleteOrderFromCart(id);
//		httpSession.setAttribute("orders", ordersMap);

    	//return cartService.deleteOrderFromCart(id);
    }

}
