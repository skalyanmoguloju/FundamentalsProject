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
                        if($scope.validateForm() == true) {
                            console.log("here");
                            document.getElementById('lbltipAddedComment').innerHTML = '';
                            $http.post('addItem', {
                                    item_name: $scope.name,
                                    item_description: $scope.description,
                                    onsale_count: $scope.stock,
                                    price: $scope.price,
                                    images: $scope.url,
                                    category: $scope.category,
                                    user_id: $scope.userInfo.id,
                                    size: $scope.size
                                    })
                                    .success(function (response) {
                                        console.log(response);
                                        if (response.length == 0) {
                                            document.getElementById('lbltipAddedComment').innerHTML = 'Error in adding item! Please try again';
                                        } else {
                                            alert("Successfully added item named '" + response[0] + "' !");
                                            window.location.href = "/add item";
                                        }

                                    });
                        }
                    };
                    $scope.validateForm = function() {

                        /* Check Name */
                        if($scope.name == "" || $scope.name == undefined)
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Name of the product cannot be empty';
                            return false;
                        }
                        /* Check Price */
                        if($scope.price == "" || $scope.price == undefined)
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Price cannot be empty';
                            return false;
                        }
                        if (document.getElementById("price").value.match(/^[0]+[.]?[0]*$/)) {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Price cannot be 0';
                            return false;
                        }
                        if (!document.getElementById("price").value.match(/^[0-9]+[0-9]*$/)) {
                            if (document.getElementById("price").value.match(/^[0-9]+[.][0-9][0-9][0-9]+$/)) {
                                document.getElementById('lbltipAddedComment').innerHTML = 'Price can only have maximum of 2 decimal points';
                                return false;
                            }
                            if (!document.getElementById("price").value.match(/^[0-9]+[.][0-9][0-9]?$/)) {
                                document.getElementById('lbltipAddedComment').innerHTML = 'Wrong format! Price must be integer or decimal number';
                                return false;
                            }
                        }

                        /* Check Available Count */
                        if($scope.stock == "" || $scope.stock == undefined)
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Available Count cannot be empty';
                            return false;
                        }
                        if (document.getElementById("available_count").value.match(/^[0]+$/)) {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Available Count cannot be 0';
                            return false;
                        }
                        if (!document.getElementById("available_count").value.match(/^[0]*[1-9][0-9]*$/)) {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Available Count must be an integer number';
                            return false;
                        }

                        /* Check Category */
                        if($scope.category == undefined)
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Please choose category';
                            return false;
                        }
                        if(document.getElementById("subject").value == 'na')
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Please choose a correct category';
                            return false;
                        }

                        /* Check Size */
                        if($scope.size == undefined)
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Please choose a size';
                            return false;
                        }
                        if(document.getElementById("size").value == 'na')
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Please choose a correct size';
                            return false;
                        }

                        /* Check Image URL */
                        if($scope.url == "" || $scope.url == undefined)
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Image URL cannot be empty';
                            return false;
                        }

                        /* Check Description */
                        if($scope.description == "" || $scope.description == undefined)
                        {
                            document.getElementById('lbltipAddedComment').innerHTML = 'Description cannot be empty';
                            return false;
                        }

                        return true;
                    }

                }]);
</script>

<head>
    <title>Add New Item</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container" ng-app="myApp">
    <div ng-controller="HomeCtrl as hmectrl">
        <jsp:include page="header.jsp" />
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
                            <input id="price" class="span3" placeholder="Price in $" type="text" style="width: 350px" ng-model="price">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Available Count</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input id="available_count" class="span3" placeholder=
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
                                <option value="na" selected>
                                    Choose One:
                                </option>

                                <option value="Computer">
                                    Computer
                                </option>

                                <option value="Printer">
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
                            <label>Size</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select class="span3" id="size" name="size" style="width: 350px" ng-model="size">
                                <option value="na" selected>
                                    Choose One:
                                </option>

                                <option value="Small">
                                    Small
                                </option>

                                <option value="Medium">
                                    Medium
                                </option>

                                <option value="Large">
                                    Large
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
        <span class="button-checkbox center-block" align="center" style='color:#FF0000'>
            <label id="lbltipAddedComment"></label>
        </span>
    </form>
    </div>
</div>
</body>
</html>
