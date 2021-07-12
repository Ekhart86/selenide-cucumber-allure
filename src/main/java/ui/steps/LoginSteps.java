package ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.flow.LoginFlow;

public class LoginSteps {

    private final LoginFlow loginFlow = new LoginFlow();

    @When("user log in with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String login, String password) {
        loginFlow.setLogin(login);
        loginFlow.setPassword(password);
        loginFlow.clickSignInButton();
    }

    @When("user sets login {string}")
    public void userSetsLogin(String login) {
        loginFlow.setLogin(login);
    }

    @When("user sets password {string}")
    public void userSetsPassword(String password) {
        loginFlow.setPassword(password);
    }

    @When("user click on Sign in button")
    public void userClickOnSignInButton() {
        loginFlow.clickSignInButton();
    }

    @Then("message about an incorrect username or password is displayed")
    public void messageAboutAnIncorrectUsernameOrPasswordIsDisplayed() {
        loginFlow.checkFailLoginMessage();
    }

    @Then("message about successful authorization is displayed")
    public void messageAboutSuccessfulAuthorizationIsDisplayed() {
        loginFlow.checkSuccessLoginMessage();
    }

}
