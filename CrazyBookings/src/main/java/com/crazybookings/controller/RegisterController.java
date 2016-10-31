package com.crazybookings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crazybookings.persistence.Usr;
import com.crazybookings.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
    private RegisterService registerService;
		
    @RequestMapping("/layout")
    public String getMainPartialPage() {
        return "register/layout";
    }
    
    
    @RequestMapping("/userlist.json")
    public @ResponseBody List<Usr> getUserList() {
        return registerService.getAllUsers();
    }
	

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody void addUser(@RequestBody Usr user) {
		registerService.addUser(user);
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteOrder(@PathVariable("name") String name) {
    	registerService.deleteUser(name);
    }

}

