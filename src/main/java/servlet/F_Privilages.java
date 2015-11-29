package servlet;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class F_Privilages extends F_Koneksi {

    List<String> user ;

    public F_Privilages() {
        user = new ArrayList<>();
    }

    public boolean doLogin(String Username, String Pass) {
        String condition = "WHERE Username = '" + CleanInput(Username) + "' AND Katakunci = sha1('" + CleanInput(Pass) + "')";
        try{
            ResultSet rs = super.Select("`Username`, `Nama`, `Level`, `LastLogin`","dataUser",condition);
            rs.next();
            user.add(0,rs.getString(1));
            user.add(1,rs.getString(2));
            user.add(2,rs.getString(3));
            user.add(3,rs.getString(4));
            System.out.println(user.get(1));
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public O_User UserData(){
        O_User User = new O_User();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dt = new Date();
        String LastLogin = date.format(dt);
        Update("`LastLogin` = '"+LastLogin+"'","`dataUser`","`Username` = '"+user.get(1)+"'");
        User.setLastLogin(LastLogin);
        User.setUsername(user.get(0));
        User.setNama(user.get(1));
        User.setLevel(user.get(2));
        User.setLastLogin(user.get(3));
        return User;
    }

}
