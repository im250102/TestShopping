package com.crazybookings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

		
    @RequestMapping("/layout")
    public String getMainPartialPage() {
        return "main/layout";
    }
    
}
