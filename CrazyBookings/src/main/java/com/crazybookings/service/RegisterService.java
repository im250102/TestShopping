package com.crazybookings.service;

import java.util.List;

import com.crazybookings.beans.User;

public interface RegisterService {

    public void addUser(User user);
    
    public List<User> getAllUsers();
    
}
