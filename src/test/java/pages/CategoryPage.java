package pages;

import static com.codeborne.selenide.Selenide.$x;

public class CategoryPage {

    public void clickSection(String text) {
        $x("//a[contains(.,'" + text + "')]").click();
    }

}
