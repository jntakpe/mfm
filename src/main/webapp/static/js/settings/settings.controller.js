settingsApp.controller('SettingsCtrl', ['settingsService', SettingsCtrl]);

function SettingsCtrl(settingsService) {

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
        });
    };

    vm.switchProject('EERS');
}