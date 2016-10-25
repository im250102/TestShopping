package com.crazybookings.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
