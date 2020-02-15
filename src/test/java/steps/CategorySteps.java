package steps;

import io.cucumber.java.en.And;

import static runner.RunnerTest.categoryPage;
import static util.ScreenshotMaker.makeScreenShoot;

public class CategorySteps {

    @And("select the {string} section")
    public void selectTheSection(String text) {
        makeScreenShoot();
        categoryPage.clickSection(text);
    }
}
