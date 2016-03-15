<%--
  Created by IntelliJ IDEA.
  User: sai
  Date: 3/10/16
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
</head>
<body>

    <div ng-controller="HomeCtrl as hmectrl" style="float: right">
        <ul class="nav navbar-nav" ng-model = "userInfo" style="left: 75%">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">{{userInfo.name}} {{userInfo.lname}} <span class="glyphicon glyphicon-user pull-right"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><b>Id : </b> {{userInfo.id}} <span class="glyphicon glyphicon-fire pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">{{userInfo.role}} <span class="glyphicon glyphicon-tags pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">{{userInfo.email}} <span class="glyphicon glyphicon-envelope pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">{{userInfo.dob}} <span class="glyphicon glyphicon-gift pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="/cart">Cart <span class="glyphicon glyphicons-cart-in pull-right"></span></a></li>
                    <li class="divider"></li>
                    <li><a href="#">Sign Out <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="row" style="padding-top:50px">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 text-center" ng-controller="HomeCtrl as hmectrl">

            <div class="list-group list-group-horizontal" ng-model = "rights"  style="text-align: left" >
                <a href="/home" class="list-group-item">Home</a>
                <a  ng-href="/{{rig | lowercase}}" ng-repeat="rig in rights" class="list-group-item">{{rig}}</a>

            </div>

        </div>
    </div>
</body>
</html>
