var menuApp = angular.module('menuApp', []),
    mfmApp = angular.module('mfmApp', ['menuApp', 'ngMessages', 'ngRoute', 'ngResource', 'ui.bootstrap']);

mfmApp.config(function ($routeProvider) {
    "use strict";
    $routeProvider.when('/projects/:projectName/dashboard', {
        controller: 'DashboardCtrl',
        templateUrl: 'views/dashboard.html'
    }).otherwise({
        controller: 'HomeCtrl',
        templateUrl: 'views/home.html'
    })
});