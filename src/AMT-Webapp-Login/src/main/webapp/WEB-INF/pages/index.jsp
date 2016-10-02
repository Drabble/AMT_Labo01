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
		<title>AMT Webapp Login</title>
		<meta charset="utf-8" />
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</head>
	<body>
            <div class="container">
               <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                      <div class="panel panel-login">
                            <div class="panel-body">
                              <div class="row">
                                    <div class="col-lg-12">
                                        <c:choose>
                                            <c:when test="${not empty requestScope.registerError}">
                                                <div class="alert alert-danger">
                                                    <strong>Error with the registration!</strong> ${requestScope.registerError}
                                                </div>
                                            </c:when>    
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty requestScope.loginError}">
                                                <div class="alert alert-danger">
                                                    <strong>Error with the login!</strong> ${requestScope.loginError}
                                                </div>
                                            </c:when>    
                                        </c:choose>
                                      <form id="login-form" action="${pageContext.request.contextPath}/Login" method="post" role="form" style="display: block;">
                                            <h2>LOGIN</h2>
                                              <div class="form-group">
                                                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                                              </div>
                                              <div class="form-group">
                                                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                              </div>
                                              <div class="col-xs-6 form-group col-sm-offset-3">     
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                              </div>
                                      </form>
                                      <form id="register-form" action="${pageContext.request.contextPath}/Register" method="post" role="form" style="display: none;">
                                            <h2>REGISTER</h2>
                                              <div class="form-group">
                                                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                                              </div>
                                              <div class="form-group">
                                                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                              </div>
                                              <div class="form-group">
                                                    <div class="row">
                                                      <div class="col-sm-6 col-sm-offset-3">
                                                            <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                                                      </div>
                                                    </div>
                                              </div>
                                      </form>
                                    </div>
                              </div>
                            </div>
                            <div class="panel-heading">
                              <div class="row">
                                    <div class="col-xs-6 tabs">
                                      <a href="#" class="active" id="login-form-link"><div class="login">LOGIN</div></a>
                                    </div>
                                    <div class="col-xs-6 tabs">
                                      <a href="#" id="register-form-link"><div class="register">REGISTER</div></a>
                                    </div>
                              </div>
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