(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.controller('MainController', MainController);

    MainController.$inject = ['$log', 'musicanService'];

})();