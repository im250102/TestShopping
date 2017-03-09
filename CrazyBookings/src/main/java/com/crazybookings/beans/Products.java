package com.crazybookings.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.crazybookings.persistence.ProductPersist;

public class Products {

	private List<Product> productList = null;
	
	public Products(){} //Spring needs this constructor
	
	public Products(List<Product> productList) {
	       this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
           Gson gson = new GsonBuilder().setPrettyPrinting().create();
           return gson.toJson(this);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Products prepareProductList (Collection<ProductPersist> list){
	    List productsAux = new ArrayList();	
	    Iterator itList = list.iterator();
	    while(itList.hasNext()){
	    		ProductPersist productPersist =(ProductPersist) itList.next();
	    		Product product = new Product();
	    		product.setSrc(encodeToBase64(productPersist.getImage()));
		    	product.setName(productPersist.getName());
		    	product.setPrice(productPersist.getPrice());
		    	productsAux.add(product);
	    }
	    return new Products(productsAux);
	}
	
	@SuppressWarnings("restriction")
	public String encodeToBase64(byte[] byteArray){
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encode(byteArray);
	}
	
}
