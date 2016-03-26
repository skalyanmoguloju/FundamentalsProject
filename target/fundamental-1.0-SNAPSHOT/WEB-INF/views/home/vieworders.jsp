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
                                            $http.post('allorders', {id : user})
                                                    .success(function (data) {
                                                        $scope.orders = data;
                                                        console.log($scope.orders);

                                                    });
                                        });
                            });



                }]);
</script>

<head>
    <title>Orders</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body style="background: none">
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container" ng-app="myApp">
    <div ng-controller="HomeCtrl as hmectrl">
        <jsp:include page="header.jsp" />
        <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "orders">
            <article class="search-result row" ng-repeat = "order in orders">
                <div class="col-xs-12 col-sm-12 col-md-3" style="height: 50px; width: 110px">
                    <a href="#" title="{{order.itemsBean.item_name}}" class="thumbnail"><img src="{{order.itemsBean.images}}" style="height: 50px; width: 105px" alt="{{vw.itemsBean.item_name}}" /></a>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                    <table style="width: 850px;">
                        <tr>

                            <td style="width: 200px;" colspan="3">
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
                                                                <li class="active"><a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon-usd"></span>{{total}}</span> Final Payment</a>
                                                                </li>
                                                            </ul>

                                                            <br/>
                                                            <button type="submit" class="btn btn-success btn-lg btn-block" role="button">Pay</button>
                                                        </div>
                                                    </div>
                                                </form>

                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <h3 style="margin-top: 5px"><a data-toggle="modal" data-target="#squarespaceModal"  href="#" title="">{{order.itemsBean.item_name}} : <small>{{order.itemsBean.category}}</small></a></h3>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p><b>Description</b> : {{order.itemsBean.item_description}}</p>
                            </td>
                            <td style="width: 150px;">
                                 <p><b>Quantity</b> : {{order.quantity}}</p>
                            </td>
                            <td style="width: 200px;">
                                <p><b>Status</b> : {{order.status}}</p>
                            </td>
                        </tr>
                    </table>
                </div>
                <hr>
                <br style="width: 850px"/>
            </article>





        </section>
    </div>

</div>
</body>
</html>
