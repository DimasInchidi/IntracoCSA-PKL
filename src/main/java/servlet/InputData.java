package servlet;

import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "InputData",
        urlPatterns = {"/InputData"})
public class InputData extends HttpServlet {

    F_Function FF = new F_Function();
    String[] datainputActual;
    String[] datainputTarget;
    Double TextActualPercent;
    Double TextTargetPercent;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Calendar cal = getInstance();
        String project = req.getParameter("project");
        int tahun = parseInt(req.getParameter("tahun"));
        int bulan = parseInt(req.getParameter("bulan"));
        if (action!=null && action.equals("calculate")){
                if (tahun<cal.get(YEAR) && bulan<cal.get(MONTH)){
                    resp.sendError(505);
                }else {
                    if(ReloadFormatTextSum(req, req.getSession().getAttribute("level").toString(), req.getParameter("tipe").toString())){
                        resp.sendRedirect("/input+data?refresh=false&task=calculate");
                    } else{
                        resp.sendError(505);
                    }
                }
        } else {
            if (req.getSession().getAttribute("level").toString().equalsIgnoreCase("admin")){
            FF.UpdateData(datainputActual, project, Integer.toString(bulan), Integer.toString(tahun),TextActualPercent);
            FF.UpdateData(datainputTarget, project, Integer.toString(bulan), Integer.toString(tahun),TextTargetPercent);
            resp.sendRedirect("/input+data");
            } else {
                FF.UpdateData(datainputActual, project, Integer.toString(bulan), Integer.toString(tahun),TextActualPercent);
                resp.sendRedirect("/input+data");
            }
        }
    }

    private boolean ReloadFormatTextSum(HttpServletRequest request, String level, String tipe) {
        try {
            if (!tipe.equalsIgnoreCase("target")) {
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

                Double TextActualCOSService = TextActualPeriodicMain + TextActualPartRepair + TextActualPartRNI +
                        TextActualComponent + TextActualUnderGroup + TextActualWarranty + TextActualConsumable;

                Double TextActualCOSSpareparts = parseDouble(request.getParameter("TextActualCOSSpareparts").replaceAll("[^\\d.]", ""));

                Double TextActualTotalCOGS = TextActualCOSSpareparts + TextActualCOSService;
                Double TextActualGross = TextActualRevenue - TextActualTotalCOGS;

                Double TextActualEmployee = parseDouble(request.getParameter("TextActualEmployee").replaceAll("[^\\d.]", ""));
                Double TextActualDeprecation = parseDouble(request.getParameter("TextActualDeprecation").replaceAll("[^\\d.]", ""));
                Double TextActualOperation = parseDouble(request.getParameter("TextActualOperation").replaceAll("[^\\d.]", ""));

                Double TextActualExpenses = TextActualEmployee + TextActualDeprecation + TextActualOperation;

                Double TextActualOPR = TextActualGross - TextActualExpenses;

                TextActualPercent = TextActualOPR / TextActualRevenue;
                if (TextActualPercent.isInfinite() || TextActualPercent.isNaN()) {
                    TextActualPercent = (double) 0;
                }

                datainputActual = new String[]{Double.toString(TextActualSpareParts),
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
            }else if(level.equalsIgnoreCase("admin")){
            Double TextTargetSpareParts = parseDouble(request.getParameter("TextTargetSpareParts").replaceAll("[^\\d.]", ""));
            Double TextTargetSMC = parseDouble(request.getParameter("TextTargetSMC").replaceAll("[^\\d.]", ""));
            Double TextTargetFMC = parseDouble(request.getParameter("TextTargetFMC").replaceAll("[^\\d.]", ""));
            Double TextTargetRevenue = TextTargetSpareParts + TextTargetSMC + TextTargetFMC;

            Double TextTargetPeriodicMain = parseDouble(request.getParameter("TextTargetPeriodicMain").replaceAll("[^\\d.]", ""));
            Double TextTargetPartRepair = parseDouble(request.getParameter("TextTargetPartRepair").replaceAll("[^\\d.]", ""));
            Double TextTargetPartRNI = parseDouble(request.getParameter("TextTargetPartRNI").replaceAll("[^\\d.]", ""));
            Double TextTargetComponent = parseDouble(request.getParameter("TextTargetComponent").replaceAll("[^\\d.]", ""));
            Double TextTargetUnderGroup = parseDouble(request.getParameter("TextTargetUnderGroup").replaceAll("[^\\d.]", ""));
            Double TextTargetWarranty = parseDouble(request.getParameter("TextTargetWarranty").replaceAll("[^\\d.]", ""));
            Double TextTargetConsumable = parseDouble(request.getParameter("TextTargetConsumable").replaceAll("[^\\d.]", ""));

            Double TextTargetCOSService = TextTargetPeriodicMain + TextTargetPartRepair + TextTargetPartRNI +
                    TextTargetComponent + TextTargetUnderGroup + TextTargetWarranty + TextTargetConsumable;

            Double TextTargetCOSSpareparts = parseDouble(request.getParameter("TextTargetCOSSpareparts").replaceAll("[^\\d.]", ""));

            Double TextTargetTotalCOGS = TextTargetCOSSpareparts + TextTargetCOSService;
            Double TextTargetGross = TextTargetRevenue - TextTargetTotalCOGS;

            Double TextTargetEmployee = parseDouble(request.getParameter("TextTargetEmployee").replaceAll("[^\\d.]", ""));
            Double TextTargetDeprecation = parseDouble(request.getParameter("TextTargetDeprecation").replaceAll("[^\\d.]", ""));
            Double TextTargetOperation = parseDouble(request.getParameter("TextTargetOperation").replaceAll("[^\\d.]", ""));

            Double TextTargetExpenses = TextTargetEmployee + TextTargetDeprecation + TextTargetOperation;

            Double TextTargetOPR = TextTargetGross - TextTargetExpenses;

            TextTargetPercent = TextTargetOPR / TextTargetRevenue;
            if (TextTargetPercent.isInfinite() || TextTargetPercent.isNaN()) {
                TextTargetPercent = (double) 0;
            }
            datainputTarget = new String[]{Double.toString(TextTargetSpareParts),
                    Double.toString(TextTargetSMC),
                    Double.toString(TextTargetFMC),
                    Double.toString(TextTargetRevenue),
                    Double.toString(TextTargetCOSService),
                    Double.toString(TextTargetCOSSpareparts),
                    Double.toString(TextTargetPeriodicMain),
                    Double.toString(TextTargetPartRepair),
                    Double.toString(TextTargetPartRNI),
                    Double.toString(TextTargetComponent),
                    Double.toString(TextTargetUnderGroup),
                    Double.toString(TextTargetWarranty),
                    Double.toString(TextTargetConsumable),
                    Double.toString(TextTargetTotalCOGS),
                    Double.toString(TextTargetGross),
                    Double.toString(TextTargetExpenses),
                    Double.toString(TextTargetEmployee),
                    Double.toString(TextTargetDeprecation),
                    Double.toString(TextTargetOperation),
                    Double.toString(TextTargetOPR),
                    Double.toString(TextTargetPercent)};
        }
            HttpSession session = request.getSession();
            session.setAttribute("datainputActual",datainputActual);
            session.setAttribute("datainputTarget",datainputTarget);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}
