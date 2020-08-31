package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.Condition.text;

public class LoginSteps extends PageSet {

    @Когда("авторизуемся в приложении с логином {string} и паролем {string}")
    public void авторизуемсяВПриложенииСЛогиномИПаролем(String login, String password) {
        loginPage.loginField.setValue(login);
        loginPage.passwordField.setValue(password);
        loginPage.signInButton.click();
    }

    @Тогда("пользователь успешно авторизовался")
    public void пользовательУспешноАвторизовался() {
        loginPage.successMessage.shouldHave(text("You logged into a secure area!"));
    }

    @Тогда("пользователь не смог авторизоваться")
    public void пользовательНеСмогАвторизоваться() {
        loginPage.successMessage.shouldHave(text("Your username is invalid!"));
    }
}
