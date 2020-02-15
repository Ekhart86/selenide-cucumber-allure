package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class SectionPage {

    private ElementsCollection rowCollection = $$("#posts tr");

    public void selectProduct(int number) {
        rowCollection.get(number).click();
    }
}
