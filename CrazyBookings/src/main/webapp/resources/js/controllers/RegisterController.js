'use strict';

/**
 * RegistereController
 * @constructor
 */

var RegisterController =  function($scope, $http, $cookieStore) {
	
	// Define function dependencies
    
	$scope.user = {};
	
    //Add product into cart
    $scope.addUser = function(user) {
    	$cookieStore.put("Nombre", $scope.user.name);
    	
    	$http.post('register/addUser', user).then(function() {
            $scope.fetchUsersList();
        });  
        
    };
       
    $scope.fetchUsersList = function() {
        $http.get('register/userlist.json').then(function successCallback(response){
            $scope.users = response.data;
        });
    };
    
    $scope.deleteUser = function(name){
        $http.delete('register/delete/' + name).then(function() {
        	$scope.fetchUsersList();
        });
    };
    
    $scope.fetchUsersList();

    $scope.predicate = 'name';
    
};