var menuApp = angular.module('menuApp', []);

menuApp.controller('MenuCtrl', MenuCtrl);

function MenuCtrl() {
    this.active = {
        main: 'projects',
        sub: ''
    };
    this.changeMainMenu = function (main) {
        if (main !== this.active.main) {
            this.active.sub = '';
        }
        this.active.main = main;
    };
}

menuApp.directive('sub', function SubMenu() {
        return {
            restrict: 'E',
            replace: true,
            scope: {
                description: '@',
                active: '='
            },
            link: function (scope, element, attributes) {
                scope.application = attributes.application;
                element.bind('click', function () {
                    scope.active.sub = scope.application;
                });
            },
            templateUrl: 'directives/sub-menu.html'
        };
    }
);