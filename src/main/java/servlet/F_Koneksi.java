package servlet;

import java.sql.*;
import java.util.Properties;

/**
 * Created by inchidi on 29/10/15.
 */
public class F_Koneksi {

    static {
        JDBC_DRIVER = "org.postgresql.Driver";
        DB_URL = "jdbc:postgresql://ec2-54-204-15-48.compute-1.amazonaws.com:5432/d43cvp6kpf1the";
        USER = "khwivmymedwodp";
        PASS = "rnNyTeGxo0PCll83A-6Db__n4v";
//        JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        DB_URL = "jdbc:mysql://localhost/IntracoCSA";
//        USER = "root";
//        PASS = "r00t";
    }

    private static final String JDBC_DRIVER;
    private static final String DB_URL;
    private static final String USER;
    private static final String PASS;
    private final Connection con;
    private ResultSet rs;
    private Statement stmt;

    public F_Koneksi() {
        Connection connect;
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password",PASS);
            //props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
            //props.setProperty("ssl", "true");
            Class.forName(JDBC_DRIVER);
            connect = DriverManager.getConnection(DB_URL, props);
        } catch (SQLException|ClassNotFoundException se) {
            connect = null;
            //goto error page
            System.out.println("Koneksi tidak valid\n" + se.getMessage());
        }
        con = connect;
    }

    public ResultSet Select(String data, String table, String condition) {
        String sql = "SELECT " + data + " FROM " + table + " " + condition;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
        } catch (Exception ex) {
            rs = null;
        }
        return rs;
    }

    public ResultSet Select(String query) {
        String sql = query;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
        } catch (Exception ex) {
            rs = null;
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

    public boolean Update(String Query) {
        try {
            String sql = Query;
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

    public String CleanInput (String input){
        return input.replaceAll("'","''");
    }
}
