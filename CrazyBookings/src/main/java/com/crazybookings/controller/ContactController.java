package com.crazybookings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
@RequestMapping("/contact")
public class ContactController {
 
    @RequestMapping("/layout")
    public String getMainPartialPage() {
        return "contact/layout";
    }
    
}