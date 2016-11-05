'use strict';


var ProductController = function($scope, $http) {    
    
    $scope.products = [];
    
    $scope.getAllProducts = function(){    	
	   	 $http({
	            url: 'products/getAllProducts/',
	            method: "POST",
	            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	     }).success(function (data, status, headers, config) {
			   	var i=0;
		        for(i=0; i< data.productList.length; i++){
		        	  $scope.products.push(data.productList[i]);
		        }
		  }).error(function (data, status, headers, config) {
	            alert('fail retrieving products');	            
	      });       
    }
    
    $scope.getAllProducts();
    
    $scope.product = {};
    $scope.data = {};
    
    //Add product into Cart
    $scope.addProductToCart = function(product) {
    	
    	var nombre = product.name;
    	var price = product.price;
    	var quantity = $scope.data.singleSelect;

    	var product = {
				"name" : nombre,
				"price" : price,
				"quantity" : quantity 
		};	

       
       	$http.post("products/addProductToCart", product).success(function(){
       		alert('product add into cart');	
        });  

    };
    
};