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
                    if (scope.active.sub === scope.application) {
                        scope.active.sub = '';
                    } else {
                        scope.active.sub = scope.application;
                    }
                });
            },
            templateUrl: 'directives/sub-menu.html'
        };
    }
);
