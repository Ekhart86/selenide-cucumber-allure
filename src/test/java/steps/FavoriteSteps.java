package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static runner.RunnerTest.favoritePage;
import static util.ScreenshotMaker.makeScreenShoot;

public class FavoriteSteps {

    @Then("the favorites table with {int} entries is displayed")
    public void theFavoritesTableWithEntriesIsDisplayed(int quantity) {
        makeScreenShoot();
        favoritePage.checkQuantityFavoriteEntries(quantity);
    }

    @When("click on the button to clear the favorites list")
    public void clickOnTheClearButton() {
        favoritePage.clickClearAllButton();
        makeScreenShoot();
    }
}
