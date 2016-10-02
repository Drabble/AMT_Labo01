<%-- 
    Document   : newjsp
    Created on : Sep 26, 2016, 2:39:02 PM
    Author     : antoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>AMT Webapp Private</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-login">
                        <div class="panel-body">
                            <h1>Welcome ${requestScope.user.username}</h1>
                            <p>Your password is ${requestScope.user.password}.</p>
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Logout">Logout</a>
                            <br/><br/><br/>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <footer>
            <div class="container">
                <div class="col-md-10 col-md-offset-1 text-center">
                    <h6 style="font-size:14px;font-weight:100;color: #fff;">Copyright Antoine Drabble & Guillaume Serneels</h6>
                </div>   
            </div>
        </footer>
    </body>
</html>