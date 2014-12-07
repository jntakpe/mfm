settingsApp.controller('SettingsCtrl', ['settingsService', SettingsCtrl]);

function SettingsCtrl(settingsService) {

    this.current = {};

    this.switchProject = function (name) {
        this.current.name = name;
        this.current.longName = settingsService.descName(name);
    };

    this.switchProject('EERS');

}