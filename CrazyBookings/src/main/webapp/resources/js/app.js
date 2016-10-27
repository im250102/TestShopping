'use strict';
// Creación del módulo

var CrazyBookingsApp = {}; 

var CrazyBookingsApp = angular.module('CrazyBookingsApp', []);


// Configuración de las rutas
CrazyBookingsApp.config(function($routeProvider) {

    $routeProvider
        .when('/index', {
            templateUrl : 'register/layout',
            controller: RegisterController
        })
        
        .when('/products', {
            templateUrl : 'products/layout',
            controller: ProductController
        })
        
        .otherwise({
            redirectTo: '/index'
        });
});



