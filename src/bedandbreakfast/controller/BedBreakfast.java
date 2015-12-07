/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.controller;

import bedandbreakfast.model.DBManager;
import java.sql.Connection;

/**
 *
 * @author jeremy.williamson
 */
public class BedBreakfast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBManager dbMan = new DBManager();
        
        Connection connection = DBManager.getConnection();
        
        
    }
    
}
