/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.controller;

import bedandbreakfast.model.Customer;
import bedandbreakfast.model.CustomerList;
import bedandbreakfast.model.Reservation;
import bedandbreakfast.model.ReservationList;
import bedandbreakfast.view.MainWindow;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author jeremy.williamson
 */
public class EventHandler {

    private final MainWindow mainWindow;

    private CustomerList customerList;
    private ReservationList reservationList;

    //default constructor
    public EventHandler(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        customerList = new CustomerList();
        reservationList = new ReservationList();
        try {
            customerList.populateList();
            reservationList.populateList();
        } catch (SQLException e) {
            System.out.println("error loading customer list");
        }//end try/catch

    }//end constructor

    public void firstDatePickerSelected() {
        mainWindow.addSelectFirstDatePickerListener((java.awt.event.ActionEvent evt) -> {

            Date selectedDate = (Date) mainWindow.getFirstDatePicker().getModel().getValue();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String reportDate = df.format(selectedDate);
            mainWindow.setFirstDate(reportDate);
            //test actionlistener
            //JOptionPane.showMessageDialog(null, reportDate);
        });
    }

    public void lastDatePickerSelected() {
        mainWindow.addSelectLastDatePickerListener((java.awt.event.ActionEvent evt) -> {

            Date selectedDate = (Date) mainWindow.getLastDatePicker().getModel().getValue();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String reportDate = df.format(selectedDate);
            mainWindow.setLastDate(reportDate);
            //test actionlistener
            //JOptionPane.showMessageDialog(null, reportDate);
        });
    }

    public void addCustomerButtonPressed() {
        mainWindow.addCustomerButtonListener((java.awt.event.ActionEvent evt) -> {

            Customer newCustomer = new Customer();
            newCustomer.setFirstName(mainWindow.getCustomerFirstName());
            newCustomer.setLastName(mainWindow.getCustomerLastName());
            newCustomer.setAddress(mainWindow.getCustomerAddress());
            newCustomer.setCreditCardNumber(Long.valueOf(mainWindow.getCustomerCreditCard()));

            customerList.addCustomer(newCustomer);
        });
    }

    public void addSearchCardButtonPressed() {
        mainWindow.addSearchCardButtonListener((java.awt.event.ActionEvent evt) -> {
            Customer searchedCustomer = new Customer();
            searchedCustomer.setCreditCardNumber(Long.valueOf(mainWindow.getCustomerCreditCard()));
            System.out.println("card searched: " + searchedCustomer.getCreditCardNumber().toString());

            if (customerList.contains(searchedCustomer)) {
                int customerIndex = customerList.indexOf(searchedCustomer);
                Customer foundCustomer = customerList.get(customerIndex);

                mainWindow.setCustomerCreditCard(String.valueOf(foundCustomer.getCreditCardNumber()));
                mainWindow.setCustomerAddress(foundCustomer.getAddress());
                mainWindow.setCustomerFirstName(foundCustomer.getFirstName());
                mainWindow.setCustomerLastName(foundCustomer.getLastName());
                mainWindow.setCustomersId(foundCustomer.getCustomerID());
            } else {
                System.out.println("customer not found");
            }

        });
    }

    public void addAddReservationButtonPressed() {
        mainWindow.addAddReservationButtonListener((java.awt.event.ActionEvent evt) -> {
            Reservation newReservation = new Reservation();
            newReservation.setCustomerId(Integer.valueOf(mainWindow.getCustomerID()));
            newReservation.setFirstDate(Date.valueOf(mainWindow.getFirstDate()));
            newReservation.setLastDate(Date.valueOf(mainWindow.getLastDate()));
            newReservation.setGuaranteed(mainWindow.getGuaranteed());
            newReservation.setPricePerNight(mainWindow.getPricePerNight());
            newReservation.setRoomNumber(mainWindow.getRoomNumber());
            reservationList.addReservation(newReservation);
        });
    }

    public void addSearchCardReservationButtonPressed() {
        mainWindow.addSearchCardReservationButtonListener((java.awt.event.ActionEvent evt) -> {
            Customer searchedCustomer = new Customer();
            Customer foundCustomer;
            searchedCustomer.setCreditCardNumber(Long.valueOf(mainWindow.getReservationCreditCard()));
            System.out.println("card searched: " + searchedCustomer.getCreditCardNumber().toString());

            if (customerList.contains(searchedCustomer)) {
                int customerIndex = customerList.indexOf(searchedCustomer);
                foundCustomer = customerList.get(customerIndex);

                Reservation foundReservation = reservationList.searchCustomerID(foundCustomer.getCustomerID());

                if (foundReservation != null) {
                    mainWindow.setCustomerId(foundReservation.getCustomerId());
                    mainWindow.setFirstDate(foundReservation.getFirstDate().toString());
                    mainWindow.setLastDate(foundReservation.getLastDate().toString());
                    mainWindow.setGuaranteed(foundReservation.isGuaranteed());
                    mainWindow.setRoomNumber(foundReservation.getRoomNumber());
                    mainWindow.setPricePerNight(foundReservation.getPricePerNight());
                } else {
                    System.out.println("no reservations found");
                }//end if/else
            } else {
                System.out.println("no customers found");
            }//end if/else
        });
    }//end addSearchCardReservationButtonPressed

    public void addSearchDatesButtonPressed() {
        mainWindow.addSearchDatesButtonListener((java.awt.event.ActionEvent evt) -> {
            try {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                Date firstDate = new Date(format.parse(mainWindow.getFirstDate()).getTime());
                Date lastDate = new Date(format.parse(mainWindow.getLastDate()).getTime());

                Reservation foundReservation = reservationList.dateSearch(firstDate, lastDate);

                if (foundReservation != null) {
                    mainWindow.setCustomerId(foundReservation.getCustomerId());
                    mainWindow.setFirstDate(foundReservation.getFirstDate().toString());
                    mainWindow.setLastDate(foundReservation.getLastDate().toString());
                    mainWindow.setGuaranteed(foundReservation.isGuaranteed());
                    mainWindow.setRoomNumber(foundReservation.getRoomNumber());
                    mainWindow.setPricePerNight(foundReservation.getPricePerNight());
                } else {
                    System.out.println("no reservation found");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

}//end eventhandler
