var mfmApp = angular.module('mfmApp', ['ngMessages', 'ngRoute', 'ngResource', 'ui.bootstrap']);

mfmApp.config(function ($routeProvider) {
    "use strict";
    $routeProvider.when('/dashboard/:projectName', {
        controller: 'DashboardCtrl',
        templateUrl: 'views/dashboard.html'
    }).otherwise({
        controller: 'HomeCtrl',
        templateUrl: 'views/home.html'
    })
});