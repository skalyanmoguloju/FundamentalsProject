
angular.module('myApp')

    .factory('AuthenticationService',
    ['$http', '$cookieStore', '$rootScope', '$timeout',
        function ($http, $cookieStore, $rootScope, $timeout) {
            var service = {};

            service.Login = function (username, password, callback){
                $http.post('/rest/users/login', {username: username, password: password})
                    .success(function (response) {
                        callback(response);
                    });
                $http.post('/rest/users/login', {username: username, password: password})
                    .success(function (response) {
                        callback(response);
                    });
            }
            ;
            return service;
        }]);