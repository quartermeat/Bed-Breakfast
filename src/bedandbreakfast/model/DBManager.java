/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jeremy.williamson
 */
public class DBManager {

    private static final String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql599053";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String username = "sql599053";
    private static final String password = "pFGV5IlA3r";
    private static Connection con;

    public static Connection getConnection() {
        
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException|ClassNotFoundException ex) {
            // log an exception. fro example:
            System.out.println("Failed to create the database connection.");
            System.out.println(ex);
        }//end try/catch

        return con;
    }
}
