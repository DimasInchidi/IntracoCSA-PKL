/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.15
 * Generated at: 2015-11-30 14:22:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.IPPS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import servlet.F_TimeManagement;
import servlet.F_Function;
import servlet.O_DataTables;
import java.util.Calendar;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"Dashboard Page CSA\">\n");
      out.write("    <meta name=\"author\" content=\"DimasInchidi\">\n");
      out.write("\n");
      out.write("    <title>Dashboard - PT Intraco Penta Prima Servis</title>\n");
      out.write("    <link rel=\"shortcut icon\" href=\"img/favicon.ico\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"../bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- MetisMenu CSS -->\n");
      out.write("    <link href=\"../bower_components/metisMenu/dist/metisMenu.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Timeline CSS -->\n");
      out.write("    <link href=\"../dist/css/timeline.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"../dist/css/sb-admin-2.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Morris Charts CSS -->\n");
      out.write("    <link href=\"../bower_components/morrisjs/morris.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"../bower_components/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"\">Dashboard</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-header -->\n");
      out.write("\n");
      out.write("            <ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                        <i class=\"fa fa-envelope fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-messages\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <strong>John Smith</strong>\n");
      out.write("                                    <span class=\"pull-right text-muted\">\n");
      out.write("                                        <em>Yesterday</em>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <strong>John Smith</strong>\n");
      out.write("                                    <span class=\"pull-right text-muted\">\n");
      out.write("                                        <em>Yesterday</em>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <strong>John Smith</strong>\n");
      out.write("                                    <span class=\"pull-right text-muted\">\n");
      out.write("                                        <em>Yesterday</em>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"text-center\" href=\"#\">\n");
      out.write("                                <strong>Read All Messages</strong>\n");
      out.write("                                <i class=\"fa fa-angle-right\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!-- /.dropdown-messages -->\n");
      out.write("                </li>\n");
      out.write("                <!-- /.dropdown -->\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                        <i class=\"fa fa-user fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                        <li><a href=\"/profile\"><i class=\"fa fa-user fa-fw\"></i> Hi, ");
      out.print(session.getAttribute("nama"));
      out.write("</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                            if (session.getAttribute("level") == null || session.getAttribute("level").toString().contains("Admin")) {
                               out.print("<li ><a href = \"/manage+user\" ><i class=\"fa fa-gear fa-fw\" ></i > Manage Users</a ></li >");
                            }
                        
      out.write("\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li><a href=\"/Logout\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!-- /.dropdown-user -->\n");
      out.write("                </li>\n");
      out.write("                <!-- /.dropdown -->\n");
      out.write("            </ul>\n");
      out.write("            <!-- /.navbar-top-links -->\n");
      out.write("\n");
      out.write("            <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("                <div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("                    <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("                        <li class=\"sidebar-search\">\n");
      out.write("                            <div class=\"input-group custom-search-form\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\n");
      out.write("                                <span class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("                                    <i class=\"fa fa-google\"></i>\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                </button>\n");
      out.write("                            </span>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /input-group -->\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"/dashboard\"><i class=\"fa fa-dashboard fa-fw\"></i> Dashboard</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"/input+data\"><i class=\"fa fa-edit fa-fw\"></i> Update Data</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"/lihat+data\"><i class=\"fa fa-bar-chart-o fa-fw\"></i> Lihat Data</a>\n");
      out.write("                            <!-- /.nav-second-level -->\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.sidebar-collapse -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-static-side -->\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("            <br>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"panel panel-info\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <form action= \"\" method= \"GET\" >\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-5\">\n");
      out.write("                                        ");

                                            if (session.getAttribute("level") ==null || session.getAttribute("level").toString().contains("Admin")) {
                                                out.print(Data.getDataProyek());
                                            }else{
                                                out.print(session.getAttribute("level"));
                                                out.print("<input name=\"project\" class=\"hidden\" value=\""+session.getAttribute("level")+"\">");
                                            }
                                        
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"col-md-2\">\n");
      out.write("                                        <select name=\"month\" class=\"form-control\" >\n");
      out.write("                                            ");

                                                int Bulan = Data.getBulanDataHome();
                                                for (int i=0; i<12;i++){
                                                    if(i==Bulan){
                                                        out.print("<option selected value=\"" + i + "\">" + FT.getBulan(i) + "</option>");
                                                    }else {
                                                        out.print("<option value=\"" + i + "\">" + FT.getBulan(i) + "</option>");
                                                    }
                                                }
                                            
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                        <div class=\"col-md-4\">\n");
      out.write("                                        <input class=\"form-control\" value=\"");
      out.print(Data.getTahunDataHome());
      out.write("\" name=\"year\" type=\"number\" autofocus>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-1\" align=\"right\">\n");
      out.write("                                        <button class=\"btn btn-default btn-circle\" type= \"submit\"/>\n");
      out.write("                                        <i class=\"fa fa-refresh\"></i>\n");
      out.write("                                        </button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.panel-heading -->\n");
      out.write("\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <!-- Nav tabs -->\n");
      out.write("                            <ul class=\"nav nav-pills\">\n");
      out.write("                                <li class=\"active\"><a aria-expanded=\"true\" href=\"#ThisMonth\" data-toggle=\"tab\">This Month</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"\"><a aria-expanded=\"false\" href=\"#YTD\" data-toggle=\"tab\">Year To Date</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"\"><a aria-expanded=\"false\" href=\"#ActualVSBudget\" data-toggle=\"tab\">Actual VS Budget</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                            <!-- Tab panes -->\n");
      out.write("                            <div class=\"tab-content\">\n");
      out.write("                                <div class=\"tab-pane fade active in\" id=\"ThisMonth\">\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <div class=\"table-responsive\">\n");
      out.write("                                            <table class=\"table table-striped\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>Target</th>\n");
      out.write("                                                    <th>Actual</th>\n");
      out.write("                                                    <th>Percent</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody>\n");
      out.write("                                                ");
      out.print(Data.getTableMonth() );
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                        <!-- /.table-responsive -->\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.panel-body -->\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"YTD\">\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <div class=\"table-responsive\">\n");
      out.write("                                            <table class=\"table table-striped\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>Target</th>\n");
      out.write("                                                    <th>Actual</th>\n");
      out.write("                                                    <th>Percent</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody>\n");
      out.write("                                                ");
      out.print(Data.getTableYTD() );
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                        <!-- /.table-responsive -->\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.panel-body -->\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"ActualVSBudget\">\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <div class=\"table-responsive\">\n");
      out.write("                                            <table class=\"table table-striped\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>Target</th>\n");
      out.write("                                                    <th>Actual</th>\n");
      out.write("                                                    <th>Percent</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody>\n");
      out.write("                                                ");
      out.print(Data.getTableAVB());
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                        <!-- /.table-responsive -->\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.panel-body -->\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.panel -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.row -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"../bower_components/jquery/dist/jquery.min.js\"></script>\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"../bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- Metis Menu Plugin JavaScript -->\n");
      out.write("    <script src=\"../bower_components/metisMenu/dist/metisMenu.min.js\"></script>\n");
      out.write("    <!-- Morris Charts JavaScript -->\n");
      out.write("    <script src=\"../bower_components/raphael/raphael-min.js\"></script>\n");
      out.write("    <script src=\"../bower_components/morrisjs/morris.min.js\"></script>\n");
      out.write("    <script src=\"../js/morris-data.js\"></script>\n");
      out.write("    <!-- Custom Theme JavaScript -->\n");
      out.write("    <script src=\"../dist/js/sb-admin-2.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
