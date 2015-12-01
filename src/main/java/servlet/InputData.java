package servlet;

import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DimasInchidi
 */
@WebServlet(name = "InputData",
        urlPatterns = {"/InputData"})
public class InputData extends HttpServlet {

    private static final Logger LOG = getLogger(InputData.class.getName());

    F_Function FF = new F_Function();
    String[] datainputActual;
    String[] datainputTarget;
    Double TextActualPercent;

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Calendar cal = getInstance();
        String project = req.getParameter("project");
        int tahun = parseInt(req.getParameter("tahun"));
        int bulan = parseInt(req.getParameter("bulan"));
        if (action!=null && action.equals("calculate")){
                if (tahun<cal.get(YEAR) && bulan<cal.get(MONTH)){
                    resp.sendRedirect("/HarapKontakAdmin");
                }else {
                    if(ReloadFormatTextSum(req)){
                        resp.sendRedirect("/input+data?refresh=false&task=calculate");
                    } else{
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
            Double TextActualSpareParts = parseDouble(request.getParameter("TextActualSpareParts").replaceAll("[^\\d.]", ""));
            Double TextActualSMC = parseDouble(request.getParameter("TextActualSMC").replaceAll("[^\\d.]", ""));
            Double TextActualFMC = parseDouble(request.getParameter("TextActualFMC").replaceAll("[^\\d.]", ""));
            Double TextActualRevenue = TextActualSpareParts + TextActualSMC + TextActualFMC;

            Double TextActualPeriodicMain = parseDouble(request.getParameter("TextActualPeriodicMain").replaceAll("[^\\d.]", ""));
            Double TextActualPartRepair = parseDouble(request.getParameter("TextActualPartRepair").replaceAll("[^\\d.]", ""));
            Double TextActualPartRNI = parseDouble(request.getParameter("TextActualPartRNI").replaceAll("[^\\d.]", ""));
            Double TextActualComponent = parseDouble(request.getParameter("TextActualComponent").replaceAll("[^\\d.]", ""));
            Double TextActualUnderGroup = parseDouble(request.getParameter("TextActualUnderGroup").replaceAll("[^\\d.]", ""));
            Double TextActualWarranty = parseDouble(request.getParameter("TextActualWarranty").replaceAll("[^\\d.]", ""));
            Double TextActualConsumable = parseDouble(request.getParameter("TextActualConsumable").replaceAll("[^\\d.]", ""));

            Double TextActualCOSService = TextActualPeriodicMain + TextActualPartRepair +TextActualPartRNI+
                    TextActualComponent + TextActualUnderGroup + TextActualWarranty + TextActualConsumable;

            Double TextActualCOSSpareparts = parseDouble(request.getParameter("TextActualCOSSpareparts").replaceAll("[^\\d.]", ""));

            Double TextActualTotalCOGS = TextActualCOSSpareparts+TextActualCOSService;
            Double TextActualGross = TextActualRevenue - TextActualTotalCOGS;

            Double TextActualEmployee = parseDouble(request.getParameter("TextActualEmployee").replaceAll("[^\\d.]", ""));
            Double TextActualDeprecation = parseDouble(request.getParameter("TextActualDeprecation").replaceAll("[^\\d.]", ""));
            Double TextActualOperation = parseDouble(request.getParameter("TextActualOperation").replaceAll("[^\\d.]", ""));

            Double TextActualExpenses = TextActualEmployee+TextActualDeprecation+TextActualOperation;

            Double TextActualOPR = TextActualGross - TextActualExpenses;

            TextActualPercent = TextActualOPR / TextActualRevenue;
            if (TextActualPercent.isInfinite() || TextActualPercent.isNaN()) {
                TextActualPercent = (double) 0;
            }
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
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}
