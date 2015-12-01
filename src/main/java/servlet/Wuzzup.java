package servlet;

import java.io.IOException;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 class ini dibangun untuk perKUTUan
 */

/**
 *
 * @author DimasInchidi
 */

@WebServlet(
        name = "Inchidi",
        urlPatterns = {"/Inchidi"}    )
public class Wuzzup extends HttpServlet {

    private static final Logger LOG = getLogger(Wuzzup.class.getName());

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try (ServletOutputStream out = resp.getOutputStream()) {
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Demo Accounts</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "this page exist on demo version\n" +
                    "<div style=\"text-align: center;\">\n" +
                    "<table border=\"1\">\n" +
                    "    <tbody>\n" +
                    "    <tr>\n" +
                    "        <td>\n" +
                    "            Level\n" +
                    "        </td>\n" +
                    "        <td>\n" +
                    "            Username\n" +
                    "        </td>\n" +
                    "        <td>\n" +
                    "            Password\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>\n" +
                    "            Admin\n" +
                    "        </td>\n" +
                    "        <td>\n" +
                    "            admin\n" +
                    "        </td>\n" +
                    "        <td>\n" +
                    "            123admin456\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>\n" +
                    "            KPC\n" +
                    "        </td>\n" +
                    "        <td>\n" +
                    "            KPC\n" +
                    "        </td>\n" +
                    "        <td>\n" +
                    "            123KPC456\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>");
            out.flush();
        }
    }

}