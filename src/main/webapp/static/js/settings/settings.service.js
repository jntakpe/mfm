settingsApp.factory('settingsService', ['$resource', function ($resource) {
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

    return {
        descName: resolveDescName
    };
}]);