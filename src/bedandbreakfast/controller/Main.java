/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.controller;

import bedandbreakfast.view.MainWindow;

/**
 *
 * @author jeremy.williamson
 */
public class Main {
    
    private final MainWindow mainWindow;
    private final EventHandler eventHandler;
        
    public Main(){
        mainWindow = new MainWindow();
        eventHandler = new EventHandler();
    }//end constructor
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Main application = new Main();
        
    }//end main
    
}//end main
