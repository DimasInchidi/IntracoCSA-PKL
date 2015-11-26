package servlet;

import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by inchidi on 29/10/15.
 */
@WebServlet(
        name = "Logout",
        urlPatterns = {"/Logout"}    )
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        request.getSession(false);
        response.sendRedirect("/login");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        request.getSession(false);
        response.sendRedirect("/login");
    }
}
