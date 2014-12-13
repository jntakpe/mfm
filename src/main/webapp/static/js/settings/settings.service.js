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

    function checkUrl(url) {
        return $http.get('/settings/check', {params: {url: url + '/info'}})
    }

    function statusIcon(status) {
        var prefix = 'fa fa-lg fa-', icon = 'spinner fa-spin';
        if (status === true) {
            icon = 'check';
        } else if (status === false) {
            icon = 'times';
        }
        return prefix + icon;
    }

    function statusBtn(status) {
        var prefix = 'btn btn-sm btn-', btn = 'grey';
        if (status === true) {
            btn = 'success';
        } else if (status === false) {
            btn = 'danger';
        }
        return prefix + btn;
    }

    function findByName(name, apps) {
        var app;
        for (app in apps) {
            if (apps.hasOwnProperty(app) && apps[app].name === name) {
                return apps[app];
            }
        }
        return {name: name, instances: []};
    }

    return {
        resource: $resource('/settings'),
        descName: resolveDescName,
        checkUrl: checkUrl,
        statusIcon: statusIcon,
        statusBtn: statusBtn,
        findByName: findByName
    };
}]);