package servlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author DimasInchidi
 */
public class F_Privilages extends F_Koneksi {

    private static final Logger LOG = getLogger(F_Privilages.class.getName());

    List<String> user ;

    /**
     *
     */
    public F_Privilages() {
        user = new ArrayList<>();
    }

    /**
     *
     * @param Username
     * @param Pass
     * @return
     */
    public boolean doLogin(String Username, String Pass) {
        String query = "SELECT `Username`, `Nama`, `Level`, `LastLogin` FROM `dataUser` WHERE `Username` = '" + CleanInput(Username) + "' AND `Katakunci` = md5('" + CleanInput(Pass) + "')";
        Object[][] rs = Select(query, 4);
        if (rs!=null){
            user.add(0, rs[0][0].toString());
            user.add(1, rs[0][1].toString());
            user.add(2, rs[0][2].toString());
            user.add(3, rs[0][3].toString());
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public O_User UserData(){
        O_User User = new O_User();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date dt = new Date();
        String LastLogin = date.format(dt);
        Update("`LastLogin` = '"+LastLogin+"'","`dataUser`","`Username` = '"+this.user.get(1)+"'");
        User.setLastLogin(LastLogin);
        User.setUsername(user.get(0));
        User.setNama(user.get(1));
        User.setLevel(user.get(2));
        User.setLastLogin(user.get(3));
        return User;
    }

}
