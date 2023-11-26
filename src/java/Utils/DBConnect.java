package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ghuy
 */
public class DBConnect {

    protected Connection connect = null;
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=swpv4";
    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_USR = "sa";
    private static final String DB_PWD = "12345";

    public DBConnect() {
        try {
            Class.forName(DB_DRIVER);
            connect = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            System.out.println("Connected successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Execute SQL Statement and get back the data
     *
     * @param sqlStatement SQL Statement to be executed
     * @return ResultSet object contains data
     */
    public ResultSet getData(String sqlStatement) {
        ResultSet rs = null;
        Statement statement = null;

        try {
            statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery(sqlStatement);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public DBConnect(String url, String username, String password) {
        try {
            Class.forName(DB_DRIVER);
            connect = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
 
        Connection con = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
        return con;
    }
    
    
}
