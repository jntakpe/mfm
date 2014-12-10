settingsApp.controller('SettingsCtrl', ['settingsService', SettingsCtrl]);

function SettingsCtrl(settingsService) {

    this.app = {
        instances: [{url: 'toto', status: 'haha'}]
    };

    this.switchProject = function (name) {
        this.app.name = name;
        this.app.longName = settingsService.descName(name);
    };

    this.addInstance = function () {
        var instance = {
            url: this.app.toAddInstance
        };
        settingsService.checkUrl('ec', 'http://www.google.fr')
            .success(function () {
                instance.status = true;
            }).error(function () {
                instance.status = false;
            });
        this.app.instances.push(instance);
        this.app.toAddInstance = '';
    };

    this.statusIcon = function (status) {
        return settingsService.statusIcon(status);
    };

    this.switchProject('EERS');

}