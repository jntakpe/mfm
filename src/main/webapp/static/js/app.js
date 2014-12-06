var menuApp = angular.module('menuApp', []),
    settingsApp = angular.module('settingsApp', []),
    mfmApp = angular.module('mfmApp', ['menuApp', 'settingsApp', 'ngMessages', 'ngRoute', 'ngResource', 'ui.bootstrap']);

mfmApp.config(function ($routeProvider) {
    "use strict";
    $routeProvider
        .when('/projects/:projectName/dashboard', {
            controller: 'DashboardCtrl as dashboard',
            templateUrl: 'views/dashboard.html'
        }).when('/settings', {
            controller: 'SettingsCtrl as settings',
            templateUrl: 'views/settings.html'
        })
        .otherwise({
            controller: 'HomeCtrl as home',
            templateUrl: 'views/home.html'
        })
});