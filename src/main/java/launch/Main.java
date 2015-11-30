package launch;

import java.io.File;
import static java.lang.Integer.valueOf;
import static java.lang.System.getenv;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 *
 * @author DimasInchidi
 */
public class Main {

    private static final Logger LOG = getLogger(Main.class.getName());

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        String buildPath = "target/classes";
        String webAppMount = "/WEB-INF/classes";
        //okdah

        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(valueOf(webPort));

        StandardContext context = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

        File additionalWebInfClasses = new File(buildPath);
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), "/"));
        context.setResources(resources);


        tomcat.start();
        tomcat.getServer().await();
    }
}

