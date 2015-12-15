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

    private static MainWindow mainWindow;

    public Main() {
        mainWindow = new MainWindow();
    }//end constructor

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Main application = new Main();
        mainWindow.getEventHandler().firstDatePickerSelected();
        mainWindow.getEventHandler().lastDatePickerSelected();
        mainWindow.getEventHandler().addCustomerButtonPressed();
        mainWindow.getEventHandler().addSearchCardButtonPressed();
        mainWindow.getEventHandler().addAddReservationButtonPressed();
        mainWindow.getEventHandler().addSearchCardReservationButtonPressed();
        mainWindow.getEventHandler().addSearchDatesButtonPressed();

    }//end main

}//end main
