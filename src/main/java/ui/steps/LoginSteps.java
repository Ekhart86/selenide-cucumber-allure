package ui.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ui.flow.LoginFlow;


public class LoginSteps {

    LoginFlow loginFlow = new LoginFlow();

    @Когда("авторизуемся в приложении с логином {string} и паролем {string}")
    public void авторизуемсяВПриложенииСЛогиномИПаролем(String login, String password) {
        loginFlow.setLogin(login);
        loginFlow.setPassword(password);
        loginFlow.clickSignInButton();
    }

    @Тогда("отображается сообщение о некорректном логине или пароле")
    public void отображаетсяСообщениеОНекорректномЛогинеИлиПароле() {
        loginFlow.checkFailLoginMessage();
    }

    @Тогда("отображается сообщение об успешной авторизации")
    public void отображаетсяСообщениеОбУспешнойАвторизации() {
        loginFlow.checkSuccessLoginMessage();
    }

}
