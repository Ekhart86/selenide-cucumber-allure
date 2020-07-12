package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static runner.RunnerTest.mainPage;
import static util.ScreenshotMaker.makeScreenShoot;

public class MainPageSteps {

    @When("go to the {string} category")
    public void weGoToTheCategory(String text) {
        mainPage.clickCategory(text);
    }

    @Given("opened home page of ad site")
    public void openedHomePageOfAdSite() {
        mainPage.checkURL();
    }

    @When("enter {string} in the search bar and press Enter")
    public void enterInTheSearchBarAndPressEnter(String text) {
        mainPage.searchValue(text);
    }
}
