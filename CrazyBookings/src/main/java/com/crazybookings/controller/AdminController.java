package com.crazybookings.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.crazybookings.beans.Product;
import com.crazybookings.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    private ProductService productService;
	
    @RequestMapping("/layout")
    public String getMainPartialPage() {
    	
    	Logger.getLogger(getClass()).info("<CrazyBookings>Inside of Admin Controller<CrazyBookings>");
        
    	return "admin/layout";
    }
    
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file, @RequestParam("product") String product, @RequestParam("price") int price) {
		  String name=  null;
	        if (!file.isEmpty()) {
	            try {
	            	//Set product
	            	byte[] bytes = file.getBytes();
	            	Product productBO = new Product();
	            	productBO.setName(product);
	            	productBO.setPrice(price);
	            	productBO.setImage(bytes);
	            	productService.addProduct(productBO);
	            	return "You successfully uploaded file=" + name;
	            } catch (Exception e) {
	            	Logger.getLogger(getClass()).error("Failed to upload file " +e);
	            	return "You failed to upload " + name + " => " + e.getMessage();
	            }
	        } else {
            	Logger.getLogger(getClass()).info("Failed to upload " + name + " because the file was empty ");
	        	return "You failed to upload " + name+ " because the file was empty.";
	        }
	}
	
}
