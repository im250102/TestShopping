'use strict';
// Creación del módulo

var CrazyBookingsApp = {}; 

var CrazyBookingsApp = angular.module('CrazyBookingsApp', ['CrazyBookingsApp.services', 'CrazyBookingsApp.directives', 'ngCookies', 'ngRoute']);

//Due to Angular 1.6.4. require do this in the location Provider
CrazyBookingsApp.config(['$locationProvider', function($locationProvider) {
	  $locationProvider.hashPrefix('');
}]);


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
        	templateUrl : 'contact/layout',
        	controller: ContactController
        })
       
        .otherwise({
            redirectTo: '/index'
        });
});



