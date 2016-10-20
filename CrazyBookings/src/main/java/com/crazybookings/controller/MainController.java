package com.crazybookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;





import com.crazybookings.beans.User;
import com.crazybookings.service.RegisterService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
    private RegisterService registerService;
		
    @RequestMapping("/layout")
    public String getMainPartialPage() {
        return "main/layout";
    }
    
    
//	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public @ResponseBody void addUser(@RequestBody User user) {
//		System.out.println("Entra en Register");
//		System.out.println(user.getName());
//		
//    }
	

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody void addUser(@RequestBody User user) {
		registerService.addUser(user);
    }


}

