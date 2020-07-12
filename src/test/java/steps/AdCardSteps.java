package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static runner.RunnerTest.adCardPage;
import static util.ScreenshotMaker.makeScreenShoot;

public class AdCardSteps {

    @When("scroll to add favorites button")
    public void iScrollToAddFavorites() {
        adCardPage.scrollToAddFavoriteButton();
    }

    @When("click on the add to favorites button")
    public void iClickOnTheAddToFavoritesButton() {
        adCardPage.clickAddFavoriteButton();
    }

    @When("scroll to the 'Favorites' tab")
    public void iScrollToTheCounterAddedToFavorites() {
        adCardPage.scrollToFavoriteCounter();
    }

    @Then("the 'Favorites' tab shows {int} added products")
    public void theCounterAddedToFavoritesShowsAddedProduct(int quantity) {
        adCardPage.checkFavoriteCounterQuantity(quantity);
    }

    @Then("the add to favorites button is named {string}")
    public void theAddToFavoritesButtonIsNamed(String text) {
        adCardPage.checkAddToFavoriteButtonName(text);
    }

    @When("click on the 'Favorites' tab")
    public void iClickOnTheFavoritesTab() {
        adCardPage.clickFavoriteTab();
    }
}
