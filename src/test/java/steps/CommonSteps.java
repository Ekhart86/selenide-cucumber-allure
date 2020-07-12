package steps;

import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.back;
import static util.ScreenshotMaker.makeScreenShoot;

public class CommonSteps {

    @When("go back to the previous page")
    public void goBackToThePreviousPage() {
        back();
    }
}
