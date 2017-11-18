(function () {
    'use stricts';
    var todoApp = angular.module('todoApp');
    todoApp.factory('musicanService', musicanService);

    musicanService.$inject = ['$log', '$http'];

    function musicanService($log, $http) {
        return {
            list: list
        };

        function list(filter){
            return $http.get('/api/musicans').then(function(resp){
                return resp.data;
            })
        }
    }
})();