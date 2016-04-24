<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script>
    angular.module('myApp', ['ngCookies'])
            .controller('HomeCtrl', ['$scope', '$rootScope','$http','$cookies','$filter',
                function ($scope, $rootScope,$http,$cookies,$filter) {
                    $scope.catg  = "All";
                    $scope.searchBool = false;
                    var user = $cookies.get("user").toString();
                    //console.log(user.toString());
                    $scope.searchBool = false;
                    $http.post('userInfo', {id: user})
                            .success(function (response) {
                                var date = new Date();
                                $scope.userInfo = response[0];
                                $scope.userInfo.dob = $filter('date')(response[0].dob, "dd/MM/yyyy");
                                $http.post('rights', {role: response[0].role})
                                        .success(function (data) {
                                            $scope.rights = data;
                                            $http.post('list')
                                                    .success(function (data) {
                                                        $scope.list = data;
                                                        console.log($scope.list);
                                                    });
                                            $http.post('catList')
                                                    .success(function (response) {
                                                        $scope.Catgs = response;
                                                    });
                                        });
                            });
                    $scope.viewInventory = function () {
                        $http.post('list')
                                .success(function (other) {
                                    $scope.list = other;
                                    console.log($scope.list);
                                });
                    };
                    $scope.update = function()
                    {
                        $scope.searchTerm = "";
                        $http.post('catgResults', {
                            category:$scope.catg
                        })
                                .success(function (response) {
                                    $scope.searchBool = false;
                                    $scope.list = response;
                                    console.log($scope.list);
                                });


                    };
                    $scope.cart= function(vw) {
                        console.log(vw);

                        var available = vw.onsale_count - vw.sold_count;
                        /* Check number of products */
                        if (available == 0) {
                            document.getElementById('lbltipAddedComment' + vw.item_id).innerHTML = 'Product "' + vw.item_name + '" is out of stock! Please select a different product!';
                        } else if (document.getElementById('exampleInputPassword1' + vw.item_id).value.match(/^[-]?[0]+$/)) {
                            document.getElementById('lbltipAddedComment' + vw.item_id).innerHTML = 'Number of products cannot be 0';
                        } else if (document.getElementById("exampleInputPassword1" + vw.item_id).value < 0) {
                            document.getElementById('lbltipAddedComment' + vw.item_id).innerHTML = 'Number of products must be a positive integer';
                        } else if (!document.getElementById("exampleInputPassword1" + vw.item_id).value.match(/^[0]*[1-9]+$/)) {
                            document.getElementById('lbltipAddedComment' + vw.item_id).innerHTML = 'Number of products must be an integer';
                        } else if (document.getElementById("exampleInputPassword1" + vw.item_id).value > available) {
                            document.getElementById('lbltipAddedComment' + vw.item_id).innerHTML = 'Number of available products is only ' + available + ', Please select a number at most ' + available + '!';
                        } else {
                            $http.post('addCart', {
                                itemsBean: vw,
                                user_id: $scope.userInfo.id,
                                quantity: vw.noofpieces,
                                price: vw.price
                            })
                                    .success(function (response) {
                                        console.log(response);
                                        alert("Successfully added item with quantity of " + vw.noofpieces + " to cart !");
                                        window.location.href = "/view";
                                    });
                        }
                    };
                    $scope.search = function (searchTerm) {
                        $scope.searchBool = true;
                        console.log(searchTerm);
                        if (searchTerm != "") {
                            $http.post('listResults', {
                                item_name:searchTerm,
                                category:$scope.catg
                            })
                                    .success(function (response) {
                                        $scope.searchBool = false;
                                        $scope.list = response;
                                        console.log($scope.list);
                                    });
                        } else {
                            $scope.searchBool = false;
                            $scope.viewInventory();
                        }

                    };
                }]);
</script>
<head>
    <title>View Items</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<div class="container" ng-app="myApp">

    <div  ng-controller="HomeCtrl as hmectrl" >
        <jsp:include page="header.jsp" />
        <!DOCTYPE html>
        <html>
        <body>
        <div id="tfheader" style="background-color: #f5f5f5">
            <form id="tfnewsearch" ng-submit="search(searchTerm)" style="width: 1140px">
                <table>
                    <tr>
                        <td style="width: 250px">
                            <select name="role" value="" class="form-control input-lg" ng-model = "catg" ng-change="update()" style="height: 28px">
                                    <option value="All" selected>All</option>
                                    <option id="{{rol}}" ng-repeat="cat in Catgs" value="{{cat}}">{{cat}}</option>

                            </select>
                        </td>
                        <td>
                            <input type="text" id="tfq2b" class="tftextinput2" name="q" size="100" maxlength="120" value="Search our inventory" placeholder="Search our inventory" ng-model="searchTerm">
                            <input type="submit" value="Search" class="tfbutton2">
                        </td>
                    </tr>
                </table>


            </form>
            <div class="tfclear"></div>
        </div>
        </body>
        </html>

        <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "list" ng-hide="searchBool">
            <article class="search-result row" ng-repeat = "vw in list">

                <div class="col-xs-12 col-sm-12 col-md-3">
                    <a href="#" title="{{vw.item_name}}" class="thumbnail"><img src="{{vw.images}}" style="height: 150px; width: 300px" alt="{{vw.item_name}}" /></a>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-2">
                    <ul class="meta-search">
                        <li><i class="glyphicon glyphicon-usd"></i> <span> {{vw.price}}</span></li>
                        <li><i class="glyphicon glyphicon-time"></i> <span>Posted Date {{vw.data}}</span></li>
                        <li><i class="glyphicon glyphicon-asterisk"></i> <span>Available {{vw.onsale_count - vw.sold_count}}</span></li>
                        <li><i class="glyphicon glyphicon-check"></i> <span>Total Sold {{vw.sold_count}}</span></li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                    <h3><a href="#" title="">{{vw.item_name}}</a></h3>
                    <p>{{vw.item_description}}</p>
                    <div class="center"><button data-toggle="modal" data-target="#squarespaceModal{{vw.item_id}}" class="btn btn-primary center-block">Add to cart</button></div>
                    <div class="modal fade" id="squarespaceModal{{vw.item_id}}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                    <h3 class="modal-title" id="lineModalLabel">Add to cart</h3>
                                </div>
                                <div class="modal-body">

                                    <!-- content goes here -->
                                    <form ng-submit = "cart(vw)">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1{{vw.item_id}}">Number of products (available {{vw.onsale_count - vw.sold_count}})</label>
                                            <input type="number" class="form-control" id="exampleInputPassword1{{vw.item_id}}" value="1" ng-model="vw.noofpieces">
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <span class="button-checkbox center-block" align="center" style='color:#FF0000'>
                                                    <label id="lbltipAddedComment{{vw.item_id}}"></label>
                                                </span>

                                                <ul>
                                                    <li class="active"><a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon-usd"></span>{{vw.price * vw.noofpieces}}</span> Total Price</a>
                                                    </li>
                                                </ul>
                                                <input type="hidden" value="{{vw.price * vw.noofpieces}}" ng-model="vw.totalPrice">
                                                <br/>
                                                <button type="submit" class="btn btn-success btn-lg btn-block" role="button">Submit</button>
                                            </div>
                                        </div>
                                    </form>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <span class="clearfix borda"></span>
            </article>
        </section>
    </div>
</div>
</body>
</html>
