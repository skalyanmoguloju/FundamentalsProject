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
                    $scope.cart= function(vw){;
                        console.log(vw);
                        $http.post('addCart', {
                            itemsBean: vw,
                            user_id:$scope.userInfo.id,
                            quantity: vw.noofpieces,
                            price: vw.price
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
        <!DOCTYPE html>
        <html>
        <head>
            <title>Search Box Example 2 - default placeholder text gets cleared on click</title>
            <meta name="ROBOTS" content="NOINDEX, NOFOLLOW" />
            <script type="text/javascript">
                $(function() {
                    $("#tfq2b").click(function() {
                        if ($("#tfq2b").val() == "Search our inventory"){
                            $("#tfq2b").val("");
                        }
                    });
                });
            </script>
            <!-- CSS styles for standard search box with placeholder text-->
            <style type="text/css">
                #tfheader{
                    background-color:#c3dfef;
                }
                #tfnewsearch{
                    float:right;
                    padding:20px;
                }
                .tftextinput2{
                    margin: 0;
                    padding: 5px 15px;
                    font-family: Arial, Helvetica, sans-serif;
                    font-size:14px;
                    color:#666;
                    border:1px solid #0076a3; border-right:0px;
                    border-top-left-radius: 5px 5px;
                    border-bottom-left-radius: 5px 5px;
                }
                .tfbutton2 {
                    margin: 0;
                    padding: 5px 7px;
                    font-family: Arial, Helvetica, sans-serif;
                    font-size:14px;
                    font-weight:bold;
                    outline: none;
                    cursor: pointer;
                    text-align: center;
                    text-decoration: none;
                    color: #ffffff;
                    border: solid 1px #0076a3; border-right:0px;
                    background: #0095cd;
                    background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
                    background: -moz-linear-gradient(top,  #00adee,  #0078a5);
                    border-top-right-radius: 5px 5px;
                    border-bottom-right-radius: 5px 5px;
                }
                .tfbutton2:hover {
                    text-decoration: none;
                    background: #007ead;
                    background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
                    background: -moz-linear-gradient(top,  #0095cc,  #00678e);
                }
                /* Fixes submit button height problem in Firefox */
                .tfbutton2::-moz-focus-inner {
                    border: 0;
                }
                .tfclear{
                    clear:both;
                }
            </style>
        </head>
        <body>
        <!-- HTML for SEARCH BAR -->
        <div id="tfheader">
            <form id="tfnewsearch" method="get" action="http://www.google.com">
                <input type="text" id="tfq2b" class="tftextinput2" name="q" size="21" maxlength="120" value="Search our website"><input type="submit" value=">" class="tfbutton2">
            </form>
            <div class="tfclear"></div>
        </div>
        </body>
        </html>


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
                                            <label for="exampleInputPassword1{{vw.item_id}}">Number of products (available {{vw.onsale_count}})</label>
                                            <input type="number" class="form-control" id="exampleInputPassword1{{vw.item_id}}" value="1" ng-model="vw.noofpieces">
                                        </div>
                                        <div class="form-group">
                                            <div>
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
