var menuApp = angular.module('menuApp', []),
    settingsApp = angular.module('settingsApp', []),
    projectApp = angular.module('projectApp', []),
    mfmApp = angular.module('mfmApp', ['menuApp', 'ngMessages', 'ngRoute', 'ngResource', 'ui.bootstrap']);

mfmApp.config(function ($routeProvider) {
    "use strict";
    $routeProvider
        .when('/projects/:projectName/dashboard', {
            controller: 'DashboardCtrl',
            templateUrl: 'views/dashboard.html'
        }).when('/settings', {
            controller: 'SettingsCtrl',
            templateUrl: 'views/settings.html'
        })
        .otherwise({
            controller: 'HomeCtrl',
            templateUrl: 'views/home.html'
        })
});