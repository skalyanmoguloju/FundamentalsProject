<%--
  Created by IntelliJ IDEA.
  User: sai
  Date: 2/22/16
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    .list-group-horizontal .list-group-item {
        display: inline-block;
    }
    .list-group-horizontal .list-group-item {
        margin-bottom: 0;
        margin-left:-4px;
        margin-right: 0;
    }
    .list-group-horizontal .list-group-item:first-child {
        border-top-right-radius:0;
        border-bottom-left-radius:4px;
    }
    .list-group-horizontal .list-group-item:last-child {
        border-top-right-radius:4px;
        border-bottom-left-radius:0;
    }
</style>
<head>
    <title></title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<div class="container">
    <div class="row" style="padding-top:50px">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 text-center">

            <div class="list-group list-group-horizontal">
                <a href="#" class="list-group-item active">Item One</a>
                <a href="#" class="list-group-item">Item Two</a>
                <a href="#" class="list-group-item">Item Three</a>
                <a href="#" class="list-group-item">Item Four</a>
            </div>

        </div>

    </div>
</div>
</body>
</html>
