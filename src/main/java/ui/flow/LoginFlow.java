package ui.flow;

import ui.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;

public class LoginFlow {

    private final LoginPage loginPage = new LoginPage();

    public void setLogin(String login) {
        loginPage.loginField.setValue(login);
    }

    public void setPassword(String password) {
        loginPage.passwordField.setValue(password);
    }

    public void clickSignInButton() {
        loginPage.signInButton.click();
    }

    public void checkFailLoginMessage() {
        loginPage.successMessage.shouldHave(text("Your username is invalid!"));
    }

    public void checkSuccessLoginMessage() {
        loginPage.successMessage.shouldHave(text("You logged into a secure area!"));
    }

}
