package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.App;

import static com.codeborne.selenide.Condition.text;

public class LoginSteps {

    private final App app = new App();

    @Когда("авторизуемся в приложении с логином {string} и паролем {string}")
    public void авторизуемсяВПриложенииСЛогиномИПаролем(String login, String password) {
        app.loginPage.loginField.setValue(login);
        app.loginPage.passwordField.setValue(password);
        app.loginPage.signInButton.click();
    }

    @Тогда("пользователь успешно авторизовался")
    public void пользовательУспешноАвторизовался() {
        app.loginPage.successMessage.shouldHave(text("You logged into a secure area!"));
    }

    @Тогда("пользователь не смог авторизоваться")
    public void пользовательНеСмогАвторизоваться() {
        app.loginPage.successMessage.shouldHave(text("Your username is invalid!"));
    }
}
