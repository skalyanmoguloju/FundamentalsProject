<%--
  Created by IntelliJ IDEA.
  User: sai
  Date: 2/17/16
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
    <script>
        angular.module('myApp', [])

                .controller('ForgotCtrl', ['$scope', '$rootScope','$http',
                    function ($scope, $rootScope,$http) {
                        var service = {};
                        $scope.forgetMain = function () {
                            console.log($scope.email_address);
                            if($scope.email_address =="" || $scope.email_address == undefined)
                            {
                                document.getElementById('lbltipAddedComment').innerHTML = 'Please enter email id';
                            }
                            else if($scope.validateEmail()== true)
                            {
                                    $http.post('forgotCtrl', {email: $scope.email_address})
                                            .success(function (response) {
                                                console.log(response);
                                                console.log(response.length);
                                                if (response.length==0) {
                                                    document.getElementById('lbltipAddedComment').innerHTML = 'Invalid Email Id!!!';
                                                }
                                                else {
                                                    alert("Email has been sent to your email");
                                                    window.location.href = "/"
                                                }
                                            });

                            }
                        };
                        $scope.validateEmail = function(){

                            var x = $scope.email_address;
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="robots" content="noarchive" />
    <title>Forgot your password?</title>


</head>
<body ng-app="myApp">>


<div class="container">

    <div class="row" style="margin-top:20px" ng-controller="ForgotCtrl as frgctrl" >
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" ng-submit="forgetMain()">
                <fieldset>
                    <hr class="colorgraph">
                    <h2>Can't sign in?</h2>
                    <p>Enter your email address below and we'll send you password reset instructions.</p>

                    <div class="form-group">
                        <input type="email" autocapitalize="off" autocomplete="off"  name="email" id="email_address" class="form-control input-lg" placeholder="Email Address" ng-model = "email_address">
                    </div>

				<span class="button-checkbox">
					<label id="lbltipAddedComment"></label>
				</span>

                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Send me reset instructions" >
                            </div>
                    </div>
                        <div class="note">
                            <h3>A note about spam filters</h3>
                            If you don't get an email from us within a few minutes please be sure to check your spam filter.
                        </div>
                        <li>Never mind, <a href="/">send me back to the sign in screen</a></li>
                </fieldset>
            </form>
        </div>
    </div>

</div></body>
</html>
