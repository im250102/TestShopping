'use strict';


var ProductController = function($scope, $http, ngDialog) {    
    
    $scope.products = [];
    
    $scope.getAllProducts = function(){    	
	   	 $http({
	            url: 'products/getAllProducts/',
	            method: "POST",
	            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	     }).success(function (data) {
			   	var i=0;
		        for(i=0; i< data.productList.length; i++){
		        	  $scope.products.push(data.productList[i]);
		        }
		 }
	     );       
    }
    
    $scope.getAllProducts();
    
    $scope.product = {};
    $scope.data = {};
    
    //Add product into Cart
    $scope.addProductToCart = function(product) {
       
       	$http.post("products/addProductToCart", product).success(function(){
            ngDialog.open({ template: 'products/popUpProduct', className: 'ngdialog-theme-default' });
        });  

    };
    
    //Search wine
    $scope.searchWine = function(searchWine) {

    	$scope.products = [];
        $http({
            url: 'products/getProductByName/' + searchWine,
            method: "POST",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function (data) {
		   	var i=0;
	        for(i=0; i< data.productList.length; i++){
	        	  $scope.products.push(data.productList[i]);
	        }
        });     
       	
    };
    
};