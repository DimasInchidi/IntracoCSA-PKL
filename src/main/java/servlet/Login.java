package servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author DimasInchidi
 */
@WebServlet(
        name = "Login",
        urlPatterns = {"/Login"}    )
public class Login extends HttpServlet {


    F_Privilages Priv = new F_Privilages();

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean UserExist = Priv.doLogin(request.getParameter("username"), request.getParameter("password"));
        if (UserExist) {
            O_User User = Priv.UserData();
            HttpSession session = request.getSession(true);
            session.setAttribute("user", User.getUsername());
            session.setAttribute("nama", User.getNama());
            session.setAttribute("level", User.getLevel());
            session.setAttribute("lastlogin", User.getLastLogin());

            if (request.getParameter("redirect")!=null){
                String redirect = request.getParameter("redirect");
                response.sendRedirect(redirect);
            }else {
                response.sendRedirect("dashboard");
            }
        } else {
            response.setIntHeader("lgn",0);
            response.sendRedirect("/login");
        }
    }
    private static final Logger LOG = Logger.getLogger(Login.class.getName());

}
