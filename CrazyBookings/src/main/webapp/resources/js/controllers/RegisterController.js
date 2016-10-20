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
    	alert('olacara');
    	var name = $scope.user.name;
    	var email = $scope.user.email;
    	
    	var user = {
				"name" : name,
				"email" : email
		};	

       
    	$http.post('main/addUser', user).success(function() {
       		alert('product add into cart');	
        });  

    };
//    
//    
//    
//    $scope.fetchUsersList = function() {
//        $http.get('register/userlist.json').success(function(userList){
//            $scope.users = userList;
//        });
//    };
//    
//    $scope.fetchUsersList();
//    
//    $scope.predicate = 'name';
//    
//    $scope.uploadFile = function(){
//        var file = $scope.myFile;
//        console.log('file is ' );
//        console.dir(file);
//        var uploadUrl = "/fileUpload";
//        fileUpload.uploadFileToUrl(file, uploadUrl);
//            
//    };

};