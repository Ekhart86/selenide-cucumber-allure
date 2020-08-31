package steps;

import io.cucumber.java.ru.Когда;

import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    @Когда("открываем страницу {string}")
    public void открываемСтраницу(String url) {
        open(url);
    }
}
