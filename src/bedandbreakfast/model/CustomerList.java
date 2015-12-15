/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public class CustomerList extends ArrayList<Customer> {

    private final DBManager dbManager;

    //default constructor
    public CustomerList() {
        super();
        dbManager = new DBManager();
    }//end constructor

    public void populateList() throws SQLException {
        dbManager.makeConnection();
        Connection connection = dbManager.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS");

        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Customer customer = new Customer();

            customer.setCustomerID(result.getInt("ID"));
            customer.setFirstName(result.getString("FIRSTNAME"));
            customer.setLastName(result.getString("LASTNAME"));
            customer.setCreditCardNumber(result.getBigDecimal("CREDITCARDNUMBER"));
            customer.setAddress(result.getString("ADDRESS"));
            customer.setReservation(result.getInt("RESERVATION"));

            this.add(customer);
            System.out.println("one customer populated");

        }//end while
    }

    public boolean addCustomer(Customer newCustomer) {
        dbManager.makeConnection();
        Connection connection = dbManager.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CUSTOMERS"
                    + "(FIRSTNAME, LASTNAME, CREDITCARDNUMBER, ADDRESS)"
                    + "VALUES"
                    + "('" + newCustomer.getFirstName() + "', '"
                    + newCustomer.getLastName() + "', '"
                    + newCustomer.getCreditCardNumber() + "', '"
                    + newCustomer.getAddress() + "')");
            preparedStatement.executeQuery();
            //something here that verifies it was entered
        } catch (SQLException e) {
            System.out.println("SQL Error! Customer did not get entered.");
            //something here that verifies there was an error
            e.printStackTrace();
        }//try/catch

        return add(newCustomer);
    }//end add()

}
