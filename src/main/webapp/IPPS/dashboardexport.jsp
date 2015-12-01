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
              + "CSA Performance Dashboard "+tglnye+".xls");
    }
  %>
  <!-- Bootstrap Core CSS -->
  <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body text="#000000" link="#000000" alink="#000000" vlink="#000000">
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr><td width="50%">&nbsp;</td><td align="center">

    <a name="JR_PAGE_ANCHOR_0_1"></a>
    <table class="jrPage" cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 842px; border-collapse: collapse; background-color: white;">
      <tr valign="top" style="height:0">
        <td style="width:20px"></td>
        <td style="width:50px"></td>
        <td style="width:200px"></td>
        <td style="width:100px"></td>
        <td style="width:40px"></td>
        <td style="width:11px"></td>
        <td style="width:49px"></td>
        <td style="width:301px"></td>
        <td style="width:40px"></td>
      </tr>
      <tr valign="top" style="height:20px">
        <td colspan="14">
        </td>
      </tr>
      <tr valign="top" style="height:30px">
        <td>
        </td>
        <td colspan="2" rowspan="2">
          <img src="report122929157175106646.html_files/img_0_0_0" style="height: 60px" alt=""/></td>
        <td colspan="7" style="text-indent: 0px;  vertical-align: middle;text-align: center;">
          <span style="font-family: Arial; color: #000000; font-size: 20px; line-height: 1.1499023; font-weight: bold;">CSA PERFORMANCE DASHBOARD 2015</span></td>
        <td colspan="4">
        </td>
      </tr>
      <tr valign="top" style="height:30px">
        <td>
        </td>
        <td colspan="7" style="text-indent: 0px;  vertical-align: middle;text-align: center;">
          <span style="font-family: Arial; color: #000000; font-size: 16px; line-height: 1.1499023; font-weight: bold;">PERIODE JULY 2015</span></td>
        <td colspan="4">
        </td>
      </tr>
      <tr valign="top" style="height:10px">
        <td colspan="14">
        </td>
      </tr>
      <tr valign="top" style="height:200px">
        <td colspan="2">
        </td>
        <td colspan="2" rowspan="2">
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:300px"></td>
                </tr>
                <tr valign="top" style="height:220px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_0_3_0" style="width: 300px; height: 220px" alt=""/></td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:10px"></td>
                  <td style="width:280px"></td>
                  <td style="width:10px"></td>
                </tr>
                <tr valign="top" style="height:200px">
                  <td>
                  </td>
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:280px"></td>
                          </tr>
                          <tr valign="top" style="height:200px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_0_3_1" style="height: 200px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:110px"></td>
                            <td style="width:60px"></td>
                            <td style="width:110px"></td>
                          </tr>
                          <tr valign="top" style="height:140px">
                            <td colspan="3">
                            </td>
                          </tr>
                          <tr valign="top" style="height:50px">
                            <td>
                            </td>
                            <td>
                              <div style="width: 100%; height: 100%; position: relative;">
                                <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                                  <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                                    <tr valign="top" style="height:0">
                                      <td style="width:60px"></td>
                                    </tr>
                                    <tr valign="top" style="height:50px">
                                      <td style="pointer-events: auto; background-color: #2C2C2C; border: 1px solid #2C2C2C; ">
                                      </td>
                                    </tr>
                                  </table>
                                </div>
                                <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                                  <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                                    <tr valign="top" style="height:0">
                                      <td style="width:60px"></td>
                                    </tr>
                                    <tr valign="top" style="height:50px">
                                      <td style="pointer-events: auto; text-indent: 0px;  vertical-align: middle;text-align: center;">
                                        <span style="font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif; color: #FAFAFA; font-size: 18px; line-height: 1.1640625; font-weight: bold;">134</span></td>
                                    </tr>
                                  </table>
                                </div>
                              </div>
                            </td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:10px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr valign="top" style="height:20px">
                  <td colspan="3">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td colspan="3">
        </td>
        <td rowspan="2">
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:300px"></td>
                  <td style="width:1px"></td>
                </tr>
                <tr valign="top" style="height:220px">
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:300px"></td>
                          </tr>
                          <tr valign="top" style="height:220px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_0_4_0" style="width: 300px; height: 220px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:10px"></td>
                            <td style="width:280px"></td>
                            <td style="width:10px"></td>
                          </tr>
                          <tr valign="top" style="height:200px">
                            <td>
                            </td>
                            <td>
                              <div style="width: 100%; height: 100%; position: relative;">
                                <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                                  <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                                    <tr valign="top" style="height:0">
                                      <td style="width:280px"></td>
                                    </tr>
                                    <tr valign="top" style="height:200px">
                                      <td style="pointer-events: auto; ">
                                        <img src="report122929157175106646.html_files/img_0_0_4_1" style="height: 200px" alt=""/></td>
                                    </tr>
                                  </table>
                                </div>
                                <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                                  <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                                    <tr valign="top" style="height:0">
                                      <td style="width:111px"></td>
                                      <td style="width:59px"></td>
                                      <td style="width:110px"></td>
                                    </tr>
                                    <tr valign="top" style="height:140px">
                                      <td colspan="3">
                                      </td>
                                    </tr>
                                    <tr valign="top" style="height:50px">
                                      <td>
                                      </td>
                                      <td>
                                        <div style="width: 100%; height: 100%; position: relative;">
                                          <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                                            <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                                              <tr valign="top" style="height:0">
                                                <td style="width:59px"></td>
                                              </tr>
                                              <tr valign="top" style="height:50px">
                                                <td style="pointer-events: auto; background-color: #2C2C2C; border: 1px solid #2C2C2C; ">
                                                </td>
                                              </tr>
                                            </table>
                                          </div>
                                          <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                                            <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                                              <tr valign="top" style="height:0">
                                                <td style="width:59px"></td>
                                              </tr>
                                              <tr valign="top" style="height:50px">
                                                <td style="pointer-events: auto; text-indent: 0px;  vertical-align: middle;text-align: center;">
                                                  <span style="font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif; color: #FAFAFA; font-size: 18px; line-height: 1.1640625; font-weight: bold;">143</span></td>
                                              </tr>
                                            </table>
                                          </div>
                                        </div>
                                      </td>
                                      <td>
                                      </td>
                                    </tr>
                                    <tr valign="top" style="height:10px">
                                      <td colspan="3">
                                      </td>
                                    </tr>
                                  </table>
                                </div>
                              </div>
                            </td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:20px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:1px"></td>
                  <td style="width:300px"></td>
                </tr>
                <tr valign="top" style="height:200px">
                  <td>
                  </td>
                  <td style="pointer-events: auto; ">
                  </td>
                </tr>
                <tr valign="top" style="height:20px">
                  <td>
                  </td>
                  <td style="pointer-events: auto; ">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td colspan="3">
        </td>
        <td>
        </td>
        <td>
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:280px"></td>
                </tr>
                <tr valign="top" style="height:200px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_0_9_0" style="height: 200px" alt=""/></td>
                </tr>
              </table>
            </div>

          </div>
        </td>
        <td>
        </td>
      </tr>
      <tr valign="top" style="height:20px">
        <td colspan="2">
        </td>
        <td colspan="3">
        </td>
        <td colspan="3">
        </td>
        <td>
        </td>
        <td>
        </td>
        <td>
        </td>
      </tr>
      <tr valign="top" style="height:10px">
        <td colspan="14">
        </td>
      </tr>
      <tr valign="top" style="height:209px">
        <td>
        </td>
        <td colspan="4">
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:390px"></td>
                </tr>
                <tr valign="top" style="height:209px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_0_5" style="width: 390px; height: 209px" alt=""/></td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:9px"></td>
                  <td style="width:371px"></td>
                  <td style="width:10px"></td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
                <tr valign="top" style="height:189px">
                  <td>
                  </td>
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:371px"></td>
                          </tr>
                          <tr valign="top" style="height:189px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_0_6" style="height: 189px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:81px"></td>
                            <td style="width:250px"></td>
                            <td style="width:40px"></td>
                          </tr>
                          <tr valign="top" style="height:20px">
                            <td colspan="3">
                            </td>
                          </tr>
                          <tr valign="top" style="height:140px">
                            <td>
                            </td>
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_0_7" style="height: 140px" alt=""/></td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:29px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td>
        </td>
        <td colspan="3">
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:390px"></td>
                </tr>
                <tr valign="top" style="height:209px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_0_10" style="width: 390px; height: 209px" alt=""/></td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:9px"></td>
                  <td style="width:371px"></td>
                  <td style="width:10px"></td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
                <tr valign="top" style="height:189px">
                  <td>
                  </td>
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:371px"></td>
                          </tr>
                          <tr valign="top" style="height:189px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_0_11" style="height: 189px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:81px"></td>
                            <td style="width:250px"></td>
                            <td style="width:40px"></td>
                          </tr>
                          <tr valign="top" style="height:20px">
                            <td colspan="3">
                            </td>
                          </tr>
                          <tr valign="top" style="height:140px">
                            <td>
                            </td>
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_0_12" style="height: 140px" alt=""/></td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:29px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td colspan="5">
        </td>
      </tr>
      <tr valign="top" style="height:66px">
        <td colspan="14">
        </td>
      </tr>
    </table>
    <br/>
    <br/>

    <a name="JR_PAGE_ANCHOR_0_2"></a>
    <table class="jrPage" cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 842px; border-collapse: collapse; background-color: white;">
      <tr valign="top" style="height:0">
        <td style="width:20px"></td>
        <td style="width:250px"></td>
        <td style="width:140px"></td>
        <td style="width:11px"></td>
        <td style="width:390px"></td>
        <td style="width:9px"></td>
        <td style="width:22px"></td>
      </tr>
      <tr valign="top" style="height:20px">
        <td colspan="7">
        </td>
      </tr>
      <tr valign="top" style="height:30px">
        <td>
        </td>
        <td rowspan="2">
          <img src="report122929157175106646.html_files/img_0_0_0" style="height: 60px" alt=""/></td>
        <td colspan="4" style="text-indent: 0px;  vertical-align: middle;text-align: center;">
          <span style="font-family: Arial; color: #000000; font-size: 20px; line-height: 1.1499023; font-weight: bold;">CSA PERFORMANCE DASHBOARD 2015</span></td>
        <td>
        </td>
      </tr>
      <tr valign="top" style="height:30px">
        <td>
        </td>
        <td colspan="4" style="text-indent: 0px;  vertical-align: middle;text-align: center;">
          <span style="font-family: Arial; color: #000000; font-size: 16px; line-height: 1.1499023; font-weight: bold;">PERIODE JULY 2015</span></td>
        <td>
        </td>
      </tr>
      <tr valign="top" style="height:10px">
        <td colspan="7">
        </td>
      </tr>
      <tr valign="top" style="height:209px">
        <td>
        </td>
        <td colspan="2">
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:390px"></td>
                </tr>
                <tr valign="top" style="height:209px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_1_3" style="width: 390px; height: 209px" alt=""/></td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:9px"></td>
                  <td style="width:371px"></td>
                  <td style="width:10px"></td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
                <tr valign="top" style="height:189px">
                  <td>
                  </td>
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:371px"></td>
                          </tr>
                          <tr valign="top" style="height:189px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_4" style="height: 189px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:81px"></td>
                            <td style="width:250px"></td>
                            <td style="width:40px"></td>
                          </tr>
                          <tr valign="top" style="height:20px">
                            <td colspan="3">
                            </td>
                          </tr>
                          <tr valign="top" style="height:140px">
                            <td>
                            </td>
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_5" style="height: 140px" alt=""/></td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:29px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td>
        </td>
        <td>
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:390px"></td>
                </tr>
                <tr valign="top" style="height:209px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_1_9" style="width: 390px; height: 209px" alt=""/></td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:9px"></td>
                  <td style="width:371px"></td>
                  <td style="width:10px"></td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
                <tr valign="top" style="height:189px">
                  <td>
                  </td>
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:371px"></td>
                          </tr>
                          <tr valign="top" style="height:189px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_10" style="height: 189px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:81px"></td>
                            <td style="width:250px"></td>
                            <td style="width:40px"></td>
                          </tr>
                          <tr valign="top" style="height:20px">
                            <td colspan="3">
                            </td>
                          </tr>
                          <tr valign="top" style="height:140px">
                            <td>
                            </td>
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_11" style="height: 140px" alt=""/></td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:29px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td colspan="2">
        </td>
      </tr>
      <tr valign="top" style="height:11px">
        <td colspan="7">
        </td>
      </tr>
      <tr valign="top" style="height:209px">
        <td>
        </td>
        <td colspan="2">
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:390px"></td>
                </tr>
                <tr valign="top" style="height:209px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_1_6" style="width: 390px; height: 209px" alt=""/></td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:9px"></td>
                  <td style="width:371px"></td>
                  <td style="width:10px"></td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
                <tr valign="top" style="height:189px">
                  <td>
                  </td>
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:371px"></td>
                          </tr>
                          <tr valign="top" style="height:189px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_7" style="height: 189px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:81px"></td>
                            <td style="width:250px"></td>
                            <td style="width:40px"></td>
                          </tr>
                          <tr valign="top" style="height:20px">
                            <td colspan="3">
                            </td>
                          </tr>
                          <tr valign="top" style="height:140px">
                            <td>
                            </td>
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_8" style="height: 140px" alt=""/></td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:29px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td>
        </td>
        <td>
          <div style="width: 100%; height: 100%; position: relative;">
            <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:390px"></td>
                </tr>
                <tr valign="top" style="height:209px">
                  <td style="pointer-events: auto; ">
                    <img src="report122929157175106646.html_files/img_0_1_12" style="width: 390px; height: 209px" alt=""/></td>
                </tr>
              </table>
            </div>
            <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
              <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                <tr valign="top" style="height:0">
                  <td style="width:9px"></td>
                  <td style="width:371px"></td>
                  <td style="width:10px"></td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
                <tr valign="top" style="height:189px">
                  <td>
                  </td>
                  <td>
                    <div style="width: 100%; height: 100%; position: relative;">
                      <div style="position: absolute; overflow: hidden; width: 100%; height: 100%; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:371px"></td>
                          </tr>
                          <tr valign="top" style="height:189px">
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_13" style="height: 189px" alt=""/></td>
                          </tr>
                        </table>
                      </div>
                      <div style="position: relative; width: 100%; height: 100%; pointer-events: none; ">
                        <table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 100%; border-collapse: collapse;">
                          <tr valign="top" style="height:0">
                            <td style="width:81px"></td>
                            <td style="width:250px"></td>
                            <td style="width:40px"></td>
                          </tr>
                          <tr valign="top" style="height:20px">
                            <td colspan="3">
                            </td>
                          </tr>
                          <tr valign="top" style="height:140px">
                            <td>
                            </td>
                            <td style="pointer-events: auto; ">
                              <img src="report122929157175106646.html_files/img_0_1_14" style="height: 140px" alt=""/></td>
                            <td>
                            </td>
                          </tr>
                          <tr valign="top" style="height:29px">
                            <td colspan="3">
                            </td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr valign="top" style="height:10px">
                  <td colspan="3">
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </td>
        <td colspan="2">
        </td>
      </tr>
      <tr valign="top" style="height:76px">
        <td colspan="7">
        </td>
      </tr>
    </table>

    <![if IE]>
    <script>
      var links = document.querySelectorAll('link.jrWebFont');
      setTimeout(function(){ if (links) { for (var i = 0; i < links.length; i++) { links.item(i).href = links.item(i).href; } } }, 0);
    </script>
    <![endif]>
  </td><td width="50%">&nbsp;</td></tr>
</table>
</body>
</html>
