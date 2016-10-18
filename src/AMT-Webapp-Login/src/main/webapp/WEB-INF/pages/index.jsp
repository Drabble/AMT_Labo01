<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>AMT Webapp</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

        <!-- Theme CSS -->
        <link href="${pageContext.request.contextPath}/resources/css/grayscale.min.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        Menu <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/index">
                        <span class="light">AMT</span> HEIG
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                    <ul class="nav navbar-nav">
                        <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/index">Index</a>
                        </li>
                        <c:choose>
                            <c:when test="${empty requestScope.id}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/login">Login</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/register">Register</a>
                                </li>
                            </c:when>    
                            <c:otherwise>
                                <li>
                                    <a href="${pageContext.request.contextPath}/users">Users</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/logout">Logout</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Intro Header -->
        <header class="intro">
            <div class="intro-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <h1 class="brand-heading">AMT Webapp</h1>
                            <p class="intro-text">A simple login webapp.
                                <br>Created by Antoine Drabble & Guillaume Serneels.</p>
                            <a href="#about" class="btn btn-circle page-scroll">
                                <i class="fa fa-angle-double-down animated"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- About Section -->
        <section id="about" class="container content-section text-center">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <h2>About AMT Webapp</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. <a href="http://startbootstrap.com/template-overviews/grayscale/">Maecenas</a> vitae est ultrices, semper eros non, aliquam odio. Aenean vel venenatis lacus, quis facilisis ante. Maecenas faucibus semper nibh, eu venenatis elit tempus aliquam. Vestibulum quis velit vitae velit mattis vestibulum. In dictum nisi aliquet, ultricies turpis ac, pellentesque elit. Curabitur dapibus nisl id ligula auctor efficitur. Donec tempus a ipsum eu fermentum. Quisque pharetra sed felis quis tristique. Nullam id malesuada sem. Integer nec placerat neque, at dictum mauris. Donec pretium consectetur augue in vulputate. Maecenas sed aliquet ipsum, facilisis tempus odio.</p>
                    <p>Nunc condimentum euismod quam at dictum. Phasellus a ex eget sem dignissim sodales. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Duis scelerisque augue eget luctus <a href="http://snazzymaps.com/">varius</a>.</p>
                    <p>Donec ipsum eros, ornare efficitur finibus vel, semper eu mi. Nulla finibus odio at pharetra pharetra. In non mi scelerisque erat feugiat congue sed eget orci. Donec tristique arcu augue, vitae rutrum libero eleifend vitae.</p>
                </div>
            </div>
        </section>

        <!-- Download Section -->
        <section id="download" class="content-section text-center">
            <div class="download-section">
                <div class="container">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h2>Download AMT for mobile</h2>
                        <p>You can download AMT for mobile for free on the preview page at AMT mobile.</p>
                        <a href="http://startbootstrap.com/template-overviews/grayscale/" class="btn btn-default btn-lg">Visit Download Page</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Contact Section -->
        <section id="contact" class="container content-section text-center">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <h2>Contact AMT webapp</h2>
                    <p>Feel free to email us to provide some feedback on our templates, give us suggestions for new templates and themes, or to just say hello!</p>
                    <p><a href="mailto:feedback@startbootstrap.com">feedback@amtwebapp.com</a>
                    </p>
                    <ul class="list-inline banner-social-buttons">
                        <li>
                            <a href="https://twitter.com/SBootstrap" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                        </li>
                        <li>
                            <a href="https://github.com/IronSummitMedia/startbootstrap" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
                        </li>
                        <li>
                            <a href="https://plus.google.com/+Startbootstrap/posts" class="btn btn-default btn-lg"><i class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </section>

        <!-- Map Section -->
        <div id="map"></div>

        <!-- Footer -->
        <footer>
            <div class="container text-center">
                <p>Copyright &copy; AMT Webapp 2016</p>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

        <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDeHGYLWNIaoSAJ2qtb4sfqoBV9eUNPXiY&sensor=false"></script>

        <!-- Theme JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/js/grayscale.min.js"></script>

    </body>

</html>
