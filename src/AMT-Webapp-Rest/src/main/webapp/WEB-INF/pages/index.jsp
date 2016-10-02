<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Director | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/resources/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="${pageContext.request.contextPath}/resources/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${pageContext.request.contextPath}/resources/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="${pageContext.request.contextPath}/resources/css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <!-- <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" /> -->
        <!-- Daterange picker -->
        <link href="${pageContext.request.contextPath}/resources/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- iCheck for checkboxes and radio inputs -->
        <link href="${pageContext.request.contextPath}/resources/css/iCheck/all.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <!-- <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" /> -->
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />

		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.css"/>


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
          <![endif]-->

        <style type="text/css">

        </style>
    </head>
    <body class="skin-black">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="index.html" class="logo">
                Table
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>  
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/Index">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <aside class="right-side">
                <!-- Main content -->
                <section class="content">
                    <div class="row">

                        <div class="col-md-8">
                            <section class="panel">
                                <header class="panel-heading">
                                    Main table
                                </header>
                                <div class="panel-body table-responsive">
									<table id="table_id" class="table table-striped table-bordered" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>Name</th>
												<th>Position</th>
												<th>Office</th>
												<th>Age</th>
												<th>Start date</th>
												<th>Salary</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>Name</th>
												<th>Position</th>
												<th>Office</th>
												<th>Age</th>
												<th>Start date</th>
												<th>Salary</th>
											</tr>
										</tfoot>
										<tbody>
											<tr>
												<td>Tiger Nixon</td>
												<td>System Architect</td>
												<td>Edinburgh</td>
												<td>61</td>
												<td>2011/04/25</td>
												<td>$320,800</td>
											</tr>
											<tr>
												<td>Garrett Winters</td>
												<td>Accountant</td>
												<td>Tokyo</td>
												<td>63</td>
												<td>2011/07/25</td>
												<td>$170,750</td>
											</tr>
											<tr>
												<td>Ashton Cox</td>
												<td>Junior Technical Author</td>
												<td>San Francisco</td>
												<td>66</td>
												<td>2009/01/12</td>
												<td>$86,000</td>
											</tr>
											<tr>
												<td>Cedric Kelly</td>
												<td>Senior Javascript Developer</td>
												<td>Edinburgh</td>
												<td>22</td>
												<td>2012/03/29</td>
												<td>$433,060</td>
											</tr>
											<tr>
												<td>Airi Satou</td>
												<td>Accountant</td>
												<td>Tokyo</td>
												<td>33</td>
												<td>2008/11/28</td>
												<td>$162,700</td>
											</tr>
											<tr>
												<td>Brielle Williamson</td>
												<td>Integration Specialist</td>
												<td>New York</td>
												<td>61</td>
												<td>2012/12/02</td>
												<td>$372,000</td>
											</tr>
											<tr>
												<td>Herrod Chandler</td>
												<td>Sales Assistant</td>
												<td>San Francisco</td>
												<td>59</td>
												<td>2012/08/06</td>
												<td>$137,500</td>
											</tr>
											<tr>
												<td>Rhona Davidson</td>
												<td>Integration Specialist</td>
												<td>Tokyo</td>
												<td>55</td>
												<td>2010/10/14</td>
												<td>$327,900</td>
											</tr>
											<tr>
												<td>Colleen Hurst</td>
												<td>Javascript Developer</td>
												<td>San Francisco</td>
												<td>39</td>
												<td>2009/09/15</td>
												<td>$205,500</td>
											</tr>
											<tr>
												<td>Sonya Frost</td>
												<td>Software Engineer</td>
												<td>Edinburgh</td>
												<td>23</td>
												<td>2008/12/13</td>
												<td>$103,600</td>
											</tr>
											<tr>
												<td>Jena Gaines</td>
												<td>Office Manager</td>
												<td>London</td>
												<td>30</td>
												<td>2008/12/19</td>
												<td>$90,560</td>
											</tr>
											<tr>
												<td>Quinn Flynn</td>
												<td>Support Lead</td>
												<td>Edinburgh</td>
												<td>22</td>
												<td>2013/03/03</td>
												<td>$342,000</td>
											</tr>
											<tr>
												<td>Charde Marshall</td>
												<td>Regional Director</td>
												<td>San Francisco</td>
												<td>36</td>
												<td>2008/10/16</td>
												<td>$470,600</td>
											</tr>
											<tr>
												<td>Haley Kennedy</td>
												<td>Senior Marketing Designer</td>
												<td>London</td>
												<td>43</td>
												<td>2012/12/18</td>
												<td>$313,500</td>
											</tr>
											<tr>
												<td>Tatyana Fitzpatrick</td>
												<td>Regional Director</td>
												<td>London</td>
												<td>19</td>
												<td>2010/03/17</td>
												<td>$385,750</td>
											</tr>
											<tr>
												<td>Michael Silva</td>
												<td>Marketing Designer</td>
												<td>London</td>
												<td>66</td>
												<td>2012/11/27</td>
												<td>$198,500</td>
											</tr>
											<tr>
												<td>Paul Byrd</td>
												<td>Chief Financial Officer (CFO)</td>
												<td>New York</td>
												<td>64</td>
												<td>2010/06/09</td>
												<td>$725,000</td>
											</tr>
											<tr>
												<td>Gloria Little</td>
												<td>Systems Administrator</td>
												<td>New York</td>
												<td>59</td>
												<td>2009/04/10</td>
												<td>$237,500</td>
											</tr>
											<tr>
												<td>Bradley Greer</td>
												<td>Software Engineer</td>
												<td>London</td>
												<td>41</td>
												<td>2012/10/13</td>
												<td>$132,000</td>
											</tr>
											<tr>
												<td>Dai Rios</td>
												<td>Personnel Lead</td>
												<td>Edinburgh</td>
												<td>35</td>
												<td>2012/09/26</td>
												<td>$217,500</td>
											</tr>
											<tr>
												<td>Jenette Caldwell</td>
												<td>Development Lead</td>
												<td>New York</td>
												<td>30</td>
												<td>2011/09/03</td>
												<td>$345,000</td>
											</tr>
											<tr>
												<td>Yuri Berry</td>
												<td>Chief Marketing Officer (CMO)</td>
												<td>New York</td>
												<td>40</td>
												<td>2009/06/25</td>
												<td>$675,000</td>
											</tr>
											<tr>
												<td>Caesar Vance</td>
												<td>Pre-Sales Support</td>
												<td>New York</td>
												<td>21</td>
												<td>2011/12/12</td>
												<td>$106,450</td>
											</tr>
											<tr>
												<td>Doris Wilder</td>
												<td>Sales Assistant</td>
												<td>Sidney</td>
												<td>23</td>
												<td>2010/09/20</td>
												<td>$85,600</td>
											</tr>
											<tr>
												<td>Angelica Ramos</td>
												<td>Chief Executive Officer (CEO)</td>
												<td>London</td>
												<td>47</td>
												<td>2009/10/09</td>
												<td>$1,200,000</td>
											</tr>
											<tr>
												<td>Gavin Joyce</td>
												<td>Developer</td>
												<td>Edinburgh</td>
												<td>42</td>
												<td>2010/12/22</td>
												<td>$92,575</td>
											</tr>
											<tr>
												<td>Jennifer Chang</td>
												<td>Regional Director</td>
												<td>Singapore</td>
												<td>28</td>
												<td>2010/11/14</td>
												<td>$357,650</td>
											</tr>
											<tr>
												<td>Brenden Wagner</td>
												<td>Software Engineer</td>
												<td>San Francisco</td>
												<td>28</td>
												<td>2011/06/07</td>
												<td>$206,850</td>
											</tr>
											<tr>
												<td>Fiona Green</td>
												<td>Chief Operating Officer (COO)</td>
												<td>San Francisco</td>
												<td>48</td>
												<td>2010/03/11</td>
												<td>$850,000</td>
											</tr>
											<tr>
												<td>Shou Itou</td>
												<td>Regional Marketing</td>
												<td>Tokyo</td>
												<td>20</td>
												<td>2011/08/14</td>
												<td>$163,000</td>
											</tr>
											<tr>
												<td>Michelle House</td>
												<td>Integration Specialist</td>
												<td>Sidney</td>
												<td>37</td>
												<td>2011/06/02</td>
												<td>$95,400</td>
											</tr>
											<tr>
												<td>Suki Burks</td>
												<td>Developer</td>
												<td>London</td>
												<td>53</td>
												<td>2009/10/22</td>
												<td>$114,500</td>
											</tr>
											<tr>
												<td>Prescott Bartlett</td>
												<td>Technical Author</td>
												<td>London</td>
												<td>27</td>
												<td>2011/05/07</td>
												<td>$145,000</td>
											</tr>
											<tr>
												<td>Gavin Cortez</td>
												<td>Team Leader</td>
												<td>San Francisco</td>
												<td>22</td>
												<td>2008/10/26</td>
												<td>$235,500</td>
											</tr>
											<tr>
												<td>Martena Mccray</td>
												<td>Post-Sales support</td>
												<td>Edinburgh</td>
												<td>46</td>
												<td>2011/03/09</td>
												<td>$324,050</td>
											</tr>
											<tr>
												<td>Unity Butler</td>
												<td>Marketing Designer</td>
												<td>San Francisco</td>
												<td>47</td>
												<td>2009/12/09</td>
												<td>$85,675</td>
											</tr>
											<tr>
												<td>Howard Hatfield</td>
												<td>Office Manager</td>
												<td>San Francisco</td>
												<td>51</td>
												<td>2008/12/16</td>
												<td>$164,500</td>
											</tr>
											<tr>
												<td>Hope Fuentes</td>
												<td>Secretary</td>
												<td>San Francisco</td>
												<td>41</td>
												<td>2010/02/12</td>
												<td>$109,850</td>
											</tr>
											<tr>
												<td>Vivian Harrell</td>
												<td>Financial Controller</td>
												<td>San Francisco</td>
												<td>62</td>
												<td>2009/02/14</td>
												<td>$452,500</td>
											</tr>
											<tr>
												<td>Timothy Mooney</td>
												<td>Office Manager</td>
												<td>London</td>
												<td>37</td>
												<td>2008/12/11</td>
												<td>$136,200</td>
											</tr>
											<tr>
												<td>Jackson Bradshaw</td>
												<td>Director</td>
												<td>New York</td>
												<td>65</td>
												<td>2008/09/26</td>
												<td>$645,750</td>
											</tr>
											<tr>
												<td>Olivia Liang</td>
												<td>Support Engineer</td>
												<td>Singapore</td>
												<td>64</td>
												<td>2011/02/03</td>
												<td>$234,500</td>
											</tr>
											<tr>
												<td>Bruno Nash</td>
												<td>Software Engineer</td>
												<td>London</td>
												<td>38</td>
												<td>2011/05/03</td>
												<td>$163,500</td>
											</tr>
											<tr>
												<td>Sakura Yamamoto</td>
												<td>Support Engineer</td>
												<td>Tokyo</td>
												<td>37</td>
												<td>2009/08/19</td>
												<td>$139,575</td>
											</tr>
											<tr>
												<td>Thor Walton</td>
												<td>Developer</td>
												<td>New York</td>
												<td>61</td>
												<td>2013/08/11</td>
												<td>$98,540</td>
											</tr>
											<tr>
												<td>Finn Camacho</td>
												<td>Support Engineer</td>
												<td>San Francisco</td>
												<td>47</td>
												<td>2009/07/07</td>
												<td>$87,500</td>
											</tr>
											<tr>
												<td>Serge Baldwin</td>
												<td>Data Coordinator</td>
												<td>Singapore</td>
												<td>64</td>
												<td>2012/04/09</td>
												<td>$138,575</td>
											</tr>
											<tr>
												<td>Zenaida Frank</td>
												<td>Software Engineer</td>
												<td>New York</td>
												<td>63</td>
												<td>2010/01/04</td>
												<td>$125,250</td>
											</tr>
											<tr>
												<td>Zorita Serrano</td>
												<td>Software Engineer</td>
												<td>San Francisco</td>
												<td>56</td>
												<td>2012/06/01</td>
												<td>$115,000</td>
											</tr>
											<tr>
												<td>Jennifer Acosta</td>
												<td>Junior Javascript Developer</td>
												<td>Edinburgh</td>
												<td>43</td>
												<td>2013/02/01</td>
												<td>$75,650</td>
											</tr>
											<tr>
												<td>Cara Stevens</td>
												<td>Sales Assistant</td>
												<td>New York</td>
												<td>46</td>
												<td>2011/12/06</td>
												<td>$145,600</td>
											</tr>
											<tr>
												<td>Hermione Butler</td>
												<td>Regional Director</td>
												<td>London</td>
												<td>47</td>
												<td>2011/03/21</td>
												<td>$356,250</td>
											</tr>
											<tr>
												<td>Lael Greer</td>
												<td>Systems Administrator</td>
												<td>London</td>
												<td>21</td>
												<td>2009/02/27</td>
												<td>$103,500</td>
											</tr>
											<tr>
												<td>Jonas Alexander</td>
												<td>Developer</td>
												<td>San Francisco</td>
												<td>30</td>
												<td>2010/07/14</td>
												<td>$86,500</td>
											</tr>
											<tr>
												<td>Shad Decker</td>
												<td>Regional Director</td>
												<td>Edinburgh</td>
												<td>51</td>
												<td>2008/11/13</td>
												<td>$183,000</td>
											</tr>
											<tr>
												<td>Michael Bruce</td>
												<td>Javascript Developer</td>
												<td>Singapore</td>
												<td>29</td>
												<td>2011/06/27</td>
												<td>$183,000</td>
											</tr>
											<tr>
												<td>Donna Snider</td>
												<td>Customer Support</td>
												<td>New York</td>
												<td>27</td>
												<td>2011/01/25</td>
												<td>$112,000</td>
											</tr>
										</tbody>
									</table>
                                </div>
                            </section>

                        </div>
                    </div>
                    <!-- row end -->
                </section><!-- /.content -->
                <div class="footer-main">
                    Copyright &copy Director, 2014
                </div>
            </aside><!-- /.right-side -->

        </div><!-- ./wrapper -->


        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>

        <!-- jQuery UI 1.10.3 -->
        <script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>

        <script src="${pageContext.request.contextPath}/resources/js/plugins/chart.js" type="text/javascript"></script>

        <!-- datepicker
        <script src="${pageContext.request.contextPath}/resources/js/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>-->
        <!-- Bootstrap WYSIHTML5
        <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>-->
        <!-- iCheck -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
        <!-- calendar -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar/fullcalendar.js" type="text/javascript"></script>

        <!-- Director App -->
        <script src="${pageContext.request.contextPath}/resources/js/Director/app.js" type="text/javascript"></script>

        <!-- Director dashboard demo (This is only for demo purposes) -->
        <script src="${pageContext.request.contextPath}/resources/js/Director/dashboard.js" type="text/javascript"></script>

		<script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.js"></script>        <!-- Director for demo purposes -->
        <script type="text/javascript">
            $('input').on('ifChecked', function (event) {
                // var element = $(this).parent().find('input:checkbox:first');
                // element.parent().parent().parent().addClass('highlight');
                $(this).parents('li').addClass("task-done");
                console.log('ok');
            });
            $('input').on('ifUnchecked', function (event) {
                // var element = $(this).parent().find('input:checkbox:first');
                // element.parent().parent().parent().removeClass('highlight');
                $(this).parents('li').removeClass("task-done");
                console.log('not');
            });

        </script>
        <script>
            $('#noti-box').slimScroll({
                height: '400px',
                size: '5px',
                BorderRadius: '5px'
            });

            $('input[type="checkbox"].flat-grey, input[type="radio"].flat-grey').iCheck({
                checkboxClass: 'icheckbox_flat-grey',
                radioClass: 'iradio_flat-grey'
            });
        </script>
        <script type="text/javascript">
            $(function () {
                "use strict";
                //BAR CHART
                var data = {
                    labels: ["January", "February", "March", "April", "May", "June", "July"],
                    datasets: [
                        {
                            label: "My First dataset",
                            fillColor: "rgba(220,220,220,0.2)",
                            strokeColor: "rgba(220,220,220,1)",
                            pointColor: "rgba(220,220,220,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [65, 59, 80, 81, 56, 55, 40]
                        },
                        {
                            label: "My Second dataset",
                            fillColor: "rgba(151,187,205,0.2)",
                            strokeColor: "rgba(151,187,205,1)",
                            pointColor: "rgba(151,187,205,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [28, 48, 40, 19, 86, 27, 90]
                        }
                    ]
                };
            });
            // Chart.defaults.global.responsive = true;
			$(document).ready(function () {
				$('#table_id').DataTable();
			});
        </script>
    </body>
</html>