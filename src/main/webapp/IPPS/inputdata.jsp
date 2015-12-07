<%@ page import="servlet.F_TimeManagement" %>
<%@ page import="servlet.F_Function" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="servlet.O_DataInput" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%
        String direct = request.getRequestURI();
        if(session.getAttribute("user")==null || session.getAttribute("user").toString().trim().equals("")) {
            response.sendRedirect("/login?redirect="+direct);
        }
        Calendar cal = Calendar.getInstance();
        F_TimeManagement FT = new F_TimeManagement();
        F_Function FF = new F_Function();

        int tahun,bulan;
        String project;

        if (request.getParameter("project")==null){
            tahun = cal.get(Calendar.YEAR);
            bulan = cal.get(Calendar.MONTH);
            project = "FMC ANTAM";
        }else{
            tahun = Integer.parseInt(request.getParameter("year"));
            bulan = Integer.parseInt(request.getParameter("month"));
            project = request.getParameter("project");
        }
        String task = request.getParameter("task");
        if (task ==null) task = "none";
        O_DataInput Data = FF.InputData(task, tahun,bulan,project,session.getAttribute("datainputActual"),session.getAttribute("datainputActual"));
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Update - PT Intraco Penta Prima Servis</title>
    <link rel="shortcut icon" href="/img/favicon.ico">

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Morris Charts CSS -->
    <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">

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
            <a class="navbar-brand" href="">Update</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-messages">
                    <li>
                        <a href="#">
                            <div>
                                <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                            </div>
                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                            </div>
                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                            </div>
                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
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
                <form action= "/input+data" method= "GET" >
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
                        <input class="hidden" value="true" name="refresh">
                        <div class="col-md-1" align="right">
                            <button class="btn btn-default btn-circle" type= "submit"/>
                            <i class="fa fa-refresh"></i>
                            </button>
                        </div>
                    </div>

                </form>
            </div>

            <!-- /.col-lg-12 -->
<div class="panel-body">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                    <div class="panel-body">
                        <div class="row">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                                <li class="active"><a aria-expanded="true" href="#Actual" data-toggle="tab">Actual</a>
                                </li>
                                <li class=""><a aria-expanded="false" href="#Target" data-toggle="tab">Target</a>
                                </li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="Actual">

                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="panel panel-default">
                                                <div class="panel-body">
                                                    <form role="form" action="/InputData" method="post">
                                                        <input class="hidden" value="<%=project%>" name="project">
                                                        <input class="hidden" value="<%=bulan%>" name="bulan">
                                                        <input class="hidden" value="<%=tahun%>" name="tahun">
                                                    <div class="panel-group" id="accordionActual">
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">
                                                                <div class="active">
                                                                    <a data-toggle="collapse" data-parent="#RevenueActual" href="#collapseRevenueActual">
                                                                        Revenue
                                                                        <span class="fa arrow"></span>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div id="collapseRevenueActual" class="panel-collapse collapse">
                                                                <div class="panel-body">
                                                                    <div class="col-lg-12">
                                                                            <div class="form-group">
                                                                                <label>Spareparts</label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getSPAREPARTS_Actual()%>" value="<%=Data.getSPAREPARTS_Actual()%>" name="TextActualSpareParts">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Service (Labour) / SMC</label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getSMC_Actual()%>" value="<%=Data.getSMC_Actual()%>" name="TextActualSMC">
                                                                            </div>

                                                                            <div class="form-group">
                                                                                <label>Full Maintenance Contract / FMC</label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getFMS_Actual()%>" value="<%=Data.getFMS_Actual()%>" name="TextActualFMC">
                                                                            </div>

                                                                            <div class="form-group" align="center">
                                                                                <label>Revenue</label>
                                                                                <input class="form-control" disabled="" placeholder="<%="Rp. "+Data.getREVENUE_Actual()%>" value="<%="Rp. "+Data.getREVENUE_Actual()%>" name="TextActualRevenue">
                                                                            </div>
                                                                    </div>
                                                                </div>

                                                                <div class="panel-footer">
                                                                    <p class="help-block">Calculate before submit to check your data value</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">
                                                                <div class="active">
                                                                    <a data-toggle="collapse" data-parent="#CostActual" href="#collapseCostActual">Cost
                                                                        <span class="fa arrow"></span>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div id="collapseCostActual" class="panel-collapse collapse">
                                                                <div class="panel-body">
                                                                        <div class="col-lg-6">
                                                                            <div class="panel panel-info">
                                                                                <div class="panel-heading">
                                                                                    Service
                                                                                </div>
                                                                                <div class="panel-body">
                                                                                    <div class="form-group">
                                                                                        <label>Periodic Maintenance</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getPeriodicMaintenance_Actual()%>" value="<%=Data.getPeriodicMaintenance_Actual()%>" name="TextActualPeriodicMain">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>Part Repair</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getPartRepair_Actual()%>" value="<%=Data.getPartRepair_Actual()%>" name="TextActualPartRepair">
                                                                                    </div>

                                                                                    <div class="form-group">
                                                                                        <label>Part R & I</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getPartRAndI_Actual()%>" value="<%=Data.getPartRAndI_Actual()%>" name="TextActualPartRNI">
                                                                                    </div>

                                                                                    <div class="form-group">
                                                                                        <label>Component</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getComponent_Actual()%>" value="<%=Data.getComponent_Actual()%>" name="TextActualComponent">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>GET & Undercarriage Group</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getGETAndUndercarriageGroup_Actual()%>" value="<%=Data.getGETAndUndercarriageGroup_Actual()%>" name="TextActualUnderGroup">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>Warranty & Campaign</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getWarrantyAndCampaign_Actual()%>" value="<%=Data.getWarrantyAndCampaign_Actual()%>" name="TextActualWarranty">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>Consumable</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getConsumable_Actual()%>" value="<%=Data.getConsumable_Actual()%>" name="TextActualConsumable">
                                                                                    </div>
                                                                                    <div class="form-group" align="center">
                                                                                        <label>Cost Of Sales (Service)</label>
                                                                                        <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getCOSTOFSALES_SERVICE__Actual()%>" value="<%="Rp. "+Data.getCOSTOFSALES_SERVICE__Actual()%>" name="TextActualCOSService">
                                                                                    </div>
                                                                                </div>

                                                                                <div class="panel-footer">
                                                                                    <p class="help-block">Calculate before submit to check your data value</p>
                                                                                </div>
                                                                            </div>

                                                                        </div>

                                                                        <div class="col-lg-6">
                                                                            <div class="panel panel-info">
                                                                                <div class="panel-heading">
                                                                                    Spare Parts
                                                                                </div>
                                                                                <div class="panel-body">
                                                                                    <div class="form-group" align="center">
                                                                                        <label>Cost Of Sales (Spareparts)</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getCOSTOFSALES_SPAREPARTS__Actual()%>" value="<%=Data.getCOSTOFSALES_SPAREPARTS__Actual()%>" name="TextActualCOSSpareparts">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="panel-footer">
                                                                                    <p class="help-block">Calculate before submit to check your data value</p>
                                                                                </div>
                                                                            </div>

                                                                        </div>

                                                                    <br>
                                                                    <div class="col-lg-12">
                                                                        <div class="panel alert-info">
                                                                            <div class="form-group" align="center">
                                                                                <label>Total Cost Of Good Sold</label>
                                                                                <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getTOTALCOGS_Actual()%>" value="<%="Rp. "+Data.getTOTALCOGS_Actual()%>" name="TextActualTotalCOGS">
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                    <div class="col-lg-12">
                                                                        <div class="panel alert-info">
                                                                            <div class="form-group" align="center">
                                                                                <label>Gross Profit</label>
                                                                                <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getGROSSPROFIT_Actual()%>" value="<%="Rp. "+Data.getGROSSPROFIT_Actual()%>" name="TextActualGross">
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">
                                                                <div class="active">
                                                                    <a data-toggle="collapse" data-parent="#ExpensesActual" href="#collapseExpensesActual">Expenses
                                                                        <span class="fa arrow"></span>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div id="collapseExpensesActual" class="panel-collapse collapse">
                                                                <div class="panel-body">
                                                                    <div class="col-lg-12">
                                                                            <div class="form-group">
                                                                                <label>Employee Expenses </label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getEmployeeExpenses_Actual()%>" value="<%=Data.getEmployeeExpenses_Actual()%>" name="TextActualEmployee">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Asset Depreciation </label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getAssetDepreciation_Actual()%>" value="<%=Data.getAssetDepreciation_Actual()%>" name="TextActualDeprecation">
                                                                            </div>

                                                                            <div class="form-group">
                                                                                <label>Operation Expenses </label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getOperationExpenses_Actual()%>" value="<%=Data.getOperationExpenses_Actual()%>" name="TextActualOperation">
                                                                            </div>

                                                                            <div class="form-group" align="center">
                                                                                <label>Expenses</label>
                                                                                <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getEXPENSES_Actual()%>" value="<%="Rp. "+Data.getEXPENSES_Actual()%>" name="TextActualExpenses">

                                                                            </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel-footer">
                                                                    <p class="help-block">Calculate before submit to check your data value</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                        <div class="panel panel-green">
                                                            <div class="panel-heading">
                                                            </div>
                                                            <div class="panel-body">
                                                                <div class="col-lg-12">
                                                                    <div class="form-group">
                                                                        <label>Operational Profit</label>
                                                                        <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getOPRPROFIT_Actual()%>" value="<%="Rp. "+Data.getOPRPROFIT_Actual()%>" name="TextActualOPR">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Profit Percent of Sales</label>
                                                                        <input class="form-control" disabled=""  placeholder="<%=Data.getPROFITPercentOFSALESActual()+" %"%>" value="<%=Data.getPROFITPercentOFSALESActual()+" %"%>" name="TextActualPercent">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel-footer">
                                                                <p class="help-block">Fill data above</p>
                                                            </div>
                                                        </div>

                                                        <div class="panel" align="center">
                                                            <button type="submit" class="btn btn-default" name="action" value="calculate">Calculate</button>
                                                            <button type="submit" class="btn btn-default" name="action" value="submit">Submit Button</button>
                                                            <button type="reset" class="btn btn-default">Reset Button</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- .panel-body -->
                                    </div>
                                    <!-- /.panel -->
                                </div>

                                <%--target mamen--%>
                                <div class="tab-pane fade" id="Target">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="panel panel-default">
                                                <div class="panel-body">
                                                    <form role="form" action="/InputData" method="post">
                                                        <input class="hidden" value="<%=project%>" name="project">
                                                        <input class="hidden" value="<%=bulan%>" name="bulan">
                                                        <input class="hidden" value="<%=tahun%>" name="tahun">
                                                        <input class="hidden" value="target" name="tipe">
                                                        <div class="panel-group" id="accordionTarget">
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <div class="active">
                                                                        <a data-toggle="collapse" data-parent="#RevenueTarget" href="#collapseRevenueTarget">
                                                                            Revenue
                                                                            <span class="fa arrow"></span>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseRevenueTarget" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <div class="col-lg-12">
                                                                            <div class="form-group">
                                                                                <label>Spareparts</label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getSPAREPARTS_Target()%>" value="<%=Data.getSPAREPARTS_Target()%>" name="TextTargetSpareParts">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Service (Labour) / SMC</label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getSMC_Target()%>" value="<%=Data.getSMC_Target()%>" name="TextTargetSMC">
                                                                            </div>

                                                                            <div class="form-group">
                                                                                <label>Full Maintenance Contract / FMC</label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getFMS_Target()%>" value="<%=Data.getFMS_Target()%>" name="TextTargetFMC">
                                                                            </div>

                                                                            <div class="form-group" align="center">
                                                                                <label>Revenue</label>
                                                                                <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getREVENUE_Target()%>" value="<%="Rp. "+Data.getREVENUE_Target()%>" name="TextTargetRevenue">
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                    <div class="panel-footer">
                                                                        <p class="help-block">Calculate before submit to check your data value</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <div class="active">
                                                                        <a data-toggle="collapse" data-parent="#CostTarget" href="#collapseCostTarget">
                                                                            Cost
                                                                            <span class="fa arrow"></span>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseCostTarget" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <div class="col-lg-6">
                                                                            <div class="panel panel-info">
                                                                                <div class="panel-heading">
                                                                                    Service
                                                                                </div>
                                                                                <div class="panel-body">
                                                                                    <div class="form-group">
                                                                                        <label>Periodic Maintenance</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getPeriodicMaintenance_Target()%>" value="<%=Data.getPeriodicMaintenance_Target()%>" name="TextTargetPeriodicMain">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>Part Repair</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getPartRepair_Target()%>" value="<%=Data.getPartRepair_Target()%>" name="TextTargetPartRepair">
                                                                                    </div>

                                                                                    <div class="form-group">
                                                                                        <label>Part R & I</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getPartRAndI_Target()%>" value="<%=Data.getPartRAndI_Target()%>" name="TextTargetPartRNI">
                                                                                    </div>

                                                                                    <div class="form-group">
                                                                                        <label>Component</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getComponent_Target()%>" value="<%=Data.getComponent_Target()%>" name="TextTargetComponent">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>GET & Undercarriage Group</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getGETAndUndercarriageGroup_Target()%>" value="<%=Data.getGETAndUndercarriageGroup_Target()%>" name="TextTargetUnderGroup">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>Warranty & Campaign</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getWarrantyAndCampaign_Target()%>" value="<%=Data.getWarrantyAndCampaign_Target()%>" name="TextTargetWarranty">
                                                                                    </div>
                                                                                    <div class="form-group">
                                                                                        <label>Consumable</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getConsumable_Target()%>" value="<%=Data.getConsumable_Target()%>" name="TextTargetConsumable">
                                                                                    </div>
                                                                                    <div class="form-group" align="center">
                                                                                        <label>Cost Of Sales (Service)</label>
                                                                                        <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getCOSTOFSALES_SERVICE__Target()%>" value="<%="Rp. "+Data.getCOSTOFSALES_SERVICE__Target()%>" name="TextTargetCOSService">
                                                                                    </div>
                                                                                </div>

                                                                                <div class="panel-footer">
                                                                                    <p class="help-block">Calculate before submit to check your data value</p>
                                                                                </div>
                                                                            </div>

                                                                        </div>

                                                                        <div class="col-lg-6">
                                                                            <div class="panel panel-info">
                                                                                <div class="panel-heading">
                                                                                    Spare Parts
                                                                                </div>
                                                                                <div class="panel-body">
                                                                                    <div class="form-group" align="center">
                                                                                        <label>Cost Of Sales (Spareparts)</label>
                                                                                        <input class="form-control"  placeholder="<%="Rp. "+Data.getCOSTOFSALES_SPAREPARTS__Target()%>" value="<%=Data.getCOSTOFSALES_SPAREPARTS__Target()%>" name="TextTargetCOSSpareparts">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="panel-footer">
                                                                                    <p class="help-block">Calculate before submit to check your data value</p>
                                                                                </div>
                                                                            </div>

                                                                        </div>

                                                                        <br>
                                                                        <div class="col-lg-12">
                                                                            <div class="panel alert-info">
                                                                        <div class="form-group" align="center">
                                                                            <label>Total Cost Of Good Sold</label>
                                                                            <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getTOTALCOGS_Target()%>" value="<%="Rp. "+Data.getTOTALCOGS_Target()%>" name="TextTargetTotalCOGS">
                                                                        </div>
                                                                            </div>
                                                                        </div>

                                                                        <div class="col-lg-12">
                                                                            <div class="panel alert-info">
                                                                                <div class="form-group" align="center">
                                                                                    <label>Gross Profit</label>
                                                                                    <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getGROSSPROFIT_Target()%>" value="<%="Rp. "+Data.getGROSSPROFIT_Target()%>" name="TextTargetGross">
                                                                                </div>
                                                                            </div>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading">
                                                                    <div class="active">
                                                                        <a data-toggle="collapse" data-parent="#ExpensesTarget" href="#collapseExpensesTarget">
                                                                            Expenses
                                                                            <span class="fa arrow"></span>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseExpensesTarget" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <div class="col-lg-12">
                                                                            <div class="form-group">
                                                                                <label>Employee Expenses </label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getEmployeeExpenses_Target()%>" value="<%=Data.getEmployeeExpenses_Target()%>" name="TextTargetEmployee">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Asset Depreciation </label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getAssetDepreciation_Target()%>" value="<%=Data.getAssetDepreciation_Target()%>" name="TextTargetDeprecation">
                                                                            </div>

                                                                            <div class="form-group">
                                                                                <label>Operation Expenses </label>
                                                                                <input class="form-control"  placeholder="<%="Rp. "+Data.getOperationExpenses_Target()%>" value="<%=Data.getOperationExpenses_Target()%>" name="TextTargetOperation">
                                                                            </div>

                                                                            <div class="form-group" align="center">
                                                                                <label>Expenses</label>
                                                                                <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getEXPENSES_Target()%>" value="<%="Rp. "+Data.getEXPENSES_Target()%>" name="TextTargetExpenses">

                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="panel-footer">
                                                                        <p class="help-block">Calculate before submit to check your data value</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="panel panel-green">
                                                            <div class="panel-heading">
                                                            </div>
                                                            <div class="panel-body">
                                                                <div class="col-lg-12">
                                                                    <div class="form-group">
                                                                        <label>Operational Profit</label>
                                                                        <input class="form-control" disabled=""  placeholder="<%="Rp. "+Data.getOPRPROFIT_Target()%>" value="<%="Rp. "+Data.getOPRPROFIT_Target()%>" name="TextTargetOPR">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Profit Percent of Sales</label>
                                                                        <input class="form-control" disabled=""  placeholder="<%=Data.getPROFITPercentOFSALESTarget()+" %"%>" value="<%=Data.getPROFITPercentOFSALESTarget()+" %"%>" name="TextTargetPercent">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="panel-footer">
                                                                <p class="help-block">Fill data above</p>
                                                            </div>
                                                        </div>

                                                        <div class="panel" align="center">
                                                            <button type="submit" class="btn btn-default" name="action" value="calculate">Calculate</button>
                                                            <button type="submit" class="btn btn-default" name="action" value="submit">Submit Button</button>
                                                            <button type="reset" class="btn btn-default">Reset Button</button>
                                                        </div>

                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- .panel-body -->
                                    </div>
                                    <!-- /.panel -->
                                </div>



                            </div>
                            <%-- /.tab content--%>

                        </div>
                        <!-- /.row input form -->
                        <div class="row">

                                    <!-- /.panel-heading -->
                                    <div class="panel-body">
                                        <div class="flot-chart">
                                            <div class="flot-chart-content" id="flot-line-chart"></div>
                                        </div>
                                    </div>
                                    <!-- /.panel-body -->


                        </div>
                        <!-- /.row line chart -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
</div>
            </div>
        </div>

        </div>
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

<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

<!-- Flot Charts JavaScript -->
<script src="../bower_components/flot/excanvas.min.js"></script>
<script src="../bower_components/flot/jquery.flot.js"></script>
<script src="../bower_components/flot/jquery.flot.resize.js"></script>
<script src="../bower_components/flot/jquery.flot.time.js"></script>
<script src="../bower_components/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
<%
    String[] actual = FF.SetTempData("SELECT `REVENUE`  FROM `DetailRincian` WHERE `Project` = '" + project + "' AND `Tahun`='" + tahun + "' AND `Bulan`<=" + bulan + " AND `Tipe`='Actual';");
    String[] target = FF.SetTempData("SELECT `REVENUE`  FROM `DetailRincian` WHERE `Project` = '"+project+"' AND `Tahun`='"+tahun+"' AND `Bulan`<="+bulan+" AND `Tipe`='Target';");
%>
<script type="text/javascript">

    //Flot Line Chart
    $(document).ready(function() {
        console.log("document ready");
        var offset = 0;
        plot();

        function plot() {
            var actual = [],
                    target = [];

            <%
            for (int i = 0; i < actual.length; i ++) {
            %>
                actual.push([<%=i%>, <%=Integer.parseInt(actual[i])%>]);
                target.push([<%=i%>, <%=Integer.parseInt(target[i])%>]);
            <%
            }
            %>

            var options = {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                grid: {
                    hoverable: true //IMPORTANT! this is needed for tooltip to work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "'%s' revenue bulan ke-%x <%=tahun%> : %y",
                    shifts: {
                        x: -60,
                        y: 25
                    }
                }
            };

            var plotObj = $.plot($("#flot-line-chart"), [{
                        data: actual,
                        label: "Actual"
                    }, {
                        data: target,
                        label: "Target"
                    }],
                    options);
        }
    });

</script>


</body>

</html>
