'use strict';
// Creación del módulo

var CrazyBookingsApp = {}; 

var CrazyBookingsApp = angular.module('CrazyBookingsApp', []);


// Configuración de las rutas
CrazyBookingsApp.config(function($routeProvider) {

    $routeProvider
        .when('/index', {
            templateUrl : 'main/layout',
            controller: RegisterController
        })
        
        .otherwise({
            redirectTo: '/index'
        });
});



