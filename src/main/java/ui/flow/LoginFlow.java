package ui.flow;

import ui.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;

public class LoginFlow {

    private final LoginPage loginPage = new LoginPage();

    public void setLogin(String login) {
        loginPage.getLoginField().setValue(login);
    }

    public void setPassword(String password) {
        loginPage.getPasswordField().setValue(password);
    }

    public void clickSignInButton() {
        loginPage.getSignInButton().click();
    }

    public void checkFailLoginMessage() {
        loginPage.getResultMessage().shouldHave(text("Your username is invalid!"));
    }

    public void checkSuccessLoginMessage() {
        loginPage.getResultMessage().shouldHave(text("You logged into a secure area!"));
    }

}
