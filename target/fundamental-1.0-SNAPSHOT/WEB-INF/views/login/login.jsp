

<%--
  Created by IntelliJ IDEA.
  User: sai
  Date: 2/17/16
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="robots" content="noarchive" />
    <title>Sign In</title>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
    <script>
        angular.module('myApp', ['ngCookies'])

                .controller('LoginCtrl', ['$scope', '$rootScope','$http', '$cookies',
                    function ($scope, $rootScope,$http,$cookies) {
                        console.log("jj");
                        var service = {};
                        $scope.loginMain = function () {
                            $scope.dataLoading = true;
                            console.log($scope.username);
                            if($scope.username =="" || $scope.username == undefined)
                            {
                                document.getElementById('lbltipAddedComment').innerHTML = 'Please enter email id';
                            }
                            else if($scope.validateEmail()== true)
                            {
                                if($scope.password =="" || $scope.password == undefined)
                                {
                                    document.getElementById('lbltipAddedComment').innerHTML = 'Please enter password';
                                }
                                else
                                {
                                    console.log($scope.password);
                                    $http.post('loginCtrl', {email: $scope.username, pwsd: $scope.password})
                                            .success(function (response) {
                                                console.log(response);
                                                console.log(response.length);
                                                if (response.length == 0) {
                                                    $scope.password = "";
                                                    document.getElementById('lbltipAddedComment').innerHTML = 'Invalid Credentials!!';

                                                }
                                                else {
                                                    if(response[0].status == "Inactive")
                                                    {
                                                        document.getElementById('lbltipAddedComment').innerHTML = 'Account Inactive!!';
                                                    }
                                                    else if(response[0].status == "Deleted")
                                                    {
                                                        document.getElementById('lbltipAddedComment').innerHTML = 'Account Inactive!!';
                                                    }
                                                    else {
                                                        $cookies.put("user", response[0].id);
                                                        window.location.href = "home"
                                                    }
                                                }
                                            });
                                }
                            }
                        };
                        $scope.validateEmail = function(){

                            var x = $scope.username;
                            var atpos = x.indexOf("@");
                            var dotpos = x.lastIndexOf(".");
                            if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
                                document.getElementById('lbltipAddedComment').innerHTML = 'Invalid Email id entered!!';
                                return false;
                            }
                            return true;
                        };
                    }]);


    </script>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <style type="text/css">
        /* Credit to bootsnipp.com for the css for the color graph */
        .colorgraph {
            height: 5px;
            border-top: 0;
            background: #c4e17f;
            border-radius: 5px;
            background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
            background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
            background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
            background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
        }
    </style>
</head>
<body ng-app="myApp">

<div class="container">

    <div class="row" style="margin-top:20px" ng-controller="LoginCtrl as lgnctrl" >
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" ng-submit="loginMain()">
                <fieldset>
                    <h2>Please Sign In</h2>
                    <hr class="colorgraph">
                    <div class="form-group">
                        <input type="email" autocapitalize="off" autocomplete="off"  name="email" id="email" class="form-control input-lg" placeholder="Email Address" ng-model = "username">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" ng-model = "password">
                    </div>
				<span class="button-checkbox">
					<label id="lbltipAddedComment"></label>
					<a href="/forgot_password" class="btn btn-link pull-right">Forgot Password?</a>
				</span>
                    <br/>
                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <a href="/sign_up" class="btn btn-lg btn-primary btn-block">Register</a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

</div>
</body>
</html>
