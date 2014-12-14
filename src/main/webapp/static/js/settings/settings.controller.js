settingsApp.controller('SettingsCtrl', ['settingsService', '$timeout', SettingsCtrl]);

function SettingsCtrl(settingsService, $timeout) {

    var vm = this;

    vm.switchProject = function (name) {
        vm.app = settingsService.resource.get({name: name},
            function (data) {
                settingsService.initApp(data)
            }, function () {
                vm.app.name = name;
                vm.app.instances = [];
                settingsService.initApp(vm.app);
            });
    };

    vm.addInstance = function () {
        var instance = {
            url: vm.app.toAddInstance
        };
        if (instance.url) {
            settingsService.updateInstance(instance);
            vm.app.instances.push(instance);
            vm.app.toAddInstance = '';
        }
    };

    vm.update = function (instance) {
        settingsService.updateInstance(instance);
    };

    vm.statusIcon = function (status) {
        return settingsService.statusIcon(status);
    };

    vm.statusBtn = function (status) {
        return settingsService.statusBtn(status);
    };

    vm.remove = function (i) {
        vm.app.instances.splice(i, 1);
    };

    vm.submit = function () {
        vm.app.$save(function (app) {
            settingsService.initApp(app);
            vm.alert = {
                message: 'Enregistrement avec succès des paramètres du projet ' + app.name,
                type: 'success'
            };
        }, function () {
            vm.alert = {
                message: 'Erreur lors de l\'enregistrement des paramètres',
                type: 'danger'
            }
        });
    };

    vm.switchProject('EERS');

    vm.alert = {};

}