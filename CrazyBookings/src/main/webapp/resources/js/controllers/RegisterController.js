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
    	var name = $scope.user.name;
    	var email = $scope.user.email;
    	
    	var user = {
				"name" : name,
				"email" : email
		};	
       
    	
    	$http.post('main/addUser', user).success(function() {
            $scope.fetchUsersList();
    		alert('user register succesfully');	
        });  
        
    };
       
    $scope.fetchUsersList = function() {
        $http.get('main/userlist.json').success(function(userList){
            $scope.users = userList;
        });
    };
    
    $scope.deleteUser = function(name){
        $http.delete('main/delete/' + name).success(function() {
        	$scope.fetchUsersList();
        });
    };
    
    $scope.fetchUsersList();

    $scope.predicate = 'name';
    
};