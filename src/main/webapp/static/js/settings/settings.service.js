settingsApp.factory('settingsService', ['$resource', '$http', function ($resource, $http) {
    "use strict";

    function resolveDescName(name) {
        switch (name) {
            case 'EC':
                return 'l\'espace client';
            case 'EERS':
                return 'l\'entrée en relation souscription';
            case 'BSS':
                return 'BSS';
        }
    }

    function checkUrl(name, url) {
        return $http.get('/settings/' + name + '/check', {params: {url: url}})
    }

    function statusIcon(status) {
        var prefix = 'fa fa-lg fa-', icon = 'spinner fa-spin';
        if (status === true) {
            icon = 'check text-success';
        } else if (status === false) {
            icon = 'times text-danger';
        }
        return prefix + icon;
    }

    return {
        descName: resolveDescName,
        checkUrl: checkUrl,
        resource: $resource('/settings/:name', {name: '@id'}),
        statusIcon: statusIcon
    };
}]);