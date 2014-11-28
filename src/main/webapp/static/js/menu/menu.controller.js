menuApp.controller('MenuCtrl', MenuCtrl);

function MenuCtrl() {
    this.active = {
        main: 'projects',
        sub: ''
    };
    this.changeMainMenu = function (main) {
        if (main !== this.active.main) {
            this.active.sub = '';
        }
        this.active.main = main;
    };
}