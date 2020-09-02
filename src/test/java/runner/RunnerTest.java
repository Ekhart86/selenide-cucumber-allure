package runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        extraGlue = {"steps", "hooks"},
        tags = {"@all"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"})

public class RunnerTest {
    /**
     * Browser and headless values ​​are passed from the command line when running tests
     * mvn test -Dbrowser=chrome -Dheadless=1
     */
    @BeforeClass
    public static void initSettings() {
        String headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
        Configuration.headless = headless.equals("1");
        Configuration.browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        Configuration.browserSize = "1980x1024";
        Configuration.timeout = 20000;
    }
}
