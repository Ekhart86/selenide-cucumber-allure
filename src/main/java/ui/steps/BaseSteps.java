package ui.steps;

import io.cucumber.java.ru.Когда;
import ui.flow.PageSet;

import static com.codeborne.selenide.Selenide.open;

public class BaseSteps extends PageSet {

    @Когда("открываем страницу {string}")
    public void открываемСтраницу(String url) {
        open(url);
    }
}
