package steps;

import io.cucumber.java.en.And;

import static runner.RunnerTest.sectionPage;
import static util.ScreenshotMaker.makeScreenShoot;

public class SectionSteps {

    @And("select {int} product from the list in the section")
    public void selectProductFromTheListInTheSection(int number) {
        makeScreenShoot();
        sectionPage.selectProduct(number);
    }
}
