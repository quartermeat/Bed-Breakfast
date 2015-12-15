/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.model;

import java.sql.Date;

/**
 *
 * @author Jeremy
 */
public class Reservation {
    private int reservationID;    
    private Date firstDate;
    private Date lastDate;
    private boolean guaranteed;
    private int roomNumber;
    private int customerID;
    private double pricePerNight;

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    public Reservation(){
        
    }//end default constructor
    
    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public boolean isGuaranteed() {
        return guaranteed;
    }

    public void setGuaranteed(boolean guaranteed) {
        this.guaranteed = guaranteed;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCustomerId() {
        return customerID;
    }

    public void setCustomerId(int customer) {
        this.customerID = customer;
    }
}//end Reservation
