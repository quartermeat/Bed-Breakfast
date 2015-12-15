/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public class ReservationList extends ArrayList<Reservation> {

    private final DBManager dbManager;

    public ReservationList() {
        super();
        dbManager = new DBManager();
    }//end constructor

    public void populateList() throws SQLException {
        dbManager.makeConnection();
        Connection connection = dbManager.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM RESERVATIONS");

        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Reservation reservation = new Reservation();

            reservation.setCustomerId(result.getInt("CUSTOMER"));
            reservation.setFirstDate(result.getDate("FIRSTDATE"));
            reservation.setLastDate(result.getDate("LASTDATE"));
            reservation.setReservationID(result.getInt("ID"));
            reservation.setRoomNumber(result.getInt("ROOMNUMBER"));
            reservation.setPricePerNight(result.getDouble("PRICEPERNIGHT"));
            String guaranteed = result.getString("GUARANTEED");
            if (guaranteed.equalsIgnoreCase("true")) {
                reservation.setGuaranteed(true);
            } else {
                reservation.setGuaranteed(false);
            }//end if/else

            this.add(reservation);
            System.out.println("one reservation populated");

        }//end while
    }

    public boolean addReservation(Reservation newReservation) {
        System.out.println("got here as well");
        dbManager.makeConnection();
        Connection connection = dbManager.getConnection();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(newReservation.getFirstDate().toString());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO RESERVATIONS"
                    + "(FIRSTDATE, LASTDATE, GUARANTEED, ROOMNUMBER, PRICEPERNIGHT, CUSTOMER)"
                    + "VALUES"
                    + "(TO_DATE('" + df.format(newReservation.getFirstDate()) + "','yyyy-MM-dd'),"
                    + "TO_DATE('" + df.format(newReservation.getLastDate()) + "', 'yyyy-MM-dd'), '"
                    + newReservation.isGuaranteed() + "', "
                    + newReservation.getRoomNumber() + ", "
                    + newReservation.getPricePerNight() + ", "
                    + newReservation.getCustomerId() + ")");
            preparedStatement.executeQuery();
            System.out.println("reservation added");
            //something here that verifies it was entered
        } catch (SQLException e) {
            System.out.println("SQL Error! Reservation did not get entered.");
            //something here that verifies there was an error
            e.printStackTrace();
        }//end try/catch

        return add(newReservation);
    }//end add()

    public Reservation searchCustomerID(int customerID) {
        for (Reservation currentReservation : this) {
            if (currentReservation.getCustomerId() == customerID) {
                return currentReservation;
            }//end if
        }//end for

        return null;
    }//end searchCustomerID

    public Reservation dateSearch(Date firstDate, Date lastDate) {
        for (Reservation currentReservation : this) {
            if (currentReservation.getFirstDate().before(firstDate)) {
                if (currentReservation.getLastDate().after(lastDate)) {
                    return currentReservation;
                } else if (currentReservation.getLastDate().before(lastDate)) {
                    if (currentReservation.getLastDate().after(firstDate)) {
                        return currentReservation;
                    }
                }
            } else if (currentReservation.getFirstDate().after(firstDate)) {
                if (currentReservation.getFirstDate().before(lastDate)) {
                    return currentReservation;
                }
            } else if (currentReservation.getFirstDate().equals(firstDate)) {
                return currentReservation;
            }//end if/else if/else if

        }//end for
        return null;
    }//end dataSearch()

}//end ReservationList
