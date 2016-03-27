<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel Dao
  Date: 3/26/16
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
<script>
    angular.module('myApp', ['ngCookies'])

            .controller('HomeCtrl', ['$scope', '$rootScope','$http','$cookies','$filter',
                function ($scope, $rootScope,$http,$cookies,$filter) {
                    console.log("jj");
                    document.getElementById('lbAdminID').innerHTML = '<br><br>';
                    var user = $cookies.get("user").toString();
                    $http.post('userInfo', {id: user})
                            .success(function (response) {
                                var date = new Date();
                                $scope.userInfo = response[0];
                                $scope.userInfo.dob= $filter('date')(response[0].dob , "dd/MM/yyyy");
                                $http.post('rights', {role: response[0].role})
                                        .success(function (data) {
                                            $scope.rights = data
                                        });
                            });
                    $scope.addAdmin= function(){
                        $http.post('addAdmin')
                                .success(function (response) {
                                    if (response.length == 0) {
                                        document.getElementById('lbAdminID').innerHTML = 'Failed to add new admin! Please try again!';
                                    } else {
                                        document.getElementById('lbAdminID').innerHTML = 'Successfully added new admin!' + '<br>' + 'Assigned ID for New Admin = ' + response[0];
                                    }
                                });
                    };

                }]);
</script>
<style type="text/css">

    .modal-footer .btn-group button {
        height:40px;
        border-top-left-radius : 0;
        border-top-right-radius : 0;
        border: none;
        border-right: 1px solid #ddd;
    }

    .modal-footer .btn-group:last-child > button {
        border-right: 0;
    }
</style>
<head>
    <title>Add Admin</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container" ng-app="myApp">
    <div  ng-controller="HomeCtrl as hmectrl" >
        <jsp:include page="header.jsp" />
        <br><br>
        <form class="well span8 center-block" style="width: 500px; align-content: center" ng-submit="addAdmin()">
            <div class="admin_id">
                <span class="button-checkbox center-block" align="center">
                    <label id="lbAdminID"> </label>
                </span>
            </div>

            <button class="btn btn-primary center-block"  type="submit">Add New Admin</button>
        </form>

    </div>
</div>
</body>
</html>
