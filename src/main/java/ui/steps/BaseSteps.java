package ui.steps;

import io.cucumber.java.en.Given;
import util.PageLoader;

import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    @Given("user open {string}")
    public void userOpenPage(String pageName) {
        open(PageLoader.getPageUrl(pageName));
    }

}
