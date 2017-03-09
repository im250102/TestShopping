'use strict';


'use strict';

/**
 * ProductController
 * @constructor
 */

var AdminController =  function($scope, $http, fileUpload) {

    $scope.uploadFile = function(){
        var file = $scope.myFile;
        var product = $scope.product;
        var price = $scope.price;
        console.dir(file);
        var uploadUrl = "admin/uploadFile";
        fileUpload.uploadFileToUrl(product, price, file, uploadUrl);
    };

};