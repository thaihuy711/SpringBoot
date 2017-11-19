(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.controller('MainController', MainController);

    MainController.$inject = ['$log', 'musicanService'];

    function MainController($log, musicanService) {
        var vm = this;
        vm.create = create;
        vm.search = search;


        musicanService.list().then(function (resp) {
            vm.musicans = resp;
            $log.info(vm.musicans);
        });


        function create() {
            $log.info('Create musicans');
        }

        function search(filter) {
            $log.info(filter);
        }

    }
})();