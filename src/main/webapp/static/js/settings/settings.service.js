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

    function updateInstance(instance) {
        checkUrl(instance.url)
            .success(function () {
                instance.status = true;
            }).error(function () {
                instance.status = false;
            });
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

    function init(app) {
        var instance, instances = app.instances;
        app.longName = resolveDescName(app.name);
        for (instance in instances) {
            if (instances.hasOwnProperty(instance)) {
                updateInstance(instances[instance]);
            }
        }
    }

    return {
        resource: $resource('/settings/:name', {name: '@name'}),
        updateInstance: updateInstance,
        statusIcon: statusIcon,
        statusBtn: statusBtn,
        initApp: init
    };
}]);