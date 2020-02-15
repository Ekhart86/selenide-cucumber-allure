package runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pages.*;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"steps", "hooks"},
        tags = {"@all"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
)

public class RunnerTest {

    public static String BASE_URL = "https://www.reklama.lv/ru/";
    public static MainPage mainPage;
    public static CategoryPage categoryPage;
    public static SectionPage sectionPage;
    public static AdCardPage adCardPage;
    public static FavoritePage favoritePage;

    @BeforeClass
    public static void initSettings() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1980x1024";
        Configuration.timeout = 20000;
        mainPage = new MainPage();
        categoryPage = new CategoryPage();
        sectionPage = new SectionPage();
        adCardPage = new AdCardPage();
        favoritePage = new FavoritePage();
    }

}
