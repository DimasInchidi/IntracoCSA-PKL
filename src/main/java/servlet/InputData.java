package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "InputData",
        urlPatterns = {"/InputData"})
public class InputData extends HttpServlet {

    F_Function FF = new F_Function();
    String[] datainputActual;
    String[] datainputTarget;
    Double TextActualPercent;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Calendar cal = Calendar.getInstance();
        String project = req.getParameter("project");
        int tahun = Integer.parseInt(req.getParameter("tahun"));
        int bulan = Integer.parseInt(req.getParameter("bulan"));
        System.out.println(action);
        if (action!=null && action.equals("calculate")){
                if (tahun<cal.get(Calendar.YEAR) && bulan<cal.get(Calendar.MONTH)){
                    System.out.println("ngedit data lama harus admin");
                    resp.sendRedirect("/HarapKontakAdmin");
                }else {
                    if(ReloadFormatTextSum(req)){
                        System.out.println("data uda te reload");
                        resp.sendRedirect("/input+data?refresh=false&task=calculate");
                    } else{
                        System.out.println("data gagal tereload parameter POST kurang");
                        resp.sendRedirect("/failmamen");
                    }
                }
        } else {
            FF.UpdateData(datainputActual, project, Integer.toString(bulan), Integer.toString(tahun),TextActualPercent);
            resp.sendRedirect("/input+data");
        }
    }

    private boolean ReloadFormatTextSum(HttpServletRequest request) {
        try {
            Double TextActualSpareParts = Double.parseDouble(request.getParameter("TextActualSpareParts").replaceAll("[^\\d.]", ""));
            Double TextActualSMC = Double.parseDouble(request.getParameter("TextActualSMC").replaceAll("[^\\d.]", ""));
            Double TextActualFMC = Double.parseDouble(request.getParameter("TextActualFMC").replaceAll("[^\\d.]", ""));
            Double TextActualRevenue = TextActualSpareParts + TextActualSMC + TextActualFMC;

            Double TextActualPeriodicMain = Double.parseDouble(request.getParameter("TextActualPeriodicMain").replaceAll("[^\\d.]", ""));
            Double TextActualPartRepair = Double.parseDouble(request.getParameter("TextActualPartRepair").replaceAll("[^\\d.]", ""));
            Double TextActualPartRNI = Double.parseDouble(request.getParameter("TextActualPartRNI").replaceAll("[^\\d.]", ""));
            Double TextActualComponent = Double.parseDouble(request.getParameter("TextActualComponent").replaceAll("[^\\d.]", ""));
            Double TextActualUnderGroup = Double.parseDouble(request.getParameter("TextActualUnderGroup").replaceAll("[^\\d.]", ""));
            Double TextActualWarranty = Double.parseDouble(request.getParameter("TextActualWarranty").replaceAll("[^\\d.]", ""));
            Double TextActualConsumable = Double.parseDouble(request.getParameter("TextActualConsumable").replaceAll("[^\\d.]", ""));

            Double TextActualCOSService = TextActualPeriodicMain + TextActualPartRepair +TextActualPartRNI+
                    TextActualComponent + TextActualUnderGroup + TextActualWarranty + TextActualConsumable;

            Double TextActualCOSSpareparts = Double.parseDouble(request.getParameter("TextActualCOSSpareparts").replaceAll("[^\\d.]", ""));

            Double TextActualTotalCOGS = TextActualCOSSpareparts+TextActualCOSService;
            Double TextActualGross = TextActualRevenue - TextActualTotalCOGS;

            Double TextActualEmployee = Double.parseDouble(request.getParameter("TextActualEmployee").replaceAll("[^\\d.]", ""));
            Double TextActualDeprecation = Double.parseDouble(request.getParameter("TextActualDeprecation").replaceAll("[^\\d.]", ""));
            Double TextActualOperation = Double.parseDouble(request.getParameter("TextActualOperation").replaceAll("[^\\d.]", ""));

            Double TextActualExpenses = TextActualEmployee+TextActualDeprecation+TextActualOperation;

            Double TextActualOPR = TextActualGross - TextActualExpenses;

            TextActualPercent = TextActualOPR / TextActualRevenue;
            if (TextActualPercent.isInfinite() || TextActualPercent.isNaN()) TextActualPercent = (double) 0;
            datainputActual = new String[] {Double.toString(TextActualSpareParts),
                    Double.toString(TextActualSMC),
                    Double.toString(TextActualFMC),
                    Double.toString(TextActualRevenue),
                    Double.toString(TextActualCOSService),
                    Double.toString(TextActualCOSSpareparts),
                    Double.toString(TextActualPeriodicMain),
                    Double.toString(TextActualPartRepair),
                    Double.toString(TextActualPartRNI),
                    Double.toString(TextActualComponent),
                    Double.toString(TextActualUnderGroup),
                    Double.toString(TextActualWarranty),
                    Double.toString(TextActualConsumable),
                    Double.toString(TextActualTotalCOGS),
                    Double.toString(TextActualGross),
                    Double.toString(TextActualExpenses),
                    Double.toString(TextActualEmployee),
                    Double.toString(TextActualDeprecation),
                    Double.toString(TextActualOperation),
                    Double.toString(TextActualOPR),
                    Double.toString(TextActualPercent)
            };
            datainputTarget = new String[] {Double.toString(TextActualSpareParts),
                    Double.toString(TextActualSMC),
                    Double.toString(TextActualFMC),
                    Double.toString(TextActualRevenue),
                    Double.toString(TextActualCOSService),
                    Double.toString(TextActualCOSSpareparts),
                    Double.toString(TextActualPeriodicMain),
                    Double.toString(TextActualPartRepair),
                    Double.toString(TextActualPartRNI),
                    Double.toString(TextActualComponent),
                    Double.toString(TextActualUnderGroup),
                    Double.toString(TextActualWarranty),
                    Double.toString(TextActualConsumable),
                    Double.toString(TextActualTotalCOGS),
                    Double.toString(TextActualGross),
                    Double.toString(TextActualExpenses),
                    Double.toString(TextActualEmployee),
                    Double.toString(TextActualDeprecation),
                    Double.toString(TextActualOperation),
                    Double.toString(TextActualOPR),
                    Double.toString(TextActualPercent)};

            HttpSession session = request.getSession();
            session.setAttribute("datainputActual",datainputActual);
            session.setAttribute("datainputTarget",datainputTarget);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}
