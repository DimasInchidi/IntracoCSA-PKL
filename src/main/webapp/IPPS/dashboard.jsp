<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlet.F_TimeManagement" %>
<%@ page import="servlet.F_Function" %>
<%@ page import="servlet.O_DataTables" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%
        F_TimeManagement FT = new F_TimeManagement();
        F_Function FF = new F_Function();
        Calendar cal = Calendar.getInstance();
        if(session.getAttribute("user")==null || session.getAttribute("user").toString().trim().equals("")) {response.sendRedirect("/login");}

        int tahun,bulan,projectindex;
        String project;

        if (request.getParameter("project")==null){
            tahun = cal.get(Calendar.YEAR);
            bulan = cal.get(Calendar.MONTH);
            projectindex = 0;
            project = "TOTAL CSA GOLD";
        }else{
            tahun = Integer.parseInt(request.getParameter("year"));
            bulan = Integer.parseInt(request.getParameter("month"));
            project = request.getParameter("project");
            if (project.contains("FMC")) projectindex = 2;
            else projectindex=0;
        }
        O_DataTables Data = FF.TableData(tahun,bulan,projectindex,project);
    %>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Dashboard Page CSA">
    <meta name="author" content="DimasInchidi">

    <title>Dashboard - PT Intraco Penta Prima Servis</title>
    <link rel="shortcut icon" href="img/favicon.ico">

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">Dashboard</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#ReadMessage">
                                <div>
                                    <strong>Pengirim</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Isi Pesan</div>
                            </a>
                        </li>
                        <li class="divider"></li>

                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="/profile"><i class="fa fa-user fa-fw"></i> Hi, <%=session.getAttribute("nama")%></a>
                        </li>
                        <%
                            if (session.getAttribute("level") == null || session.getAttribute("level").toString().contains("Admin")) {
                               out.print("<li ><a href = \"/manage+user\" ><i class=\"fa fa-gear fa-fw\" ></i > Manage Users</a ></li >");
                            }
                        %>
                        <li class="divider"></li>
                        <li><a href="/Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-google"></i>
                                    <%--https://www.google.com/search?q=inurl:PT.+intraco+penta+prima+service+YANGDIKETIK&ie=utf-8&oe=utf-8--%>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="/input+data"><i class="fa fa-edit fa-fw"></i> Update Data</a>
                        </li>
                        <li>
                            <a href="/lihat+data"><i class="fa fa-bar-chart-o fa-fw"></i> Lihat Data</a>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <br>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <form action= "" method= "GET" >
                                <div class="row">
                                    <div class="col-md-5">
                                        <%
                                            if (session.getAttribute("level") ==null || session.getAttribute("level").toString().contains("Admin")) {
                                                out.print(Data.getDataProyek());
                                            }else{
                                                out.print(session.getAttribute("level"));
                                                out.print("<input name=\"project\" class=\"hidden\" value=\""+session.getAttribute("level")+"\">");
                                            }
                                        %>
                                    </div>

                                    <div class="col-md-2">
                                        <select name="month" class="form-control" >
                                            <%
                                                int Bulan = Data.getBulanDataHome();
                                                for (int i=0; i<12;i++){
                                                    if(i==Bulan){
                                                        out.print("<option selected value=\"" + i + "\">" + FT.getBulan(i) + "</option>");
                                                    }else {
                                                        out.print("<option value=\"" + i + "\">" + FT.getBulan(i) + "</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                        <div class="col-md-4">
                                        <input class="form-control" value="<%=Data.getTahunDataHome()%>" name="year" type="number" autofocus>

                                    </div>
                                    <div class="col-md-1" align="right">
                                        <button class="btn btn-default btn-circle" type= "submit"/>
                                        <i class="fa fa-refresh"></i>
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <!-- /.panel-heading -->

                        <div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav nav-pills">
                                <li class="active"><a aria-expanded="true" href="#ThisMonth" data-toggle="tab">This Month</a>
                                </li>
                                <li class=""><a aria-expanded="false" href="#YTD" data-toggle="tab">Year To Date</a>
                                </li>
                                <li class=""><a aria-expanded="false" href="#ActualVSBudget" data-toggle="tab">Actual VS Budget</a>
                                </li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="ThisMonth">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Target</th>
                                                    <th>Actual</th>
                                                    <th>Percent</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <%=Data.getTableMonth() %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                    </div>
                                    <!-- /.panel-body -->
                                </div>
                                <div class="tab-pane fade" id="YTD">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Target</th>
                                                    <th>Actual</th>
                                                    <th>Percent</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <%=Data.getTableYTD() %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                    </div>
                                    <!-- /.panel-body -->
                                </div>
                                <div class="tab-pane fade" id="ActualVSBudget">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Target</th>
                                                    <th>Actual</th>
                                                    <th>Percent</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <%=Data.getTableAVB()%>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                    </div>
                                    <!-- /.panel-body -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.panel -->
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Morris Charts JavaScript -->
    <script src="../bower_components/raphael/raphael-min.js"></script>
    <script src="../bower_components/morrisjs/morris.min.js"></script>
    <script src="../js/morris-data.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
</body>
</html>
