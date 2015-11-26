package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by inchidi on 29/10/15.
 */
@WebServlet(
        name = "Login",
        urlPatterns = {"/Login"}    )
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    F_Privilages Priv = new F_Privilages();

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
            response.sendRedirect("dashboard");
        } else {
            System.out.println("Status: Failed to loging in");
            response.setIntHeader("lgn",0);
            response.sendRedirect("/login");
        }
    }

}
