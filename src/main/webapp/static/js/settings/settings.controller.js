settingsApp.controller('SettingsCtrl', ['settingsService', SettingsCtrl]);

function SettingsCtrl(settingsService) {

    var members = ['Toto', 'Tutu', 'Tata'];

    this.current = {
        members: members
    };

    this.switchProject = function (name) {
        this.current.name = name;
        this.current.longName = settingsService.descName(name);
    };

    this.switchProject('EERS');

}