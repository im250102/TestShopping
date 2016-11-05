'use strict';


var CartController = function($scope, $http) {    

    $scope.fetchOrdersList = function() {
        $http.get('cart/orderList.json').success(function(orderList){
            $scope.orders = orderList;
        });
    };
    
	$scope.fetchOrdersList();
	
    $scope.totalizar = function(){
    	  var totalOrder = 0;
    	  angular.forEach($scope.orders, function(value, key){
    		  totalOrder = totalOrder + value.quantity * value.price;
    	   });
    	  $scope.total= totalOrder;
    }
    
    $scope.deleteOrder = function(id) {
        $http.delete('cart/delete/' + id).success(function() {
        	$scope.fetchOrdersList();
        });
    };
	
    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };
    	 
};