package servlet;

import java.io.IOException;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DimasInchidi
 */
@WebServlet(
        name = "Dashboard",
        urlPatterns = {"/Tables"}
)
public class Dashboard extends HttpServlet {

    private static final Logger LOG = getLogger(Dashboard.class.getName());

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
