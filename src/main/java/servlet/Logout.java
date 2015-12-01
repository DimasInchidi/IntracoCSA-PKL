package servlet;


import java.io.IOException;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Created by inchidi on 29/10/15.
 */
@WebServlet(
        name = "Logout",
        urlPatterns = {"/Logout"}    )
public class Logout extends HttpServlet {

    private static final Logger LOG = getLogger(Logout.class.getName());

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        request.getSession(false);
        response.sendRedirect("/login");
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        request.getSession(false);
        response.sendRedirect("/login");
    }
}
