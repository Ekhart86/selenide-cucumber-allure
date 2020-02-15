package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FavoritePage {

    private ElementsCollection rowCollection = $$(".table_ver1 tr");
    private SelenideElement clearAllButton = $(byAttribute("value", "Очистить список"));

    public void checkQuantityFavoriteEntries(int quantity) {
        rowCollection.shouldHaveSize(quantity);
    }

    public void clickClearAllButton() {
        clearAllButton.click();
    }
}
