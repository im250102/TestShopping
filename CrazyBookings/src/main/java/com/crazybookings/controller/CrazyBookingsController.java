package com.crazybookings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
@RequestMapping("/")
public class CrazyBookingsController {
 
    @RequestMapping
    public String getIndexPage() {
        return "index";
    }
}