package ui.steps;

import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    @Given("user open page {string}")
    public void userOpenPageLogin(String page) {
        open(page);
    }
}
