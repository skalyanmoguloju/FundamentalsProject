angular.module('myApp', [])

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

    .controller('LoginCtrl', ['$scope', '$rootScope','AuthenticationService',
        function ($scope, $rootScope, AuthenticationService) {
            console.log("jj");
            $scope.loginMain = function () {
                alert("he");
                console.log("hell");
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