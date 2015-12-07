package servlet;

import static java.lang.Class.forName;
import java.sql.*;

import static java.lang.Math.round;
import static java.sql.DriverManager.getConnection;

import java.util.*;

/**
 *
 * @author DimasInchidi
 */
public class F_Koneksi {


    private static final String JDBC_DRIVER;
    private static final String DATABASE_URL;
    private static final String USER;
    private static final String PASS;
    static {
        JDBC_DRIVER = "org.postgresql.Driver";
//        DATABASE_URL = System.getenv("DB_URL");
//        USER = "ugdkklluzjnfyd";
//        PASS = "6DQq3XxGJaxd8PrTY9ec-xfeki";
        DATABASE_URL = "jdbc:postgresql://localhost:5432/IntracoDB";
        USER = "Intraco";
        PASS = "r00t";
    }
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;

    /**
     *
     */
    public Connection Koneksi() {
        Connection connect;
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password",PASS);
//            props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
//            props.setProperty("ssl", "true");
            forName(JDBC_DRIVER);
            connect = getConnection(DATABASE_URL, props);
        } catch (SQLException|ClassNotFoundException se) {
            connect = null;
            //TODO: goto error page
        }
        return connect;
    }

    public Object[][] Select(String query, int colcount) {
        Object[][] hasil;
        try {
            con = Koneksi();
            query = query.replaceAll("`", "\"");
            stmt = con.createStatement();
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            List<Object[]> rowList = new ArrayList<>();
            List<Object> colList = new ArrayList<>();
            while (rs.next()){
                for (int j = 1; j < colcount+1; j++) {
                    colList.add(rs.getObject(j));
                }
                Object[] colArr = new Object[colList.size()];
                colArr= colList.toArray(colArr);
                System.out.println(Arrays.toString(colArr));
                rowList.add(colArr);
            }
            hasil = new Object[rowList.size()][colList.size()];
            hasil = rowList.toArray(hasil);
            System.out.println(Arrays.deepToString(hasil));
        } catch (SQLException|NullPointerException ex) {
            ex.printStackTrace();
            hasil = null;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
        return hasil;
    }

    public Object[] Select(String query) {
        Object[] hasil;
        try {
            con = Koneksi();
            query = query.replaceAll("`", "\"");
            stmt = con.createStatement();
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            List<Object> rowList = new ArrayList<>();
            while (rs.next()){
                rowList.add(rs.getObject(1));
            }
            hasil = new Object[rowList.size()];
            hasil = rowList.toArray(hasil);
        } catch (SQLException ex) {
            ex.printStackTrace();
            hasil = null;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
        return hasil;
    }

    public Double[][] SelectD(String query, int colcount) {
        Double[][] hasil;
        try {
            con = Koneksi();
            query = query.replaceAll("`", "\"");
            stmt = con.createStatement();
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            List<Double[]> rowList = new ArrayList<>();
            List<Double> colList = new ArrayList<>();
            while (rs.next()){
                for (int j = 1; j < colcount+1; j++) {
                    colList.add(rs.getDouble(j));
                }
                Double[] colArr = new Double[colList.size()];
                colArr= colList.toArray(colArr);
                System.out.println(Arrays.toString(colArr));
                rowList.add(colArr);
            }
            hasil = new Double[rowList.size()][colList.size()];
            hasil = rowList.toArray(hasil);
            System.out.println(Arrays.deepToString(hasil));
        } catch (SQLException ex) {
            ex.printStackTrace();
            hasil = null;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
        return hasil;
    }

    public boolean Update(String data, String table, String condition) {
        try {
            con = Koneksi();
            String sql = "UPDATE " + table + " SET " + data + " WHERE " + condition;
            sql = sql.replaceAll("`", "\"");
            System.out.println(sql);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public boolean Update(String Query) {
        try {
            con = Koneksi();
            Query = Query.replaceAll("`", "\"");
            System.out.println(Query);
            stmt = con.createStatement();
            stmt.executeUpdate(Query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }


    public boolean Insert(String sql) {
        try {
            con = Koneksi();
            sql = sql.replaceAll("`", "\"");
            stmt = con.createStatement();
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public boolean Insert(String table, String data) {
        try {
            con = Koneksi();
            String sql = "INSERT INTO " + table + " VALUE (" + data + ")";
            sql = sql.replaceAll("`", "\"");
            stmt = con.createStatement();
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public boolean Delete(String table, String condition) {
        try {
            con = Koneksi();
            String sql = "DELETE FROM " + table + " WHERE " + condition + "";
            sql = sql.replaceAll("`", "\"");
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ignored){
            }
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public String CleanInput (String input){
        return input.replaceAll("'","''");
    }

}
