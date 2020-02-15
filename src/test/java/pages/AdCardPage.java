package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdCardPage {

    private SelenideElement addToFavoriteButton = $("#favs-link");
    private SelenideElement favoriteCounter = $("#favorites_count");
    private SelenideElement goToFavoritesPageButton = $("#myFav");

    public void scrollToAddFavoriteButton() {
        addToFavoriteButton.scrollIntoView(true);
    }

    public void scrollToFavoriteCounter() {
        favoriteCounter.scrollIntoView(false);
    }

    public void clickAddFavoriteButton() {
        addToFavoriteButton.click();
    }

    public void checkAddToFavoriteButtonName(String text) {
        addToFavoriteButton.shouldHave(text(text));
    }

    public void checkFavoriteCounterQuantity(int quantity) {
        favoriteCounter.shouldHave(text(String.valueOf(quantity)));
    }

    public void clickFavoriteTab() {
        goToFavoritesPageButton.click();
    }
}
