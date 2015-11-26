package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by inchidi on 22/11/15.
 */
@WebServlet(
        name = "Dashboard",
        urlPatterns = {"/Tables"}
)
public class Dashboard extends HttpServlet {
    F_Function FF = new F_Function();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//        Data.setBulanDataHome(Integer.parseInt(request.getParameter("bulan")));
//
//        if (User.getLevel() ==null || User.getLevel().contains("Admin")){
//            if (request.getParameter("proyek").equals("TOTAL CSA GOLD")){
//                Data.setComboProjectHomeIndex(0);
//            }else{
//                Data.setComboProjectHomeIndex(1);
//            }
//            Data.setComboProjectHomeItem(request.getParameter("proyek"));
//        } else {
//            Data.setComboProjectHomeIndex(0);
//            Data.setComboProjectHomeItem(User.getLevel());
//        }
//
//        Data.setTahunDataHome(Integer.parseInt(request.getParameter("tahun")));
//
//        Data.setTableAVB();
//        Data.setTableMonth();
//        Data.setTableYTD();

    }

}
