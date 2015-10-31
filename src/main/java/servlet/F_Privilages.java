package servlet;

import java.sql.ResultSet;

/**
 * Created by inchidi on 29/10/15.
 */
public class F_Privilages extends F_Koneksi {
    public String User;
    public String Level;

    public F_Privilages() {
        Level = "";
        User = "";
    }

    public boolean doLogin(String Username, String Pass) {
        String condition = "WHERE nik = '" + Username + "' AND password = md5('" + Pass + "')";
        try{
            ResultSet rs = super.Select("nik, level","lmt_user",condition);
            rs.next();
            User = rs.getString(1);
            System.out.println(User);
            Level = rs.getString(2);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
