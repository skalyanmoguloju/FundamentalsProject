<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel Dao
  Date: 4/14/16
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
                    $http.post('userInfo', {id: user})
                            .success(function (response) {
                                var date = new Date();
                                $scope.userInfo = response[0];
                                $scope.userInfo.dob= $filter('date')(response[0].dob , "dd/MM/yyyy");
                                $http.post('rights', {role: response[0].role})
                                        .success(function (data) {
                                            $scope.rights = data
                                        });
                            });
                    $scope.updatePassword = function()
                    {
                        if($scope.validatePassword() == true)
                        {
                            var pswd = document.getElementById('hidpassword').value;
                            $http.post('updatePassword', {id: $scope.userInfo.id, pwsd: pswd})
                                    .success(function (response) {
                                        console.log(response);
                                        if (response.length == 0) {
                                            document.getElementById('lbpasswordUpdateID').innerHTML = 'Error in updating password!! Please try again';
                                        }
                                        else {
                                            alert("Successfully Updated Password!");
                                            window.location.href = "/edit info"
                                        }
                                    });
                        }
                    };
                    $scope.validatePassword = function(){
                        if(document.getElementById('hidpassword').value == "" || document.getElementById('hidpassword').value == undefined)
                        {
                            document.getElementById('lbpasswordUpdateID').innerHTML = 'Password field cannot be empty';
                            return false;
                        }
                        if(document.getElementById('hidpassword').value.length < 6)
                        {
                            document.getElementById('lbpasswordUpdateID').innerHTML = 'Password must contain at least 6 characters';
                            return false;
                        }
                        if(!document.getElementById('hidpassword').value.match(/((^[0-9]+[a-z]+)|(^[a-z]+[0-9]+))+[0-9a-z]*$/i))
                        {
                            document.getElementById('lbpasswordUpdateID').innerHTML = 'Password must contain alphanumeric characters';
                            return false;
                        }
                        if($scope.asteriskpswd2 == "" || $scope.asteriskpswd2 == undefined)
                        {
                            document.getElementById('lbpasswordUpdateID').innerHTML = 'Confirm Password cannot be empty';
                            return false;
                        }
                        if(document.getElementById('hidpassword').value != document.getElementById('hidconfirm_password').value)
                        {
                            document.getElementById('lbpasswordUpdateID').innerHTML = 'Confirm Password does not match with Password';
                            return false;
                        }
                        return true;
                    };
                    $scope.updateOtherInformation = function()
                    {
                        if($scope.validateOtherInfoForm() == true)
                        {
                            var dOb = Date.parse(document.getElementById('calendar').value);
                            $http.post('updateOtherInfo', {
                                    id: $scope.userInfo.id,
                                    name: $scope.name,
                                    lname: $scope.lname,
                                    email: $scope.email,
                                    gender: $scope.gender,
                                    dob: dOb
                                })
                                .success(function (response) {
                                    console.log(response);
                                    if (response.length == 0) {
                                        document.getElementById('lbOtherInfoID').innerHTML = 'Error in updating Information!! Please try again';
                                    }
                                    else {
                                        alert("Successfully Updated Information!");
                                        window.location.href = "/edit info"
                                    }
                                });
                        }
                    };
                    $scope.validateOtherInfoForm = function()
                    {
                        if($scope.name == "" || $scope.name == undefined)
                        {
                            document.getElementById('lbOtherInfoID').innerHTML = 'First Name cannot be empty';
                            return false;
                        }
                        if($scope.lname == "" || $scope.lname == undefined)
                        {
                            document.getElementById('lbOtherInfoID').innerHTML = 'Last Name cannot be empty';
                            return false;
                        }
                        if($scope.email == "" || $scope.email == undefined)
                        {
                            document.getElementById('lbOtherInfoID').innerHTML = 'Email id cannot be empty';
                            return false;
                        }
                        else
                        {
                            if($scope.validateEmail()== false)
                            {
                                return false;
                            }
                        }
                        if($scope.gender !="M" && $scope.gender!="F")
                        {
                            document.getElementById('lbOtherInfoID').innerHTML = 'Please Select the Gender';
                            return false;
                        }
                        if(document.getElementById('calendar').value == "")
                        {
                            document.getElementById('lbOtherInfoID').innerHTML = 'Please select DOB';
                            return false;
                        }
                        return true;
                    };
                    $scope.validateEmail = function(){
                        var x = $scope.email;
                        var atpos = x.indexOf("@");
                        var dotpos = x.lastIndexOf(".");
                        if (atpos<1 || dotpos<atpos+2 || dotpos+1>=x.length) {
                            document.getElementById('lbOtherInfoID').innerHTML = 'Invalid Email id entered!!';
                            return false;
                        }
                        return true;
                    };
                    $scope.updateAddress = function()
                    {
                        if($scope.validateAddressForm() == true)
                        {
                            $http.post('updateAddress', {
                                    user_id: $scope.userInfo.id,
                                    line1: $scope.addressline1,
                                    line2: $scope.addressline2,
                                    city: $scope.city.toUpperCase(),
                                    state: $scope.state.toUpperCase(),
                                    zip: $scope.zipcode,
                                    phone: $scope.phonenumber
                                })
                                .success(function (response) {
                                    console.log(response);
                                    if (response.length == 0) {
                                        document.getElementById('lbAddressID').innerHTML = 'Error in updating address!! Please try again';
                                    }
                                    else {
                                        alert("Successfully Updated Address!");
                                        window.location.href = "/edit info"
                                    }
                                });
                        }
                    };
                    $scope.validateAddressForm = function(){
                        if($scope.addressline1 == "" || $scope.addressline1 == undefined)
                        {
                            document.getElementById('lbAddressID').innerHTML = 'Address Line 1 cannot be empty';
                            return false;
                        }
                        if($scope.city == "" || $scope.city == undefined)
                        {
                            document.getElementById('lbAddressID').innerHTML = 'City cannot be empty';
                            return false;
                        }
                        if($scope.state == "" || $scope.state == undefined)
                        {
                            document.getElementById('lbAddressID').innerHTML = 'State cannot be empty';
                            return false;
                        }
                        if(!$scope.state.match(/^([a-z]|[A-Z])([a-z]|[A-Z])$/i)) {
                            document.getElementById('lbAddressID').innerHTML = 'Please enter 2-letter state (E.g. IA)';
                            return false;
                        }
                        if($scope.zipcode == "" || $scope.zipcode == undefined)
                        {
                            document.getElementById('lbAddressID').innerHTML = 'Zipcode cannot be empty';
                            return false;
                        }
                        if(!$scope.zipcode.match(/^[0-9][0-9][0-9][0-9][0-9]$/i))
                        {
                            document.getElementById('lbAddressID').innerHTML = 'Please enter 5-digit zipcode (E.g. 52240)';
                            return false;
                        }
                        if($scope.phonenumber == "" || $scope.phonenumber == undefined)
                        {
                            document.getElementById('lbAddressID').innerHTML = 'Telephone Number cannot be empty';
                            return false;
                        }
                        if(!$scope.phonenumber.match(/^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$/i))
                        {
                            document.getElementById('lbAddressID').innerHTML = 'Please enter 10-digit phone number (E.g. 3191234567)';
                            return false;
                        }
                        return true;
                    };
                }]);
</script>
<style type="text/css">

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
<script type="text/javascript" src="js/asteriskPassword.js"></script>

<head>
    <title>Edit Information</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container" ng-app="myApp">
    <div  ng-controller="HomeCtrl as hmectrl" >
        <jsp:include page="header.jsp" />
        <br>
        <form class="well span8 center-block" style="width: 600px; align-content: center" ng-submit="updatePassword()">
            <h4 style="text-align: center"><b>Update Password</b></h4>
            <br/>
            <input id="pswd" type="password" name="password" value="" class="form-control input-lg" placeholder="Password" ng-model = "asteriskpswd"/>
            <script type="text/javascript"> new AsteriskPassword(document.getElementById('pswd'), '\u002A'); </script>
            <br/>
            <input id="confirm_pswd" type="password" name="confirm_password" value="" class="form-control input-lg" placeholder="Confirm Password" ng-model = "asteriskpswd2"/>
            <script type="text/javascript"> new AsteriskPassword(document.getElementById('confirm_pswd'), '\u002A'); </script>
            <br/>
            <span class="button-checkbox center-block" align="center" style='color:#FF0000'>
                <label id="lbpasswordUpdateID"> </label>
            </span>
            <button class="btn btn-success center-block"  type="submit">Submit</button>
        </form>

        <form class="well span8 center-block" style="width: 600px; align-content: center" ng-submit="updateOtherInformation()">
            <h4 style="text-align: center"><b>Update Other Infomation</b></h4>
            <br/>
            <div class="col-xs-6 col-md-6">
                <input type="text" autocapitalize="off" autocomplete="off" name="firstname" value="" class="form-control input-lg" placeholder="First Name"  ng-model="name"/>
            </div>
            <div class="col-xs-6 col-md-6">
                <input type="text" autocapitalize="off" autocomplete="off" name="lastname" value="" class="form-control input-lg" placeholder="Last Name"  ng-model="lname"/>
                <br/>
            </div>
            <input type="text" autocapitalize="off" autocomplete="off" name="email" value="" class="form-control input-lg" placeholder="Your Email" ng-model="email"/>
            <br/>
            <div class="col-xs-6 col-md-6">
                <select name="gender" value = "" class="form-control input-lg" ng-model="gender">
                    <option value="">Gender</option>
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                </select>
            </div>
            <div class="col-xs-6 col-md-6">
                <div class="form-group">
                    <div class='input-group date' id='datepicker1'>
                        <input type="text" placeholder="DOB (mm/dd/yyyy)" id ="calendar" class="form-control input-lg" ng-model = "calendar"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                    </div>
                </div>
                <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
                <script>
                    $(function() {
                        $( "#calendar" ).datepicker();
                    });
                </script>
            </div>
            <span class="button-checkbox center-block" align="center" style='color:#FF0000'>
                <label id="lbOtherInfoID"> </label>
            </span>

            <button class="btn btn-success center-block"  type="submit">Submit</button>
        </form>

        <form class="well span8 center-block" style="width: 600px; align-content: center" ng-submit="updateAddress()">
            <h4 style="text-align: center"><b>Update Address</b></h4>
            <br/>
            <input type="text" autocapitalize="off" autocomplete="off" name="addressline1" value="" class="form-control input-lg" placeholder="Address Line 1"  ng-model="addressline1"/>
            <br/>
            <input type="text" autocapitalize="off" autocomplete="off" name="addressline2" value="" class="form-control input-lg" placeholder="Address Line 2"  ng-model="addressline2"/>
            <br/>
            <input type="text" autocapitalize="off" autocomplete="off" name="city" class="form-control input-lg" placeholder="City" ng-model="city"/>
            <br/>
            <input type="text" autocapitalize="off" autocomplete="off" name="state" class="form-control input-lg" placeholder="State" ng-model="state"/>
            <br/>
            <input type="text" autocapitalize="off" autocomplete="off" name="zipcode" class="form-control input-lg" placeholder="Zipcode" ng-model="zipcode"/>
            <br/>
            <input type="text" autocapitalize="off" autocomplete="off" name="phonenumber" class="form-control input-lg" placeholder="Telephone Number" ng-model="phonenumber"/>
            <br/>
            <span class="button-checkbox center-block" align="center" style='color:#FF0000'>
                <label id="lbAddressID"> </label>
            </span>

            <button class="btn btn-success center-block"  type="submit">Submit</button>
        </form>
    </div>
</div>
</body>
</html>