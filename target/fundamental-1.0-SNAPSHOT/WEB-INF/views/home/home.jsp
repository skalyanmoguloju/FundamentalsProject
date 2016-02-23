<%--
  Created by IntelliJ IDEA.
  User: sai
  Date: 2/22/16
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
<script>
    angular.module('myApp', ['ngCookies'])

            .controller('HomeCtrl', ['$scope', '$rootScope','$http','$cookies',
                function ($scope, $rootScope,$http,$cookies) {
                    console.log("jj");
                    var user = $cookies.get("user").toString();
                    //console.log(user.toString());
                    $http.post('userInfo', {id: user})
                            .success(function (response) {
                                console.log(response);
                                console.log(response.length);
                                $scope.userInfo = response[0];
                                $http.post('rights', {role: response[0].role})
                                        .success(function (data) {
                                            console.log(data);
                                            $scope.rights = data;
                                });
                            });


                }]);
</script>
<style type="text/css">
    .list-group-horizontal .list-group-item {
        display: inline-block;
    }
    .list-group-horizontal .list-group-item {
        margin-bottom: 0;
        margin-left:-4px;
        margin-right: 0;
    }
    .list-group-horizontal .list-group-item:first-child {
        border-top-right-radius:0;
        border-bottom-left-radius:4px;
    }
    .list-group-horizontal .list-group-item:last-child {
        border-top-right-radius:4px;
        border-bottom-left-radius:0;
    }
    body {
        background:#f0f0f0;
    }
    .nav {
        left:50%;
        margin-left:-150px;
        top:50px;
        position:absolute;
    }
    .nav>li>a:hover, .nav>li>a:focus, .nav .open>a, .nav .open>a:hover, .nav .open>a:focus {
        background:#fff;
    }
    .dropdown {
        background:#fff;
        border:1px solid #ccc;
        border-radius:4px;
        width:300px;
    }
    .dropdown-menu>li>a {
        color:#428bca;
    }
    .dropdown ul.dropdown-menu {
        border-radius:4px;
        box-shadow:none;
        margin-top:20px;
        width:300px;
    }
    .dropdown ul.dropdown-menu:before {
        content: "";
        border-bottom: 10px solid #fff;
        border-right: 10px solid transparent;
        border-left: 10px solid transparent;
        position: absolute;
        top: -10px;
        right: 16px;
        z-index: 10;
    }
    .dropdown ul.dropdown-menu:after {
        content: "";
        border-bottom: 12px solid #ccc;
        border-right: 12px solid transparent;
        border-left: 12px solid transparent;
        position: absolute;
        top: -12px;
        right: 14px;
        z-index: 9;
    }
</style>
<head>
    <title></title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<div class="container" ng-app="myApp">
    <div ng-controller="HomeCtrl as hmectrl">
        <ul class="nav navbar-nav" ng-model = "userInfo">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">{{userInfo.name}} <span class="glyphicon glyphicon-user pull-right"></span></a>
                <ul class="dropdown-menu">

                    <li><a href="#">Account Settings <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">User stats <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">Messages <span class="badge pull-right"> 42 </span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">Favourites Snippets <span class="glyphicon glyphicon-heart pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">Sign Out <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="row" style="padding-top:50px">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 text-center" ng-controller="HomeCtrl as hmectrl">

            <div class="list-group list-group-horizontal" ng-model = "rights"  >

                <a href="#" ng-repeat="rig in rights" class="list-group-item">{{rig}}</a>
            </div>

        </div>

    </div>
</div>
</body>
</html>
