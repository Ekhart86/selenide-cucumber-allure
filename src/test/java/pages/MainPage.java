package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static runner.RunnerTest.BASE_URL;

public class MainPage {

    private SelenideElement searchInputField = $("#search_value");

    public void clickCategory(String text) {
        $x("//a[@title='Объявления " + text + "']//b").click();
    }

    public void checkURL() {
        assertEquals("URL does not match", BASE_URL, url());
    }

    public void searchValue(String text) {
        searchInputField.setValue(text).pressEnter();
    }
}
