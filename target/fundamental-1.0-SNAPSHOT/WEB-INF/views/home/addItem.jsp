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
                                        });
                            });
                    $scope.additem = function(){
                        console.log("here");
                        $http.post('addItem', {
                            item_name: $scope.name,
                            item_description:$scope.description,
                            onsale_count: $scope.stock,
                            price: $scope.price,
                            images: $scope.url,
                            category:$scope.category
                        })
                                .success(function (response) {
                                    console.log(response);
                                    console.log(response.length);
                                    if (response.length == 0) {
                                        document.getElementById('lbltipAddedComment').innerHTML = 'Error in Signing up!! Please try again';
                                    }
                                    else {
                                        if(response[0]=="Done") {
                                            document.getElementById('lbltipAddedComment').innerHTML = 'Successfully Signed Up';
                                            alert("Please verify your account by opening the link sent to your email and then try Signing in");
                                            window.location.href = "/"
                                        }
                                        else{
                                            alert("Email ID already exists!!!");
                                        }
                                    }
                                });
                    };

                }]);
</script>

<head>
    <title></title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container" ng-app="myApp">
    <jsp:include page="header.jsp" />
    <div ng-controller="HomeCtrl as hmectrl">
    <form class="well span8" style="width: 1100px; align-content: center" ng-submit="additem()">
        <div class="row">
            <div >
                <table>
                    <tr>
                        <td width="400px">
                            <label>Name</label>
                        </td>
                        <td>
                            <label>Description</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="span3" placeholder=
                                    "Name of the product" type="text" style="width: 350px" ng-model="name">
                        </td>
                        <td rowspan="7">
                            <textarea style="width: 500px" class="input-xlarge span5" id="message" name="message" rows="10" ng-model="description"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Price</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="span3" placeholder="Price in $" type="text" style="width: 350px" ng-model="price">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Avaliable Count</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="span3" placeholder=
                                    "Count of products for sale" type="text" style="width: 350px" ng-model="stock">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Category</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select class="span3" id="subject" name="subject" style="width: 350px" ng-model="category">
                                <option selected value="na">
                                    Choose One:
                                </option>

                                <option value="Computer">
                                    Computer
                                </option>

                                <option value="Printer ">
                                    Printer
                                </option>

                                <option value="Scanner">
                                    Scanner
                                </option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Image URL</label>
                        </td>
                        <td>
                            <input class="span3" placeholder=
                                    "Image URL" type="text" style="width: 500px" ng-model="url">
                        </td>
                        </td>
                    </tr>

                </table>
            </div>

            <button class="btn btn-primary pull-right" type=
                "submit">Add Item</button>
        </div>
    </form>
    </div>
</div>
</body>
</html>
