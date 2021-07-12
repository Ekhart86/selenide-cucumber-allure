package database.steps;

import database.controller.DBCustomerController;
import database.model.Customer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;

public class DBCustomersSteps {

    @When("insert a new Customers to the database:")
    public void insertANewCustomersToTheDatabase(List<Customer> customers) throws SQLException {
        for (Customer customer : customers) {
            int result = DBCustomerController.insertNewCustomers(customer.getAge(), customer.getFirstName(), customer.getLastName());
            Assert.assertEquals("The user could not be added to the database", 1, result);
        }
    }

    @Then("check that customers exist in the database:")
    public void checkThatCustomersExistInTheDatabase(List<Customer> customers) throws SQLException {
        for (Customer customer : customers) {
            boolean result = DBCustomerController.isExistCustomer(customer.getAge(), customer.getFirstName(), customer.getLastName());
            Assert.assertTrue("Unable to find Customer with parameters : " +
                    "Age = " + customer.getAge() + ", " +
                    "FirstName = " + customer.getFirstName() + ", " +
                    "LastName = " + customer.getLastName(), result);
        }
    }

}
