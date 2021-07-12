package database.controller;

import database.DBConnector;
import database.model.Customer;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ScreenshotMaker;

import java.sql.SQLException;
import java.util.List;

public class DBCustomerController {

    private final static Logger logger = LoggerFactory.getLogger(ScreenshotMaker.class);
    private static final String INSERT_NEW_CUSTOMERS = "INSERT Customers(Age, FirstName, LastName) VALUES (?, ?, ?);";
    private static final String IS_EXIST_CUSTOMER = "SELECT * FROM Customers WHERE Age= ? AND FirstName = ? AND LastName = ?;";

    public static int insertNewCustomers(String age, String firstName, String lastName) throws SQLException {
        logger.info("INSERT Customer age = {}, firstName = {}, lastName = {}", age, firstName, lastName);
        return DBConnector.getInstance().executeUpdate(INSERT_NEW_CUSTOMERS, age, firstName, lastName);
    }

    public static boolean isExistCustomer(String age, String firstName, String lastName) throws SQLException {
        logger.info("SELECT Customer with parameters: age = {}, firstName = {}, lastName = {}", age, firstName, lastName);
        ResultSetHandler<List<Customer>> h = new BeanListHandler<>(Customer.class);
        return DBConnector.getInstance().getQueryResults(IS_EXIST_CUSTOMER, h, age, firstName, lastName).size() > 0;
    }

}
