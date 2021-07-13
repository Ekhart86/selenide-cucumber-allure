package ui.flow;

import ui.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class LoginFlow {

    public void setLogin(String login) {
        page(LoginPage.class).getLoginField().setValue(login);
    }

    public void setPassword(String password) {
        page(LoginPage.class).getPasswordField().setValue(password);
    }

    public void clickSignInButton() {
        page(LoginPage.class).getSignInButton().click();
    }

    public void checkFailLoginMessage() {
        page(LoginPage.class).getResultMessage().shouldHave(text("Your username is invalid!"));
    }

    public void checkSuccessLoginMessage() {
        page(LoginPage.class).getResultMessage().shouldHave(text("You logged into a secure area!"));
    }

}
