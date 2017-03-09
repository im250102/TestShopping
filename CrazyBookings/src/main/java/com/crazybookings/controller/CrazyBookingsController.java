package com.crazybookings.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
@RequestMapping("/")
public class CrazyBookingsController {
 
    @RequestMapping
    public String getIndexPage() {

    	Logger.getLogger(getClass()).info("<CrazyBookings>Main page loaded<CrazyBookings>");
    	
        return "index";
    }
}