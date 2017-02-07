'use strict';

/**
 * ContactController
 * @constructor
 */

var ContactController =  function($scope, $http) {
	
	$scope.email = {};
	
    //Add product into cart
    $scope.sendEmail = function(email) {
    	var destiny = $scope.email.destiny;
    	var message = $scope.email.message;
    	
    	var email = {
				"destiny" : destiny,
				"message" : message
		};	
       
    	
    	$http.post('contact/sendEmail', email).success(function() {
    		alert('Email sent successfully');	
        });  
        
    };
       

    
};