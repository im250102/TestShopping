package com.crazybookings.beans;

public class Product {
	
	private String src;
	private String name;
	private int price;
	private int quantity;
	private byte[] image;
		
	//Spring needs this constructor	
	public Product() {

	} 
	
	public Product(String name, String src, int price, int quantity) {
	            this.name = name;
	            this.price = price;
	            this.quantity = quantity;
	            this.src = src;
	}
	
	public String getSrc() {
		return src;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
