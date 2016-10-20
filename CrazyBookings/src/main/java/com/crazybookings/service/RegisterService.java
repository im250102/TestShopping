package com.crazybookings.service;

import java.util.List;

import com.crazybookings.persistence.Usr;

public interface RegisterService {

    public void addUser(Usr user);
    
    public List<Usr> getAllUsers();
    
}
