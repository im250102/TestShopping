'use strict';


var ProductController = function($scope, $http, $cookieStore) {    
    
    $scope.products = [];
    
    $scope.getAllProducts = function(searchWine){    	
	   	 $http({
	            url: 'products/getAllProducts/',
	            method: "POST",
	            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	     }).then(function successCallback(response) {
	    		$scope.products = response.data.productList;
		 }
	     );       
    }
    
    $scope.getAllProducts();
    
    $scope.product = {};
    $scope.data = {};
    
    //Add product into Cart
    $scope.addProductToCart = function(product) {
       
       	$http.post("products/addProductToCart", product).then(function(){
       		alert('product added into cart');	
        });  

    };
    
    //Search wine
    $scope.searchWine = function(searchWine) {
    	//Add cookie wine
    	$cookieStore.put("Vino", searchWine);
    	
    	$scope.products = [];
        $http({
            url: 'products/getProductByName/' + searchWine,
            method: "POST",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (response) {
        	$scope.products = response.data.productList;
        });     
       	
    };
    
    
    
};