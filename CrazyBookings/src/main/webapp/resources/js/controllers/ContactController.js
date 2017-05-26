'use strict';

/**
 * ContactController
 * @constructor
 */

var ContactController =  function($scope, $http) {
	
	$scope.email = {};
	
    //Add product into cart
    $scope.sendEmail = function(email) {
    	
    	$http.post('contact/sendEmail', email).then();  
        
    };
       

    
};