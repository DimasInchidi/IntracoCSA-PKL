<%--suppress CssInvalidPropertyValue --%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="servlet.O_DataDetails" %>
<%@ page import="servlet.F_Function" %>
<%@ page import="servlet.F_TimeManagement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Data Details</title>
  <%
    if(session.getAttribute("user")==null || session.getAttribute("user").toString().trim().equals("")) {response.sendRedirect("/login");}
    F_Function FF = new F_Function();
    F_TimeManagement FT = new F_TimeManagement();

    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date dt = new Date();
    Calendar cal = Calendar.getInstance();
    String Tahun =Integer.toString(cal.get(Calendar.YEAR));
    String tglnye = date.format(dt);
    String exportToExcel = request.getParameter("exportToExcel");
    if (exportToExcel != null
            && exportToExcel.toString().equalsIgnoreCase("true")) {
      response.setContentType("application/vnd.ms-excel");
      response.setHeader("Content-Disposition", "inline; filename="
              + "Details "+tglnye+".xls");
    }
    O_DataDetails Data = FF.DataDetails(session.getAttribute("level").toString());
    //<td style="text-align:left;width:2.3236in; " ></td>
    String[] Desc = {"<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce8\">SERVICE (LABOUR)/SMC</td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce8\">FULL MAINTENANCE CONTRACT/FMS</td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce9\"><b>REVENUE</b></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce8\">COST OF SALES (SPARE PARTS)</td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce8\">COST OF SALES (SERVICE)</td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Periodic Maintenance</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Part Repair</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Part R & I</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Component</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- GET & Undercarriage Group</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Warranty & Campaign</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Consumable</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce9\"><b>TOTAL COGS</b></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce9\"><b>GROSS PROFIT</b></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce9\"><b>EXPENSES</b></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Employee Expenses</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Asset Depreciation</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce11\"><i>- Operation Expenses</i></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce9\"><b>OPR. PROFIT</b></td>",
            "<td colspan=\"3\" style=\"text-align:left;width:2.3236in; \" class=\"ce9\"><b>PROFIT % OF SALES</b></td>"};

    String[] Bulan = {"Jan-"+Tahun, "Feb-"+Tahun, "Mar-"+Tahun, "Apr-"+Tahun, "May-"+Tahun, "Jun-"+Tahun, "Jul-"+Tahun, "Aug-"+Tahun, "Sep-"+Tahun, "Oct-"+Tahun, "Nov-"+Tahun, "Dec-"+Tahun };
    //<td rowspan="21" style="text-align:left;width:1.5035in; " ></td>
    String[] Project = {
            "<td rowspan=\"21\" align=\"center\" class=\"ce2\">FMC KPC</td>",
            "<td rowspan=\"21\" align=\"center\" style=\"text-align:center;width:1.5035in; \" bgcolor=\"#d9d9d9\" class=\"ce3\">FMC RCI</td>",
            "<td rowspan=\"21\" align=\"center\" style=\"text-align:center;width:1.5035in; \" bgcolor=\"#ffffff\" class=\"ce2\">FMC ANTAM</td>",
            "<td rowspan=\"21\" align=\"center\" style=\"text-align:center;width:1.5035in; \" bgcolor=\"#d9d9d9\" class=\"ce3\">FMC TRIWISNNA</td>",
            "<td rowspan=\"21\" align=\"center\" style=\"text-align:center;width:1.5035in; \" bgcolor=\"#ffffff\" class=\"ce2\">FMC PMJ</td>",
            "<td rowspan=\"21\" align=\"center\" style=\"text-align:center;width:1.5035in; \" bgcolor=\"#4bacc6\" class=\"ce5\">TOTAL</td>"};
  %>
  <!-- Bootstrap Core CSS -->
  <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<table border="0" cellspacing="1" cellpadding="1" class="text-nowrap" >
  <tr class="ro1">
    <td style="text-align:left;width:1.5035in; " > </td>
    <td style="text-align:left;width:2.3236in; " > </td>
    <td style="text-align:left;width:1.1882in; " > </td>
    <td style="text-align:left;width:1.3772in; " > </td>
    <td style="text-align:left;width:0.5701in; " > </td>
    <td style="text-align:left;width:0.2425in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
  </tr>
  <tr class="ro1">
    <td style="text-align:left;width:1.5035in; " > </td>
    <td colspan="13" style="text-align:left;width:2.3236in; " ><p>PT. INTRACO PENTA PRIMA SERVIS</p></td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
  </tr>
  <tr class="ro1">
    <td style="text-align:left;width:1.5035in; " > </td>
    <td colspan="13" style="text-align:left;width:2.3236in; " ><p>CSA GOLD FINANCIAL REPORT TAHUN
      2015</p></td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
  </tr>
  <tr class="ro1">
    <td style="text-align:left;width:1.5035in; " > </td>
    <td colspan="13" style="text-align:left;width:2.3236in; " ><p>CSA PROFITABILITY REPORT 2015 (In
      thousand IDR)</p></td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
  </tr>
  <tr class="ro1">
    <td style="text-align:left;width:1.5035in; " > </td>
    <td style="text-align:left;width:2.3236in; " > </td>
    <td style="text-align:left;width:1.1882in; " > </td>
    <td style="text-align:left;width:1.3772in; " > </td>
    <td style="text-align:left;width:0.5701in; " > </td>
    <td style="text-align:left;width:0.2425in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:1.1126in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
    <td style="text-align:left;width:1.0874in; " > </td>
    <td style="text-align:left;width:0.7846in; " > </td>
  </tr>
</table>

<table valign="middle" border="1" cellspacing="1" cellpadding="1" class="text-nowrap" >
  <tr class="ro1">
    <td rowspan="2" align="center" bgcolor="#ffc000" ><p>PROJECT</p></td>
    <td colspan="3" rowspan="2" align="center" width="100%" bgcolor="#ffc000" ><p>DESCRIPTION</p></td>
    <td colspan="3" align="center" bgcolor="#ffc000" ><p>TOTAL</p></td>
    <td style="text-align:left;width:0.2425in; "bgcolor="#ffc000" > </td>

    <%
      for(String hasil:Bulan) {%>
    <td colspan="2" align="center" style="text-align:right; width:1.0874in; "bgcolor="#ffc000" ><p><%=hasil%></p></td>
    <%
      }
    %>

  </tr>
  <tr class="ro1">
    <td style="text-align:left;width:1.1882in; " bgcolor="#ffc000" align="center" ><p>TARGET</p></td>
    <td style="text-align:left;width:1.3772in; " bgcolor="#ffc000" align="center" ><p>ACTUAL</p></td>
    <td style="text-align:left;width:0.5701in; " bgcolor="#ffc000" align="center" ><p>%</p></td>
    <td style="text-align:left;width:0.2425in; " bgcolor="#ffc000" align="center" > </td>
    <%
      for(int ta=0; ta<12; ta++ ){
    %>
    <td style="text-align:left;width:1.0874in; " bgcolor="#ffc000" align="center" ><p>TARGET</p></td>
    <td style="text-align:left;width:1.0874in; " bgcolor="#ffc000" align="center" ><p>ACTUAL</p></td>
    <%
      }
    %>

  </tr>
  <%
    for(String PJ:Project) {%>

  <tr class="ro1">
    <%=PJ%>
    <td colspan="3" style="text-align:left;width:2.3236in; " ><p>SPARE PARTS</p></td>
    <td style="text-align:right; width:1.1882in; " ><p>Project Target</p></td>
    <td style="text-align:right; width:1.3772in; " ><p>Project Actual</p></td>
    <td style="text-align:right; width:0.5701in; " ><p>Project % Total</p></td>
    <td style="text-align:left;width:0.2425in; "bgcolor="#d9d9d9" > </td>
    <%
      for(int jeda=0; jeda<12; jeda++ ){
    %>
    <td style="text-align:left;width:1.0874in; " ><p>Project Target</p></td>
    <td style="text-align:left;width:1.0874in; " ><p>Project Actual</p></td>
    <%
      }
    %>
  </tr>

  <%
    for(String hasil:Desc) {%>


  <tr class="ro1" >
    <%=hasil%>
    <td style = "text-align:right; width:1.1882in; "  ><p > Project Target </p ></td >
    <td style = "text-align:right; width:1.3772in; "  ><p > Project Actual </p ></td >
    <td style = "text-align:right; width:0.5701in; "  ><p > Project % Total</p ></td >
    <td style = "text-align:left;width:0.2425in; "bgcolor="#d9d9d9"  > </td >
    <%
      for(int nilai=0; nilai<12; nilai++ ){
    %>
    <td style = "text-align:right; width:1.0874in; "  ><p > Project Target</p ></td >
    <td style = "text-align:right; width:1.0874in; "  ><p > Project Actual </p ></td >
    <%
      }
    %>
  </tr >
  <%
    }

  %>
  <%
    }
  %>

</table>
</body>
</html>
