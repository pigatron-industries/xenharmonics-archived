
var app = angular.module('xen', ['ui.bootstrap','ngRoute','vds.multirange']);

app.controller('xen', function($scope,  $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
});

app.config(function($routeProvider, $locationProvider) {
    $routeProvider.when('/scales', {
        templateUrl: 'scale-designer/scale-designer.html',
        controller: 'scales'
    });
});