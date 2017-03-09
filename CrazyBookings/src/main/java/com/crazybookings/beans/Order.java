package com.crazybookings.beans;

public class Order {
    
	private Long id;
	private int quantity;
	private int price;
	private String name;
	
	//Spring needs this constructor	
	public Order() { }
	
	public Order(int quantity, String name, int price){
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
