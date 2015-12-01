package servlet;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 * Created by inchidi on 20/11/15.
 */
public class O_User {

    private static final Logger LOG = getLogger(O_User.class.getName());
    private String Username;
    private String Nama;
    private String Level;
    private String LastLogin;

    /**
     *
     * @param Username
     */
    public void setUsername(String Username){
        this.Username = Username;
    }

    /**
     *
     * @param lastLogin
     */
    public void setLastLogin(String lastLogin) {
        LastLogin = lastLogin;
    }

    /**
     *
     * @param level
     */
    public void setLevel(String level) {
        Level = level;
    }

    /**
     *
     * @param nama
     */
    public void setNama(String nama) {
        Nama = nama;
    }

    /**
     *
     * @return
     */
    public String getLevel() {
        return Level;
    }

    /**
     *
     * @return
     */
    public String getNama() {
        return Nama;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return Username;
    }

    /**
     *
     * @return
     */
    public String getLastLogin() {
        return LastLogin;
    }
}
