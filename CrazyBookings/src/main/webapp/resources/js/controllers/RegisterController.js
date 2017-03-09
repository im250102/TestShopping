'use strict';

/**
 * RegistereController
 * @constructor
 */

var RegisterController =  function($scope, $http) {
	
	// Define function dependencies
    
	$scope.user = {};
	
    //Add product into cart
    $scope.addUser = function(user) {
    	
    	$http.post('register/addUser', user).success(function() {
            $scope.fetchUsersList();
        });  
        
    };
       
    $scope.fetchUsersList = function() {
        $http.get('register/userlist.json').success(function(userList){
            $scope.users = userList;
        });
    };
    
    $scope.deleteUser = function(name){
        $http.delete('register/delete/' + name).success(function() {
        	$scope.fetchUsersList();
        });
    };
    
    $scope.fetchUsersList();

    $scope.predicate = 'name';
    
};