package servlet;

import java.sql.*;
import java.util.Properties;

/**
 * Created by inchidi on 29/10/15.
 */
public class F_Koneksi {

    //nanti diganti disini ye dimz~
    static {
        JDBC_DRIVER = "org.postgresql.Driver";
        DB_URL = "jdbc:postgresql://ec2-54-204-15-48.compute-1.amazonaws.com:5432/d43cvp6kpf1the";
        USER = "khwivmymedwodp";
        PASS = "rnNyTeGxo0PCll83A-6Db__n4v";
    }

    private static final String JDBC_DRIVER;
    private static final String DB_URL;
    private static final String USER;
    private static final String PASS;
    private final Connection con;
    private ResultSet rs;
    private Statement stmt;

    public F_Koneksi() {
        Connection con1;
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password",PASS);
            props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
            props.setProperty("ssl", "true");
            Class.forName(JDBC_DRIVER);
            con1 = DriverManager.getConnection(DB_URL, props);
        } catch (SQLException|ClassNotFoundException se) {
            con1 = null;
            System.out.println("Koneksi tidak valid\n" + se.getMessage());
        }
        con = con1;
    }

    public ResultSet Select(String data, String table, String condition) {
        String sql = "SELECT " + data + " FROM " + table + " " + condition;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception ex) {
            rs = null;
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public boolean Update(String data, String table, String condition) {
        try {
            String sql = "UPDATE " + table + " SET " + data + " WHERE " + condition;
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Insert(String table, String data) {
        try {
            String sql = "INSERT INTO " + table + " VALUE (" + data + ")";
            stmt = con.createStatement();
            stmt.executeQuery(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(String table, String condition) {
        try {
            String sql = "DELETE FROM " + table + " WHERE nik='" + condition + "'";
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
