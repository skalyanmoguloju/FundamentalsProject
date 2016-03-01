
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
    <title>Password Reset</title>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
    <script>
        angular.module('myApp', ['ngCookies'])
                .controller('rstCtrl', ['$scope', '$rootScope','$http', '$cookies',
                    function ($scope, $rootScope,$http,$cookies) {
                        console.log("jj");
                        var service = {};
                        $scope.loginMain = function () {
                            $scope.password = document.getElementById('hidpassword').value;
                            $scope.password1 = document.getElementById('hidpassword1').value;
                            console.log($scope.password);
                            console.log($scope.password1);
                            if($scope.asteriskpassword =="" || $scope.asteriskpassword == undefined)
                            {
                                document.getElementById('lbltipAddedComment').innerHTML = 'New Password cannot be blank';
                            }
                            else if($scope.password.length < 6)
                            {
                                document.getElementById('lbltipAddedComment').innerHTML = 'New Password must contain at least 6 characters';
                            }
                            else if(!$scope.password.match(/((^[0-9]+[a-z]+)|(^[a-z]+[0-9]+))+[0-9a-z]*$/i))
                            {
                                document.getElementById('lbltipAddedComment').innerHTML = 'New Password must contain alphanumeric characters';
                            }
                            else if($scope.asteriskpassword1 =="" || $scope.asteriskpassword1 == undefined)
                            {
                                document.getElementById('lbltipAddedComment').innerHTML = 'Confirm Password cannot be blank';
                            }
                            else if($scope.password != $scope.password1)
                            {
                                document.getElementById('lbltipAddedComment').innerHTML = 'Confirm Password does not match with New Password';
                            }
                            else if($scope.password == $scope.password1)
                            {
                                console.log($scope.password);
                                $http.post('resetDone', {pwsd: $scope.password})
                                        .success(function (response) {
                                            console.log(response);
                                            console.log(response.length);
                                            if (response.length == 0) {
                                                $scope.asteriskpassword = "";
                                                $scope.asteriskpassword1 = "";
                                                document.getElementById('lbltipAddedComment').innerHTML = 'Please try again!!';
                                            }
                                            else {
                                                alert("Password is updated.")
                                                window.location.href = "/";
                                            }
                                        });
                            }
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
    <script type="text/javascript" src="js/asteriskPassword.js"></script>
</head>


<body ng-app="myApp">

<div class="container">

    <div class="row" style="margin-top:20px" ng-controller="rstCtrl as rstctrl" >
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" ng-submit="loginMain()">
                <fieldset>
                    <h2>Password Reset</h2>
                    <hr class="colorgraph">
                    <br/>
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control input-lg" placeholder="New Password" ng-model = "asteriskpassword">
                        <script type="text/javascript"> new AsteriskPassword(document.getElementById('password'), '\u002A'); </script>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password1" id="password1" class="form-control input-lg" placeholder="Confirm Password" ng-model = "asteriskpassword1">
                        <script type="text/javascript"> new AsteriskPassword(document.getElementById('password1'), '\u002A'); </script>
                    </div>
                    <div class="col-xs-6 col-md-10">
                        <div class="form-group">
                            <label id="lbltipAddedComment"></label>
                        </div>
                    </div>
                    <br/>
                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Submit New Password">
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

</div>
</body>
</html>