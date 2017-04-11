package com.crazybookings.controller;

import java.util.List;

import org.apache.log4j.Logger;
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

    	Logger.getLogger(getClass()).info("<CrazyBookings>Inside of Register Controller<CrazyBookings>");

        return "register/layout";
    }
    
    
    @RequestMapping("/userlist.json")
    public @ResponseBody List<Usr> getUserList() {
    	
    	Logger.getLogger(getClass()).info("<CrazyBookings>Retrieve user list <CrazyBookings>");
    	
        return registerService.getAllUsers();
    }
	

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody void addUser(@RequestBody Usr user) {
		
    	Logger.getLogger(getClass()).info("<CrazyBookings>Add user "+ user.getName()  + " <CrazyBookings>");
		
		registerService.addUser(user);
    }
	
    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteUser(@PathVariable("name") String name) {

    	Logger.getLogger(getClass()).info("<CrazyBookings>Delete user "+ name  + " <CrazyBookings>");

    	registerService.deleteUser(name);
    }


}

