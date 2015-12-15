/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.model;

import java.util.Objects;

/**
 *
 * @author Jeremy
 */
public class Customer {

    private int customerID;
    private String firstName;
    private String lastName;
    private Number creditCardNumber;
    private String address;
    private int reservation;

    public Customer() {
        customerID = 0;
        firstName = null;
        lastName = null;
        creditCardNumber = null;
        address = null;
        reservation = 0;
    }//end default constructor

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return (this.creditCardNumber.toString() == null ? other.creditCardNumber.toString() == null : this.creditCardNumber.toString().equals(other.creditCardNumber.toString()));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.creditCardNumber);
        return hash;
    }//end hashCode()

    public int getCustomerID() {
        return customerID;
    }
    
    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Number getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Number creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getReservation() {
        return reservation;
    }
    
    public void setReservation(int reservation){
        this.reservation = reservation;
    }

}//end Customer
