/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeremy.williamson
 */
public class DBManager {

    private static final String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql599053";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String username = "sql599053";
    private static final String password = "pFGV5IlA3r";
    
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    
    public DBManager(){
        
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException|ClassNotFoundException ex) {
            // log an exception. fro example:
            System.out.println("Failed to create the database connection.");
            System.out.println(ex);
        }//end try/catch
        
    }//end constructor
    
    
        
}//end DBManager
