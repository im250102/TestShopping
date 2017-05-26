'use strict';

/* Services */

var AppServices = angular.module('CrazyBookingsApp.services', []);



AppServices.service('fileUpload', ['$http', function ($http) {
	
    this.uploadFileToUrl = function(product, price, file, uploadUrl){
        var fd = new FormData();
        
        fd.append('file', file);
        fd.append('product', product);
        fd.append('price', price);
        
        
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .then(function(){
        	alert("Success ... " + status);
        });
        
    }
}]);

AppServices.value('version', '0.1');
