package com.crazybookings.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Usr.findByName", query = "select u from Usr u where u.name = :name")
public class Usr {
    @Id // @Id indicates that this it a unique primary key
    @GeneratedValue // @GeneratedValue indicates that value is automatically generated by the server
    private Long id;

    @Column(length = 32, unique = true)
    // the optional @Column allows us makes sure that the name is limited to a suitable size and is unique
    private String name;

    private String email;
   
    public void setId(Long id){
    	this.id = id;
    }
    
	public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
    
}