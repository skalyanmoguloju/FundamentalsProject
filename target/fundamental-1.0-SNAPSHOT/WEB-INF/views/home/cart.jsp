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
<script type="text/javascript" src="http://janssen.npdev.de/typo3conf/ext/npt3theme/Resources/Public/Javascript/validator.min.js"></script>
<script>
    angular.module('myApp', ['ngCookies'])

            .controller('HomeCtrl', ['$scope', '$rootScope','$http','$cookies','$filter',
                function ($scope, $rootScope,$http,$cookies,$filter) {
                    var user = $cookies.get("user").toString();
                    //console.log(user.toString());
                    $scope.total = 0;
                    $scope.junkvalue = 0;
                    $http.post('userInfo', {id: user})
                            .success(function (response) {
                                var date = new Date();
                                $scope.userInfo = response[0];
                                $scope.userInfo.dob= $filter('date')(response[0].dob , "dd/MM/yyyy");
                                $http.post('rights', {role: response[0].role})
                                        .success(function (data) {
                                            $scope.rights = data;
                                        });
                            });
                    $http.post('getCart', {id : user})
                            .success(function (responseCart){
                                console.log(responseCart);
                                $scope.cart = responseCart;
                                for (var i=0; i<$scope.cart.length; i++){
                                    if ($scope.cart[i].quantity > 0) {
                                        $scope.total = $scope.total+($scope.cart[i].itemsBean.price * $scope.cart[i].quantity);
                                    }
                                }
                            });
                    $scope.checkOut = function() {
                        if ($scope.validateQuantity() == true) {
                            if ($scope.cart.length == 0) {
                                document.getElementById('lbltipAddedComment').innerHTML = 'You have no products in Cart, cannot checkout!';
                            } else {
                                // trigger modal popup
                                $http.post('userAddress', {id: user})
                                        .success(function (responseAddress) {
                                            console.log(responseAddress)
                                            $scope.address = responseAddress;
                                        });
                                $('#AddressModal').modal('show');
                            }
                        }
                    };
                    $scope.updateAddress = function(addid){
                        $scope.shipaddress = addid;
                        $('#AddressModal').modal('hide');
                        $('#squarespaceModal').modal('show');
                    };
                    $scope.orderUp= function(vw){
                        console.log(vw);
                        if ($scope.validateCard() == true) {
                            var order = $scope.cart;
                            $http.post('order1', {
                                id:$scope.userInfo.id
                            });
                            console.log($scope.shipaddress)
                            $http.post('order2', {
                                address_Id:$scope.shipaddress.address_Id
                            });
                            var date = new Date();

                            $http.post('order', {
                                    item_id: vw.item_id,
                                    UserBean: $scope.userInfo,
                                    price: $scope.total,
                                    quantity: vw.noofpieces,
                                    card_number: vw.cardNo,
                                    card_exp: vw.dateExp,
                                    card_cvv: vw.cvvNo,
                                    indent_date: date

                            })
                                .success(function (response) {
                                    console.log(response);

                                    /* Update sold_count for each purchased product */
                                    for (var i=0; i<order.length; i++) {
                                        $scope.updateSoldCount(order[i]);
                                    }
                                    alert("Congratulations!\n You've successfully completed the purchase!");
                                    window.location.href = "/home";

                                    /* send email notification for new order */
                                    $http.post('newOrderEmailNotification', {
                                                indent_id: response[0],
                                                user_id: $scope.userInfo.id,
                                                price: $scope.total,
                                                card_number: vw.cardNo,
                                                card_exp: vw.dateExp,
                                                card_cvv: vw.cvvNo,
                                                indent_date: date
                                            })
                                            .success(function (response) {
                                                console.log(response);
                                            });

                                });
                        }
                    };
                    $scope.validateCard = function() {

                        /* Check Card Number */
                        if (document.getElementById('cardNumber').value == "" || document.getElementById('cardNumber').value == undefined) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'Card Number cannot be empty';
                            return false;
                        }
                        if (!document.getElementById('cardNumber').value.match(/^[0-9]+$/)) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'Card Number must contain only numbers';
                            return false;
                        }
                        if (document.getElementById('cardNumber').value.length > 16 || document.getElementById('cardNumber').value.length < 16) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'Card Number must be 16-digit number';
                            return false;
                        }
                        /* Check Exp Date */
                        if (document.getElementById('expityDate').value.match(/^[0][0][/][0-9][0-9]$/) || document.getElementById('expityDate').value.match(/^(([1][3-9])|([2-9][0-9]))[/][0-9][0-9]$/)) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'EXP Month is not valid';
                            return false;
                        }
                        if (!document.getElementById('expityDate').value.match(/^(([0][1-9])|([1][0-2]))[/][0-9][0-9]$/)) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'EXP Year is not valid';
                            return false;
                        }
                        var twoDigitsCurrentMonth = parseInt(new Date().getMonth());
                        var twoDigitsCurrentYear = parseInt(new Date().getFullYear().toString().substr(2,2));
                        var month = parseInt(document.getElementById('expityDate').value.split("/")[0]);
                        var year = parseInt(document.getElementById('expityDate').value.split("/")[1]);
                        if (twoDigitsCurrentYear > year || (twoDigitsCurrentMonth > month && twoDigitsCurrentYear == year)) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'Card has expired';
                            return false;
                        }

                        /* Check CVV Code */
                        if (document.getElementById('cvCode').value == "" | document.getElementById('cvCode').value == undefined) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'CVV Code cannot be empty';
                            return false;
                        }
                        if (!document.getElementById('cvCode').value.match(/^[0-9]+$/)) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'CVV code must contain only numbers';
                            return false;
                        }
                        if (document.getElementById('cvCode').value.length != 3 && document.getElementById('cvCode').value.length != 4) {
                            document.getElementById('lbltipAddedCommentCard').innerHTML = 'CVV code must be 3-digit number or 4-digit number';
                            return false;
                        }

                        document.getElementById('lbltipAddedCommentCard').innerHTML = '';
                        return true;
                    };
                    $scope.updateSoldCount = function(item) {
                        $http.post('updateSoldCount', {
                                    item_id: item.itemsBean.item_id
                                })
                                .success(function (response) {
                                    console.log(response);
                                });
                    };
                    $scope.quantity = function(vw){
                        if ($scope.validateQuantity() == true) {
                            $scope.total = 0;
                            for (var i=0; i<$scope.cart.length; i++){
                                $scope.total = $scope.total+($scope.cart[i].itemsBean.price * $scope.cart[i].quantity);
                            }
                            $http.post('updateCart', {
                                        itemsBean: vw.itemsBean,
                                        user_id:$scope.userInfo.id,
                                        quantity: vw.quantity,
                                        price: vw.price,
                                        cart_id: vw.cart_id
                                    })
                                    .success(function (response) {
                                        console.log(response);
                                    });
                        }
                    };
                    $scope.validateQuantity = function(){
                        /* Check Quantity */
                        var msg = '';
                        for (var i=0; i<$scope.cart.length; i++) {
                            if ($scope.cart[i].itemsBean.onsale_count == 0) {
                                msg += 'Product "' + $scope.cart[i].itemsBean.item_name + '" is out of stock, Please delete it!'  + '<br/>';
                            } else if ($scope.cart[i].quantity > $scope.cart[i].itemsBean.onsale_count-$scope.cart[i].itemsBean.sold_count) {
                                msg += 'Quantity from product "' + $scope.cart[i].itemsBean.item_name + '" is greater than available, only ' + ($scope.cart[i].itemsBean.onsale_count-$scope.cart[i].itemsBean.sold_count) + ' available!'  + '<br/>';
                            } else if ($scope.cart[i].quantity > 0 && ($scope.cart[i].quantity % 1 === 0)) {
                                // do nothing
                            } else if ($scope.cart[i].quantity == 0) {
                                msg += 'Quantity from product "' + $scope.cart[i].itemsBean.item_name + '" cannot be 0' + '<br/>';
                            } else if ($scope.cart[i].quantity < 0) {
                                msg += 'Quantity from product "' + $scope.cart[i].itemsBean.item_name + '" cannot be negative' + '<br/>';
                            } else {
                                msg += 'Quantity from product "' + $scope.cart[i].itemsBean.item_name + '" must be an integer' + '<br/>';
                            }
                        }
                        document.getElementById('lbltipAddedComment').innerHTML = msg;
                        if (msg != '') {
                            return false;
                        }
                        return true;
                    };
                    $scope.delete = function(vw){
                        $http.post('deleteCart', {
                                    itemsBean: vw.itemsBean,
                                    user_id:$scope.userInfo.id,
                                    quantity: vw.quantity,
                                    price: vw.price,
                                    cart_id: vw.cart_id
                                })
                                .success(function (response) {
                                    console.log(response);

                                });
                        $scope.cart.pop(vw);
                        $scope.total = 0
                        for (var i=0; i<$scope.cart.length; i++){
                            $scope.total = $scope.total+($scope.cart[i].itemsBean.price * $scope.cart[i].quantity);
                        }
                    };

                }]);
</script>

<head>
    <title>Cart</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container" ng-app="myApp">

    <div  ng-controller="HomeCtrl as hmectrl" >
        <jsp:include page="header.jsp" />
        <section class="col-xs-12 col-sm-6 col-md-12" ng-model = "cart">
            <article class="search-result row" ng-repeat = "vw in cart">
                    <div class="col-xs-12 col-sm-12 col-md-3" style="height: 110px; width: 160px">
                        <a href="#" title="{{vw.itemsBean.item_name}}" class="thumbnail"><img src="{{vw.itemsBean.images}}" style="height: 100px; width: 150px" alt="{{vw.itemsBean.item_name}}" /></a>
                    </div>
                <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                    <table style="width: 850px;">
                        <tr>
                            <td style="width: 300px;" colspan="3">
                                <h3><a href="#" title="">{{vw.itemsBean.item_name}}</a></h3>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>{{vw.itemsBean.item_description}}</p>
                            </td>
                            <td style="width: 80px;">
                                <i class="glyphicon glyphicon-usd"></i> <span> {{vw.itemsBean.price}}   X   </span>
                            </td>
                            <td style="width: 100px;">
                                <input type="number" style="width: 80px" ng-change ="quantity(vw)" required class="form-control" id="quantity" placeholder="Quantity" ng-model="vw.quantity">
                            </td>
                            <td style="width: 100px;">
                                <p> {{vw.itemsBean.price * vw.quantity}}</p>
                            </td>
                            <td style="width: 100px;">
                                <button ng-click="delete(vw)" class="btn btn-primary center-block">Delete</button>
                            </td>
                        </tr>
                    </table>
                </div>
                <span class="clearfix borda"></span>
            </article>
            <br/>
            <label> Subtotal</label> {{total}}
            <form ng-submit = "checkOut()">
            <div class="right">
                <span class="button-checkbox center-block" align="center" style='color:#FF0000'>
                    <label id="lbltipAddedComment"></label>
                </span>
                <button type="submit" class="btn btn-primary center-block">Checkout</button>
            <%--<button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Checkout</button>--%>
            </div>
            </form>
            <div class="modal fade" id="AddressModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header" ng-model = "address">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                            <h3 class="modal-title" id="addressModalLabel">Address</h3>
                        </div>
                        <div class="modal-body">

                            <!-- content goes here -->
                            <form ng-submit = "updateAddress(add)">

                                <div class="form-group">
                                    <div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">
                                                    Select Shiping Address
                                                </h3>

                                            </div>
                                            <div class="panel-body">
                                                <form role="form" >
                                                        <div ng-repeat = "add in address">
                                                    <div class="form-group has-feedback ">
                                                        <label class="input-group">
                                                                <span class="input-group-addon">
                                                                        <input type="radio" name="test" ng-model="junkvalue" ng-change="updateAddress(add)"/>
                                                                </span>
                                                            <div class="form-control form-control-static">
                                                                {{add.line1}}, {{add.line2}},
                                                                 {{add.city}} - {{add.state}}, {{add.zip}}
                                                            </div>
                                                            <span class="glyphicon form-control-feedback "></span>
                                                        </label>
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
                                                                <label for="expityDate">
                                                                    EXPIRY DATE</label>
                                                                <input type="text" class="form-control" id="expityDate" placeholder="MM/YY" required ng-model="vw.dateExp"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5 col-md-5 pull-right">
                                                            <div class="form-group">
                                                                <label for="cvCode">
                                                                    CVV CODE</label>
                                                                <input type="password" class="form-control" id="cvCode" placeholder="ex. 123" required ng-model="vw.cvvNo"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="form-control form-control-static">
                                            <a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon-usd"></span>{{total}}</span> <b>Final Payment</b></a>
                                        </div>
                                        <br/>
                                        <div class="form-control form-control-static badge" style="font-weight: normal; height: 25px; font-size: 14px; text-align: left" ng-model ="shipaddress">
                                            <b>Shipment Address</b> - {{shipaddress.line1}}, {{shipaddress.line2}},
                                            {{shipaddress.city}} - {{shipaddress.state}}, {{shipaddress.zip}}
                                        </div>
                                        <span class="button-checkbox center-block" align="center" style='color:#FF0000'>
                                            <label id="lbltipAddedCommentCard"></label>
                                        </span>
                                        <br/>
                                        <button type="submit" class="btn btn-success btn-lg btn-block" role="button">Pay</button>
                                    </div>
                                </div>
                            </form>

                        </div>

                    </div>
                </div>
            </div>


        </section>
    </div></div>
</body>
</html>
