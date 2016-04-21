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

            .controller('HomeCtrl', ['$scope', '$rootScope','$http','$cookies','$filter',
                function ($scope, $rootScope,$http,$cookies,$filter) {
                    console.log("jj");
                    var user = $cookies.get("user").toString();
                    //console.log(user.toString());
                    $http.post('userInfo', {id: user})
                            .success(function (response) {
                                console.log(response);
                                console.log(response.length);
                                var date = new Date();
                                $scope.userInfo = response[0];
                                $scope.userInfo.dob= $filter('date')(response[0].dob , "dd/MM/yyyy");
                                $http.post('rights', {role: response[0].role})
                                        .success(function (data) {
                                            console.log(data);
                                            $scope.rights = data;
                                            document.getElementById('welcome').innerHTML = 'Welcome! ' + $scope.userInfo.name + ' ' + $scope.userInfo.lname;
                                            $scope.newManagerNotification();
                                        });
                            });
                    $scope.validateEmail = function(val){
                        console.log(val);
                        console.log("kks");
                        return true;
                    };
                    $scope.newManagerNotification = function(){
                        if ($scope.userInfo.role == "Admin") {
                            document.getElementById('notificationHeader').style.display = 'block';
                            $scope.listNewManagers();
                        }
                    };
                    $scope.listNewManagers= function(){
                        $http.post('listNewManagers')
                                .success(function (data) {
                                    $scope.list = data;
                                    if (data.length == 0) {
                                        document.getElementById('notification').innerHTML = "You have no notifications!";
                                        document.getElementById('notificationBody').style.display = 'none';
                                    } else if (data.length == 1) {
                                        document.getElementById('notification').innerHTML = "You have 1 notification!";
                                        document.getElementById('notificationBody').style.display = 'block';
                                    }
                                    else {
                                        document.getElementById('notification').innerHTML = "You have " + data.length + " notifications!";
                                        document.getElementById('notificationBody').style.display = 'block';
                                    }
                                });
                    };
                    $scope.approveManager = function(id){
                        $http.post('approveManager', id)
                                .success(function (response) {
                                    if (response == null || response == "" || response == undefined) {
                                        alert("Something is wrong! please try again!");
                                    } else {
                                        alert("Successfully Approve manager No." + response + "!");
                                    }
                                    window.location.href = "/home";
                                });
                    };
                    $scope.declineManager = function(id){
                        $http.post('declineManager', id)
                                .success(function (response) {
                                    if (response == null || response == "" || response == undefined) {
                                        alert("Something is wrong! please try again!");
                                    } else {
                                        alert("Successfully Decline manager No." + response + "!");
                                    }
                                    window.location.href = "/home";
                                });
                    };
                }]);
</script>

<head>
    <title>Home</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container" ng-app="myApp">
    <div ng-controller="HomeCtrl as hmectrl">
        <jsp:include page="header.jsp" />
        <h4 align="center"><label id="welcome"> </label></h4>
        <div id = "notificationHeader" class="well" style="width: 400px; text-align: center; margin-left: 700px; display:none;">
            <h4><b style='color:#FF0000'>Notifications:</b></h4>
            <label id="notification"> </label>
        </div>

        <div id="notificationBody" style="height:430px;width:400px;margin-left: 700px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto; display:none;">
            <section class="col-xs-12 col-sm-6 col-md-20" style="width: 400px" ng-model = "list">
                <article class="row" ng-repeat = "vw in list">
                    <article id="approveManager{{vw.id}}" class="well span8 center-block">
                        <h5>Manager No.{{vw.id}}'s Info:</h5>
                        <ul>
                            <li><span>ID: {{vw.id}}</span></li>
                            <li><span>Name: {{vw.lname}}, {{vw.name}}</span></li>
                            <li><span>Email: {{vw.email}}</span></li>
                        </ul>
                        <h4 style="text-align: center"><b style='color:#FF0000'>Do you want to approve this manager?</b></h4>
                        <div class="row">
                            <form ng-submit="approveManager(vw.id)">
                                <input type="submit" class="btn btn-success center-block" value="Approve">
                            </form>
                            <form ng-submit="declineManager(vw.id)">
                                <input type="submit" class="btn btn-primary center-block" value="Decline">
                            </form>
                        </div>
                    </article>
                </article>
            </section>
        </div>

    </div>
</div>
</body>
</html>
