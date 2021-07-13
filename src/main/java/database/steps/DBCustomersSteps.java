package database.steps;

import database.controller.DBCustomerController;
import database.entity.CustomerEntity;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;

public class DBCustomersSteps {

    @When("insert a new Customers to the database:")
    public void insertANewCustomersToTheDatabase(List<CustomerEntity> customerEntities) throws SQLException {
        for (CustomerEntity customerEntity : customerEntities) {
            int result = DBCustomerController.insertNewCustomers(customerEntity.getAge(), customerEntity.getFirstName(), customerEntity.getLastName());
            Assert.assertEquals("The user could not be added to the database", 1, result);
        }
    }

    @Then("check that customers exist in the database:")
    public void checkThatCustomersExistInTheDatabase(List<CustomerEntity> customerEntities) throws SQLException {
        for (CustomerEntity customerEntity : customerEntities) {
            boolean result = DBCustomerController.isExistCustomer(customerEntity.getAge(), customerEntity.getFirstName(), customerEntity.getLastName());
            Assert.assertTrue("Unable to find Customer with parameters : " +
                    "Age = " + customerEntity.getAge() + ", " +
                    "FirstName = " + customerEntity.getFirstName() + ", " +
                    "LastName = " + customerEntity.getLastName(), result);
        }
    }

}
