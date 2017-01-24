'use strict';
// Creación del módulo

var CrazyBookingsApp = {}; 

var CrazyBookingsApp = angular.module('CrazyBookingsApp', ['CrazyBookingsApp.services', 'CrazyBookingsApp.directives']);


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

        .when('/admin', {
        	templateUrl : 'admin/layout',
            controller: AdminController
        })
        
        .when('/cart', {
        	templateUrl : 'cart/layout',
            controller: CartController
        })
        
        .when('/contact', {        	
        	templateUrl : 'contact/layout'
        })
       
        .otherwise({
            redirectTo: '/index'
        });
});



