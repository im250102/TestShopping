package com.crazybookings.controller;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crazybookings.beans.Order;
import com.crazybookings.beans.Product;
import com.crazybookings.beans.Products;
import com.crazybookings.persistence.ProductPersist;
import com.crazybookings.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
	private Products products;
	
	@RequestMapping("/layout")
    public String getMainPartialPage() {
        return "products/layout";
    }

	@RequestMapping(value="/getAllProducts", method = RequestMethod.POST)
	public @ResponseBody String getAllProduct(){
		products = new Products();
		Collection<ProductPersist> list = productService.getAllProducts();
		if(list!=null)
			return products.prepareProductList(list).toString();
		return null;
	}
	
    /*Add product into cart, data in session*/
	@RequestMapping(value = "/addProductToCart", method = RequestMethod.POST)
    public @ResponseBody void addProductToCart( @RequestBody  Product product, HttpSession httpSession) {
		
		//Add product to the Orders map
		HashMap<String, Order> ordersMap = productService.addProductToCart(product);
		
		//Add orders map into session
		httpSession.setAttribute("orders", ordersMap);
		
    }
	
	@RequestMapping(value="/getProductByName/{searchWine}", method = RequestMethod.POST)
	public @ResponseBody String getProductByName(@PathVariable("searchWine") String searchWine){
		products = new Products();
		Collection<ProductPersist> list = productService.getProductsByName(searchWine);
		if(list!=null)
			return products.prepareProductList(list).toString();
		return null;
	}
}
