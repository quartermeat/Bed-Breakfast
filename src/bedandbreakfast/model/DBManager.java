/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.model;



import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author jeremy.williamson
 */
public class DBManager {

    private final String url = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String username = "quartermeat";
    private final String password = "JKha3454";
    
    private Connection connection;
    
    private OracleDataSource datasource;
        
    public DBManager(){        
  
    }//end constructor
    
    public void makeConnection() {
        try{
            datasource = new OracleDataSource();
            datasource.setURL(url);
            connection = datasource.getConnection(username, password);
        } catch (SQLException e){
            System.out.println(e);
        }//end try/catch
        
        if(connection != null){
            System.out.println("Connection is valid!");
        }else{
            System.out.println("Connection failed.");
        }//end if/else
        
    }//end getConnection()
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }   
        
}//end DBManager
