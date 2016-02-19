angular.module('myApp', ['ngResource'])

    .config(function config( $stateProvider ) {
        $stateProvider.state( 'login', {
            url: '/login',
            views: {
                "main": {
                    controller: 'LoginCtrl',
                    templateUrl: 'login.jsp'
                }
            },
            data:{ pageTitle: 'Login' }
        });
    })

    .controller('LoginCtrl',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
        function ($scope, $rootScope, $location, AuthenticationService) {

            $scope.title = "Welcome to Login Screen";
            $scope.message1 = "hello";
            $scope.value = 2;

            $scope.login = function () {
                $scope.dataLoading = true;
                AuthenticationService.Login($scope.username, $scope.password, function(response) {
                    if(response.firstName != null) {
                        $location.path('/welcome');
                    } else {
                        $location.path('/error');
                    }
                });
            };
        }]);