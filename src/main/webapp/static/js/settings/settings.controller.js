settingsApp.controller('SettingsCtrl', ['settingsService', SettingsCtrl]);

function SettingsCtrl(settingsService) {

    var vm = this;

    function updateInstance(instance) {
        settingsService.checkUrl(instance.url)
            .success(function () {
                instance.status = true;
            }).error(function () {
                instance.status = false;
            });
    }

    settingsService.resource.query(function (data) {
        vm.apps = data;
        vm.switchProject('EERS');
    });

    vm.switchProject = function (name) {
        vm.app = settingsService.findByName(name, vm.apps);
        vm.app.longName = settingsService.descName(name);
    };

    vm.addInstance = function () {
        var instance = {
            url: vm.app.toAddInstance
        };
        if (instance.url) {
            updateInstance(instance);
            vm.app.instances.push(instance);
            vm.app.toAddInstance = '';
        }
    };

    vm.update = function (instance) {
        updateInstance(instance);
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

    vm.save = function () {
        settingsService.resource.save(vm.app,
            function (data) {
                vm.app = data;
            },
            function () {
                //Some alert !!!!
            });
    };

}