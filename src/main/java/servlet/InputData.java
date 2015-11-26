package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by inchidi on 25/11/15.
 */
@WebServlet(name = "InputData")
public class InputData extends HttpServlet {
    F_Function FF = new F_Function();
    Double TextActualRevenue,TextActualCOSService,TextActualExpenses;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //untuk input

        //kalo udah diitung, simpan data
        Calendar cal = Calendar.getInstance();
        int tahun = Integer.parseInt(req.getParameter("tahun"));
        int bulan = Integer.parseInt(req.getParameter("bulan"));
        if (req.getParameter("calculate").equals("true")){
            if (tahun<=cal.get(Calendar.YEAR)){
                if (bulan<=cal.get(Calendar.MONTH)){
                    resp.sendRedirect("/HarapKontakAdmin");
                }else {

                }
            }
        } else {
            //kalo belum diitung, lakukan perhitungan

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //untuk reload data
        if(ReloadFormatTextSum(request)){
            response.addHeader("TextActualRevenue", String.valueOf(TextActualRevenue));
            response.addHeader("TextActualCOSService", String.valueOf(TextActualCOSService));
            response.addHeader("TextActualExpenses", String.valueOf(TextActualExpenses));

        } else{

        }
    }



    private boolean ReloadFormatTextSum(HttpServletRequest request) {
        try {
            if (!request.getParameter("refresh").toString().equals("true")) return false;
            TextActualRevenue = (
                    Double.parseDouble(request.getParameter("TextActualSpareParts").toString())
                            + Double.parseDouble(request.getParameter("TextActualSMC").toString())
                            + Double.parseDouble(request.getParameter("TextActualFMC").toString())
            );

            TextActualCOSService = (
                    Double.parseDouble(request.getParameter("TextActualPeriodicMain").toString())
                            + Double.parseDouble(request.getParameter("TextActualPartRepair").toString())
                            + Double.parseDouble(request.getParameter("TextActualPartRNI").toString())
                            + Double.parseDouble(request.getParameter("TextActualComponent").toString())
                            + Double.parseDouble(request.getParameter("TextActualUnderGroup").toString())
                            + Double.parseDouble(request.getParameter("TextActualWarranty").toString())
                            + Double.parseDouble(request.getParameter("TextActualConsumable").toString())
            );
            TextActualExpenses = (
                    Double.parseDouble(request.getParameter("TextActualEmployee").toString())
                            + Double.parseDouble(request.getParameter("TextActualDeprecation").toString())
                            + Double.parseDouble(request.getParameter("TextActualOperation").toString())
            );
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}
