var todoApp = angular.module('todoApp');

todoApp.config(function ($stateProvider) {
    var mainState = {
        name: 'main',
        url: '/',
        templateUrl: 'components/list/list.html',
        controller: 'MainController',
        controllerAs: '$ctrl'
    };

    var formState = {
        name: 'form',
        url: '/form',
        template: '<h3>This is musican form for update/create!</h3>'
    };

    var deleteMusican = {
        name: 'delete',
        url: '/delete',
        template: '<h3>Delete musican!</h3>'
    };

    $stateProvider.state(mainState);
    $stateProvider.state(formState);
    $stateProvider.state(deleteMusican);
});