'use strict';
// Creación del módulo

var CrazyBookingsApp = {}; 

var CrazyBookingsApp = angular.module('CrazyBookingsApp', []);


// Configuración de las rutas
CrazyBookingsApp.config(function($routeProvider) {

    $routeProvider
        .when('/index', {
        	templateUrl : 'products/layout',
            controller: ProductController
        })
        
        .when('/register', {
        	templateUrl : 'register/layout',
        	controller: RegisterController
        })
        
        .otherwise({
            redirectTo: '/index'
        });
});



