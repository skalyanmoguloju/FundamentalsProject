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
                                            //console.log(data);
                                            $scope.rights = data;
                                            $http.post('allorders', {id : user})
                                                    .success(function (data) {
                                                        //console.log(data);
                                                        var list = [];
                                                        var listOrShp = [];
                                                        for(var i =0; i< data.length; i++) {
                                                            if(data[i].status =="Purchased" || data[i].status =="Re-Purchased")
                                                            {
                                                                list.push(data[i]);
                                                            }
                                                            else{
                                                                //data[i].delivery_date= $filter('date')(data[i].delivery_date , "dd/MM/yyyy");
                                                                //data[i].purchase_date= $filter('date')(data[i].purchase_date , "dd/MM/yyyy");
                                                                //$scope.ordersShp.push(data[i]);
                                                                if (data[i].quantity == 0) {
                                                                    data[i].status = "Returned";
                                                                }
                                                                listOrShp.push(data[i])
                                                            }

                                                        }
                                                        $scope.groupOrdersByOrderNumber(list);

                                                        /* Group delivered orders */
                                                        $http.post('groupOrdersByOrderNumber', listOrShp)
                                                                .success(function (response) {
                                                                    $scope.listOrdersShp = response;
                                                                    console.log("List Orders Ship" + listOrShp[0].order_id);
                                                                    console.log(response);
                                                                });
                                                    });
                                            $http.post('retorders', {id : user})
                                                    .success(function (data) {
//                                                        for(var i =0; i< data.length; i++) {
//                                                            data[i].return_date = $filter('date')(data[i].return_date, "dd/MM/yyyy");
//                                                        }
                                                        $scope.returns = data;
                                                    });
                                        });
                            });

                    $scope.setAlternate = function(retrn) {
                        console.log(retrn.ordersBean.itemsBean.category);
                        $cookies.put("alternate", "true");
                        $cookies.put("catgVal", retrn.ordersBean.itemsBean.category);
                        window.location.href = "/home";
                    };
                    $scope.returnSubmit = function(order){
                        console.log(order);
                        $http.post('returnrequest', {
                            return_id : order.order_id,
                            return_count : order.returnCount,
                            description : order.returnDesc})
                                .success(function (data){
                                    alert("Return submitted, Thank you!!");
                                    location.reload();
                                });
                    };
                    $scope.groupOrdersByOrderNumber= function(purchasedOrders){
                        $http.post('groupOrdersByOrderNumber', purchasedOrders)
                                .success(function (response) {
                                    $scope.listOrders = response;
                                    console.log(response);
                                });
                    };
                    $scope.arrivalDate= function(order){
                        var date = new Date(order.materialIndentBean.indent_date);
                        var dateArrival = new Date();
                        var result = "";

                        if (order.itemsBean.size == "Small" | order.itemsBean.size == "small") {
                            dateArrival.setDate(date.getDate() + 1);
                            var arrivalDay = dateArrival.getDate();
                            var arrivalMonth = dateArrival.getMonth();
                            var arrivalYear = dateArrival.getFullYear();
                            result = (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
                            dateArrival.setDate(date.getDate() + 3);
                            arrivalDay = dateArrival.getDate();
                            arrivalMonth = dateArrival.getMonth();
                            arrivalYear = dateArrival.getFullYear();
                            result += " - " + (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
                        } else if (order.itemsBean.size == "Medium" | order.itemsBean.size == "medium") {
                            dateArrival.setDate(date.getDate() + 3);
                            arrivalDay = dateArrival.getDate();
                            arrivalMonth = dateArrival.getMonth();
                            arrivalYear = dateArrival.getFullYear();
                            result = (arrivalMonth+1) + "/" + arrivalDay + "/" + arrivalYear;
                            dateArrival.setDate(date.getDate() + 5);
                            arrivalDay = dateArrival.getDate();
                            arrivalMonth = dateArrival.getMonth();
                            arrivalYear = dateArrival.getFullYear();
                            result += " - " + (arrivalMonth+1) + "/" + arrivalDay + "/" + arrivalYear;
                        } else {
                            dateArrival.setDate(date.getDate() + 5);
                            arrivalDay = dateArrival.getDate();
                            arrivalMonth = dateArrival.getMonth();
                            arrivalYear = dateArrival.getFullYear();
                            result = (arrivalMonth+1) + "/" + arrivalDay + "/" + arrivalYear;
                            dateArrival.setDate(date.getDate() + 7);
                            arrivalDay = dateArrival.getDate();
                            arrivalMonth = dateArrival.getMonth();
                            arrivalYear = dateArrival.getFullYear();
                            result += " - " + (arrivalMonth+1) + "/" + arrivalDay + "/" + arrivalYear;
                        }

                        return result;
                    };
                    $scope.getDate= function(date) {
                        var d = new Date(date);
                        var result = (d.getMonth() + 1) + "/" + d.getDate() + "/" + d.getFullYear();
                        return result;
                    };
                    $scope.checkRes = function(ret) {
                        if (ret.resolution == "Product is out of stock, will update you when they are available") {
                            document.getElementById("alternativeIT" + ret.return_id).style.display = 'block';
                        }
                        return "";
                    };
                    $scope.checkReturnButton = function(order) {
                        if (order.quantity != 0) {
                            document.getElementById("returnID" + order.order_id).style.display = 'block';
                        }
                        return "";
                    };
                    $scope.checkQuantity = function(order) {
                        if (order.quantity != 0) {
                            document.getElementById("quantityID" + order.order_id).style.display = 'block';
                        }
                        return order.quantity;
                    }
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
                <li class="active"><a href="#red" data-toggle="tab">Purchased Orders</a></li>
                <li><a href="#orange" data-toggle="tab">Delivered Orders</a></li>
                <li><a href="#yellow" data-toggle="tab">Return Status</a></li>
            </ul>
            <div id="my-tab-content" class="tab-content" style="height: 500px" >
                <div class="tab-pane active" id="red">
                    <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "listOrders">
                        <article class="search-result row" ng-repeat = "orders in listOrders">
                            <form class="well span8">
                                <h4 style="text-align: center"><a data-toggle="modal" data-target="#squarespaceModal{{orders[0].order_id}}"  href="#" title=""><b>(Order Date: {{getDate(orders[0].materialIndentBean.indent_date)}}) - Order# {{orders[0].materialIndentBean.indent_id}}:</b></a></h4>
                                <br/>
                                <article class="search-result row" ng-repeat = "order in orders">
                                    <div class="col-xs-12 col-sm-12 col-md-3" style="height: 50px; width: 110px">
                                        <a href="#" title="{{order.itemsBean.item_name}}" class="thumbnail"><img src={{order.itemsBean.images}} style="height: 50px; width: 105px" alt="{{vw.itemsBean.item_name}}" /></a>
                                    </div>
                                    <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                                        <table style="width: 1000px;">
                                            <tr>

                                                <td style="width: 200px;" colspan="3">
                                                    <div class="modal fade" id="squarespaceModal{{order.order_id}}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                                                    <h3 class="modal-title" id="lineModalLabelRed">Information</h3>
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
                                                                                            <div class="form-group">
                                                                                                <label >
                                                                                                    Purchased Date</label>
                                                                                                <div class="input-group">
                                                                                                    <label class="form-control" >{{getDate(order.purchase_date)}}</label>
                                                                                                    <span class="input-group-addon"></span>
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
                                                                                                        <br/>
                                                                                                        <span><b>Phone: </b> {{order.materialIndentBean.addressBean.phone}}</span>
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
                                                <td style="width: 200px;">
                                                    <p><b>Estimated delivery</b> :<br/> {{arrivalDate(order)}}</p>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                    <hr>
                                    <br style="width: 850px"/>
                                </article>
                            </form>
                        </article>
                    </section>
                </div>

                <div class="tab-pane" id="orange">
                    <div id="accordion" class="panel-group">
                    <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "listOrdersShp">
                        <article class="search-result row" ng-repeat = "ordersShp in listOrdersShp">
                            <form class="well span8">
                                <h4 style="text-align: center" > <a data-toggle="modal" data-target="#squarespaceModal1{{ordersShp[0].order_id}}"  href="#" title=""><b>(Order Date: {{getDate(ordersShp[0].materialIndentBean.indent_date)}}) - Order# {{ordersShp[0].materialIndentBean.indent_id}}:</b></a></h4>
                                <br/>
                                <article class="search-result row" ng-repeat = "order in ordersShp">

                                    <div class="col-xs-12 col-sm-12 col-md-3" style="height: 50px; width: 110px">
                                        <a href="#" title="{{order.itemsBean.item_name}}" class="thumbnail"><img src={{order.itemsBean.images}} style="height: 50px; width: 105px" alt="{{vw.itemsBean.item_name}}" /></a>
                                    </div>
                                    <div class="col-xs-12 col-sm-12 col-md-7 excerpet" >
                                        <table style="width: 1050px;">
                                            <tr>

                                                <td style="width: 200px;" colspan="3">
                                                    <div class="modal fade" id="squarespaceModal1{{order.order_id}}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                                                    <h3 class="modal-title" id="lineModalLabelOrange">Information</h3>
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
                                                                                            <div class="form-group">
                                                                                                <label >
                                                                                                    Purchased Date</label>
                                                                                                <div class="input-group">
                                                                                                    <label class="form-control" >{{getDate(order.purchase_date)}}</label>
                                                                                                    <span class="input-group-addon"></span>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="form-group">
                                                                                                <label >
                                                                                                    Delivered Date</label>
                                                                                                <div class="input-group">
                                                                                                    <label class="form-control" >{{getDate(order.delivery_date)}}</label>
                                                                                                    <span class="input-group-addon"></span>
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
                                                                                                        <span><b>Phone: </b> {{order.materialIndentBean.addressBean.phone}}</span>
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
                                                <td id="quantityID{{order.order_id}}" style="width: 150px; display:none;">
                                                    <p><b>Quantity</b> : {{checkQuantity(order)}}</p>
                                                </td>
                                                <td style="width: 200px;">
                                                    <p><b>Status</b> : {{order.status}}</p>
                                                </td>

                                                <td style="width: 200px;">

                                                                <a id="returnID{{order.order_id}}" data-toggle="collapse" data-parent="#accordion" href="#znajomi{{order.order_id}}" style="display:none;">
                                                                    Return {{checkReturnButton(order)}}
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
                            </form>
                        </article>
                    </section>
                    </div>
                </div>
                <div class="tab-pane" id="yellow">
                    <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "returns">
                    <article class="search-result row" ng-repeat = "return in returns">
                        <div class="col-xs-12 col-sm-12 col-md-3" style="height: 50px; width: 110px">
                            <a href="#" title="{{return.ordersBean.itemsBean.item_name}}" class="thumbnail"><img src={{return.ordersBean.itemsBean.images}} style="height: 50px; width: 105px" alt="{{vw.itemsBean.item_name}}" /></a>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                            <table style="width: 1050px;">
                                <tr>

                                    <td style="width: 200px;" colspan="3">
                                        <div class="modal fade" id="squarespaceModal{{return.return_id}}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
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
                                                                                Return details
                                                                            </h3>

                                                                        </div>
                                                                        <div class="panel-body">
                                                                            <form role="form">
                                                                                <div class="form-group">
                                                                                    <label >
                                                                                        Email Id</label>
                                                                                    <div class="input-group">
                                                                                        <label class="form-control" >{{return.ordersBean.materialIndentBean.userBean.email}}</label>
                                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label >
                                                                                        Resolution</label>
                                                                                    <div class="input-group">
                                                                                        <label class="form-control" >{{return.resolution}}</label>
                                                                                        <span class="input-group-addon"></span>
                                                                                    </div>
                                                                                    <br/>
                                                                                    <div id="alternativeIT{{return.return_id}}" class="form-group" style="display:none;">
                                                                                        <button type="submit" ng-click="setAlternate(return)" class="btn btn-primary">View Alternative Items{{checkRes(return)}}</button>
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

                                        <h3 style="margin-top: 5px"><a data-toggle="modal" data-target="#squarespaceModal{{return.return_id}}"  href="#" title="">{{return.ordersBean.itemsBean.item_name}} : <small>{{return.order.itemsBean.category}}</small></a></h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <p><b>Reason</b> : {{return.description}}</p>
                                    </td>
                                    <td style="width: 350px;">
                                        <p><b>Returned Date</b> : {{getDate(return.return_date)}}</p>
                                    </td>
                                    <td style="width: 250px;">
                                        <p><b>Quantity</b> : {{return.return_count}}</p>
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
        </div>


    </div>

</div>
</body>
</html>
