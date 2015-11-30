package servlet;

import static java.lang.Class.forName;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author DimasInchidi
 */
public class F_Koneksi {


    private static final String JDBC_DRIVER;
    private static final String DB_URL;
    private static final String USER;
    private static final String PASS;
    static {
        JDBC_DRIVER = "org.postgresql.Driver";
        DB_URL = "jdbc:postgresql://ec2-54-197-241-239.compute-1.amazonaws.com:5432/d4cf9qjii3n278";
        USER = "ugdkklluzjnfyd";
        PASS = "6DQq3XxGJaxd8PrTY9ec-xfeki";
//        JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        DB_URL = "jdbc:mysql://localhost/IntracoCSA";
//        USER = "root";
//        PASS = "r00t";
    }
    private final Connection con;
    private ResultSet rs;
    private Statement stmt;

    /**
     *
     */
    public F_Koneksi() {
        Connection connect;
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password",PASS);
            props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
            props.setProperty("ssl", "true");
            forName(JDBC_DRIVER);
            connect = getConnection(DB_URL, props);
        } catch (SQLException|ClassNotFoundException se) {
            connect = null;
            //goto error page
                    }
        con = connect;
    }

    /**
     *
     * @param data
     * @param table
     * @param condition
     * @return
     */
    public ResultSet Select(String data, String table, String condition) {
        String sql = "SELECT " + data + " FROM " + table + " " + condition;
        sql = sql.replaceAll("`", "\"");
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            rs = null;
        }
        return rs;
    }

    /**
     *
     * @param query
     * @return
     */
    public ResultSet Select(String query) {
        try {
            query = query.replaceAll("`", "\"");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            rs = null;
        }
        return rs;
    }

    /**
     *
     * @param data
     * @param table
     * @param condition
     * @return
     */
    public boolean Update(String data, String table, String condition) {
        try {
            String sql = "UPDATE " + table + " SET " + data + " WHERE " + condition;
            sql = sql.replaceAll("`", "\"");
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     *
     * @param Query
     * @return
     */
    public boolean Update(String Query) {
        try {
            Query = Query.replaceAll("`", "\"");
            stmt = con.createStatement();
            stmt.executeUpdate(Query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     *
     * @param table
     * @param data
     * @return
     */
    public boolean Insert(String table, String data) {
        try {
            String sql = "INSERT INTO " + table + " VALUE (" + data + ")";
            sql = sql.replaceAll("`", "\"");
            stmt = con.createStatement();
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     *
     * @param table
     * @param condition
     * @return
     */
    public boolean Delete(String table, String condition) {
        try {
            String sql = "DELETE FROM " + table + " WHERE " + condition + "";
            sql = sql.replaceAll("`", "\"");
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     *
     * @param input
     * @return
     */
    public String CleanInput (String input){
        return input.replaceAll("'","''");
    }
    private static final Logger LOG = Logger.getLogger(F_Koneksi.class.getName());
}
