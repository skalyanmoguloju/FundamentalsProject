<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                                var date = new Date();
                                $scope.userInfo = response[0];
                                $scope.userInfo.dob= $filter('date')(response[0].dob , "dd/MM/yyyy");
                                $http.post('rights', {role: response[0].role})
                                        .success(function (data) {
                                            $scope.rights = data
                                            $http.post('list')
                                                    .success(function (data) {
                                                        $scope.list = data;
                                                        console.log($scope.list);

                                                    });
                                        });

                            });
                    $scope.orderUp= function(vw){;
                        console.log(vw);
                        $http.post('order', {
                            item_id: vw.item_id,
                            user_id:$scope.userInfo.id,
                            price: vw.price,
                            quantity: vw.noofpieces,
                            card_number: vw.cardNo,
                            exp_date:vw.dateExp,
                            card_cvv:vw.cvvNo
                        })
                                .success(function (response) {
                                    console.log(response);

                                });
                    };


                }]);
</script>
<style type="text/css">
    .center {
        margin-top:50px;
    }

    .modal-header {
        padding-bottom: 5px;
    }

    .modal-footer {
        padding: 0;
    }

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
    <title></title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<div class="container" ng-app="myApp">

    <div  ng-controller="HomeCtrl as hmectrl" >
        <jsp:include page="header.jsp" />
        <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "list">
            <article class="search-result row" ng-repeat = "vw in list">
                <div class="col-xs-12 col-sm-12 col-md-3">
                    <a href="#" title="{{vw.item_name}}" class="thumbnail"><img src="{{vw.images}}" style="height: 150px; width: 300px" alt="{{vw.item_name}}" /></a>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-2">
                    <ul class="meta-search">
                        <li><i class="glyphicon glyphicon-usd"></i> <span> {{vw.price}}</span></li>
                        <li><i class="glyphicon glyphicon-time"></i> <span>Posted Date {{vw.data}}</span></li>
                        <li><i class="glyphicon glyphicon-asterisk"></i> <span>Available {{vw.onsale_count}}</span></li>
                        <li><i class="glyphicon glyphicon-check"></i> <span>Total Sold {{vw.sold_count}}</span></li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                    <h3><a href="#" title="">{{vw.item_name}}</a></h3>
                <p>{{vw.item_description}}</p>
                    <div class="center"><button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Purchase</button></div>
                    <div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                    <h3 class="modal-title" id="lineModalLabel">Payment</h3>
                                </div>
                                <div class="modal-body">

                                    <!-- content goes here -->
                                    <form ng-submit = "orderUp(vw)">
                                        <div class="form-group" >
                                            <label for="exampleInputEmail1">Email address</label>
                                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email" ng-model="vw.purchaseemialId">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Number of products</label>
                                            <input type="number" class="form-control" id="exampleInputPassword1" placeholder="Available {{vw.onsale_count}}" ng-model="vw.noofpieces">
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h3 class="panel-title">
                                                            Payment Details
                                                        </h3>

                                                    </div>
                                                    <div class="panel-body">
                                                        <form role="form">
                                                            <div class="form-group">
                                                                <label for="cardNumber">
                                                                    CARD NUMBER</label>
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                                                           required autofocus ng-model="vw.cardNo"/>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-xs-7 col-md-7">
                                                                    <div class="form-group">
                                                                        <label for="expityMonth">
                                                                            EXPIRY DATE</label>
                                                                            <input type="text" class="form-control" id="expityMonth" placeholder="MM/YY" required ng-model="vw.dateExp"/>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-5 col-md-5 pull-right">
                                                                    <div class="form-group">
                                                                        <label for="cvCode">
                                                                            CV CODE</label>
                                                                        <input type="password" class="form-control" id="cvCode" placeholder="ex. 123" required ng-model="vw.cvvNo"/>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                    <ul>
                                                    <li class="active"><a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon-usd"></span>{{vw.price * vw.noofpieces}}</span> Final Payment</a>
                                                    </li>
                                                </ul>

                                                <input type="hidden" value="{{vw.price * vw.noofpieces}}" ng-model="vw.totalPrice">
                                                <br/>
                                                <button type="submit" class="btn btn-success btn-lg btn-block" role="button">Pay</button>
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
