settingsApp.controller('SettingsCtrl', ['settingsService', SettingsCtrl]);

function SettingsCtrl(settingsService) {

    this.app = {
        instances: ['Toto', 'Tutu', 'Tata']
    };

    this.switchProject = function (name) {
        this.app.name = name;
        this.app.longName = settingsService.descName(name);
    };

    this.addInstance = function () {
        this.app.instances.push(this.app.toAddInstance);
        this.app.toAddInstance = '';
    };
    
    this.switchProject('EERS');

}