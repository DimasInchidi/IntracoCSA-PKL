<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="servlet.O_DataDetails" %>
<%@ page import="servlet.F_Function" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data Details</title>
  <%
    if(session.getAttribute("user")==null || session.getAttribute("user").toString().trim().equals("")) {response.sendRedirect("/login");}
      F_Function FF = new F_Function();
      SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      Date dt = new Date();
      Calendar cal = Calendar.getInstance();
      String tglnye = date.format(dt);
    String exportToExcel = request.getParameter("exportToExcel");
    if (exportToExcel != null
            && exportToExcel.toString().equalsIgnoreCase("true")) {
      response.setContentType("application/vnd.ms-excel");
      response.setHeader("Content-Disposition", "inline; filename="
              + "Details "+tglnye+".xls");
    }
    O_DataDetails Data = FF.DataDetails(session.getAttribute("level").toString());
    String[] Desc = {"SPARE PARTS", "SERVICE (LABOUR)/SMC", "FULL MAINTENANCE CONTRACT/FMS", "REVENUE", "COST OF SALES (SPARE PARTS)", "COST OF SALES (SERVICE)", "- Periodic Maintenance", "- Part Repair", "- Part R & I", "- Component", "- GET & Undercarriage Group", "-Warranty & Campaign", "- Consumable", "TOTAL COGS", "GROSS PROFIT", "EXPENSES", "- Employee Expenses", "- Asset Depreciation", "- Operation Expenses", "OPR. PROFIT", "PROFIT % OF SALES"};
  %>

  <!-- Bootstrap Core CSS -->
  <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>PT. INTRACO PENTA PRIMA SERVIS</h3>
<h3>CSA GOLD FINANCIAL REPORT TAHUN <%=cal.get(Calendar.YEAR)%></h3>
<h3>CSA PROFITABILITY REPORT <%=cal.get(Calendar.YEAR)%> (In thousand IDR)</h3>
<br>
<table border="0" >

  <tr>
    <td>

      <table border="1" class="text-nowrap">
        <tr>
          <th rowspan="2">PROJECT</th>
          <th rowspan="2">DESCRIPTION</th>
          <td colspan="3" align="center">TOTAL</td>
        </tr>
        <tr>
          <td>TARGET</td>
          <td>ACTUAL</td>
          <td>%</td>
        </tr>

        <tr>
          <th rowspan="21"><%="project"%></th>
          <td height="100%"><%=Desc[0]%></td>
        </tr>
        <%for (int desc=1;desc<Desc.length;desc++){
          out.println("<tr><td>"+Desc[desc]+"</td></tr>");
        }
        %>
      </table>

    </td>
    <%for (int bulan=0;bulan<11;bulan++){%>
    <td>
      <table border="1">
        <tr>
          <td colspan="2" align="center"><%=bulan%></td>
        </tr>
        <tr>
          <td>TARGET</td>
          <td>ACTUAL</td>
        </tr>
        <%
            for (int desc=0;desc<Desc.length;desc++){
              out.println("<tr><td>"+"nilaiTarget"+"</td><td>"+"nilaiActual"+"</td></tr>");
            }
        %>
      </table>

    </td>
    <%}
    %>

  </tr>
  <tr>
    <td>

      <table border="1" class="text-nowrap">
        <tr>
          <th rowspan="2">PROJECT</th>
          <th rowspan="2">DESCRIPTION</th>
          <td colspan="3" align="center">TOTAL</td>
        </tr>
        <tr>
          <td>TARGET</td>
          <td>ACTUAL</td>
          <td>%</td>
        </tr>

        <tr>
          <th rowspan="21"><%="project"%></th>
          <td height="100%"><%=Desc[0]%></td>
        </tr>
        <%for (int desc=1;desc<Desc.length;desc++){
          out.println("<tr><td>"+Desc[desc]+"</td></tr>");
        }
        %>
      </table>

    </td>
    <%for (int bulan=0;bulan<11;bulan++){%>
    <td>
      <table border="1">
        <tr>
          <td colspan="2" align="center"><%=bulan%></td>
        </tr>
        <tr>
          <td>TARGET</td>
          <td>ACTUAL</td>
        </tr>
        <%
          for (int desc=0;desc<Desc.length;desc++){
            out.println("<tr><td>"+"nilaiTarget"+"</td><td>"+"nilaiActual"+"</td></tr>");
          }
        %>
      </table>

    </td>
    <%}
    %>

  </tr>
</table>
</body>
</html>
