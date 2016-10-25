'use strict';


var ProductController = function($scope, $http) {    
    
    $scope.products = [];
    
    //Recupera todos los productos almacenados en la lista de productos
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

    
    //Initializa product and data
    $scope.product = {};
    $scope.data = {};
    
    //Add product into cart
    $scope.addProductToCart = function(product) {
    	
    	var nombre = product.name;
    	var price = product.price;
    	var quantity = $scope.data.singleSelect;

    	var product = {
				"name" : nombre,
				"price" : price,
				"quantity" : quantity 
		};	

       
       	$http.post("cart/addProduct", product).success(function(){
       		alert('product add into cart');	
        });  
       	


    };
    
};