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
                    $scope.orders = [];
                    $scope.ordersShp = [];
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
                                                        for(var i =0; i< data.length; i++) {
                                                            console.log(data[i])
                                                            if(data[i].status =="Purchased")
                                                            {
                                                                $scope.orders.push(data[i]);
                                                            }
                                                            else{
                                                                $scope.ordersShp.push(data[i]);
                                                            }

                                                        }


                                                    });
                                        });
                            });
                    $scope.returnSubmit = function(order){
                        console.log(order);
                        $http.post('returnrequest', {
                            return_id : order.order_id,
                            return_count : order.returnCount,
                            description : order.returnDesc})
                                .success(function (data){

                                });
                    };


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
        <div style="margin-top: 50px">
            <ul id="tabs" class="nav nav-tabs" style="margin-left: 0px;left: 150px; top: 100px" data-tabs="tabs">
                <li class="active"><a href="#red" data-toggle="tab">Purshased Orders</a></li>
                <li><a href="#orange" data-toggle="tab">Delivered Orders</a></li>
                <li><a href="#yellow" data-toggle="tab">Return Status</a></li>
            </ul>
            <div id="my-tab-content" class="tab-content" style="height: 500px" >
                <div class="tab-pane active" id="red">
                    <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "orders">
                        <article class="search-result row" ng-repeat = "order in orders">
                            <div class="col-xs-12 col-sm-12 col-md-3" style="height: 50px; width: 110px">
                                <a href="#" title="{{order.itemsBean.item_name}}" class="thumbnail"><img src="{{order.itemsBean.images}}" style="height: 50px; width: 105px" alt="{{vw.itemsBean.item_name}}" /></a>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                                <table style="width: 850px;">
                                    <tr>

                                        <td style="width: 200px;" colspan="3">
                                            <div class="modal fade" id="squarespaceModal{{order.order_id}}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                                            <h3 class="modal-title" id="lineModalLabel">Information</h3>
                                                        </div>
                                                        <div class="modal-body">

                                                            <!-- content goes here -->
                                                            <form ng-submit = "orderUp(vw)">

                                                                <div class="form-group">
                                                                    <div>
                                                                        <div class="panel panel-default">
                                                                            <div class="panel-heading">
                                                                                <h3 class="panel-title">
                                                                                    Order details
                                                                                </h3>

                                                                            </div>
                                                                            <div class="panel-body">
                                                                                <form role="form">
                                                                                    <div class="form-group">
                                                                                        <label >
                                                                                            Email Id</label>
                                                                                        <div class="input-group">
                                                                                            <label class="form-control" >{{order.materialIndentBean.userBean.email}}</label>
                                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label >
                                                                                            Total price</label>
                                                                                        <div class="input-group">
                                                                                            <label class="form-control" >{{order.materialIndentBean.price}}</label>
                                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-usd"></span></span>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="row">
                                                                                        <div class="col-xs-7 col-md-7">
                                                                                            <div class="form-group">
                                                                                                <label>
                                                                                                    Shipping address</label>
                                                                                                <br/>
                                                                                                <span><b>Address line 1: </b> {{order.materialIndentBean.addressBean.line1}}</span>
                                                                                                <br/>
                                                                                                <span><b>Address line 2: </b> {{order.materialIndentBean.addressBean.line2}}</span>
                                                                                                <br/>
                                                                                                <span><b>City: </b> {{order.materialIndentBean.addressBean.city}}</span>
                                                                                                <br/>
                                                                                                <span><b>State: </b> {{order.materialIndentBean.addressBean.state}}<b> Zip: </b> {{order.materialIndentBean.addressBean.zip}}</span>
                                                                                            </div>
                                                                                        </div>

                                                                                    </div>
                                                                                </form>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </form>

                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                            <h3 style="margin-top: 5px"><a data-toggle="modal" data-target="#squarespaceModal{{order.order_id}}"  href="#" title="">{{order.itemsBean.item_name}} : <small>{{order.itemsBean.category}}</small></a></h3>
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
                <div class="tab-pane" id="orange">
                    <div id="accordion" class="panel-group">
                    <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "ordersShp">
                        <article class="search-result row" ng-repeat = "order in ordersShp">

                            <div class="col-xs-12 col-sm-12 col-md-3" style="height: 50px; width: 110px">
                                <a href="#" title="{{order.itemsBean.item_name}}" class="thumbnail"><img src="{{order.itemsBean.images}}" style="height: 50px; width: 105px" alt="{{vw.itemsBean.item_name}}" /></a>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-7 excerpet" >
                                <table style="width: 850px;">
                                    <tr>

                                        <td style="width: 200px;" colspan="3">
                                            <div class="modal fade" id="squarespaceModal1{{order.order_id}}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                                            <h3 class="modal-title" id="lineModalLabel">Information</h3>
                                                        </div>
                                                        <div class="modal-body">

                                                            <!-- content goes here -->
                                                            <form ng-submit = "orderUp(vw)">

                                                                <div class="form-group">
                                                                    <div>
                                                                        <div class="panel panel-default">
                                                                            <div class="panel-heading">
                                                                                <h3 class="panel-title">
                                                                                    Order details
                                                                                </h3>

                                                                            </div>
                                                                            <div class="panel-body">
                                                                                <form role="form">
                                                                                    <div class="form-group">
                                                                                        <label >
                                                                                            Email Id</label>
                                                                                        <div class="input-group">
                                                                                            <label class="form-control" >{{order.materialIndentBean.userBean.email}}</label>
                                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label >
                                                                                            Total price</label>
                                                                                        <div class="input-group">
                                                                                            <label class="form-control" >{{order.materialIndentBean.price}}</label>
                                                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-usd"></span></span>
                                                                                        </div>
                                                                                    </div>

                                                                                    <div class="row">
                                                                                        <div class="col-xs-7 col-md-7">
                                                                                            <div class="form-group">
                                                                                                <label>
                                                                                                    Shipping address</label>
                                                                                                <br/>
                                                                                                <span><b>Address line 1: </b> {{order.materialIndentBean.addressBean.line1}}</span>
                                                                                                <br/>
                                                                                                <span><b>Address line 2: </b> {{order.materialIndentBean.addressBean.line2}}</span>
                                                                                                <br/>
                                                                                                <span><b>City: </b> {{order.materialIndentBean.addressBean.city}}</span>
                                                                                                <br/>
                                                                                                <span><b>State: </b> {{order.materialIndentBean.addressBean.state}}<b> Zip: </b> {{order.materialIndentBean.addressBean.zip}}</span>
                                                                                            </div>
                                                                                        </div>

                                                                                    </div>
                                                                                </form>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </form>

                                                        </div>

                                                    </div>
                                                </div>
                                            </div>


                                            <h3 style="margin-top: 5px"><a data-toggle="modal" data-target="#squarespaceModal1{{order.order_id}}"  href="#" title="">{{order.itemsBean.item_name}} : <small>{{order.itemsBean.category}}</small></a></h3>
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
                                        <td style="width: 200px;">

                                                        <a data-toggle="collapse" data-parent="#accordion" href="#znajomi{{order.order_id}}">
                                                            Return
                                                        </a>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">
                                        <div id="znajomi{{order.order_id}}" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="number" class="form-control" placeholder="Number of returned products (delivered {{order.quantity}})" required  ng-model="order.returnCount"/>
                                                        </div>
                                                        <div class="form-group">
                                                            <textarea class="form-control" placeholder="Description of the issue" required ng-model="order.returnDesc"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="well well-sm well-primary">
                                                            <form class="form form-inline " role="form">
                                                                <div class="form-group">
                                                                    <input class="btn btn-success btn-sm" type="button" value="Submit" ng-click="returnSubmit(order)">

                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
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
                <div class="tab-pane" id="yellow">
                    <h1>Yellow</h1>
                    <p>yellow yellow yellow yellow yellow</p>
                </div>

            </div>
        </div>

    </div>

</div>
</body>
</html>
