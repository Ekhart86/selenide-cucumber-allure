package runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.Properties;
import properties.PropertiesLoader;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        extraGlue = {"api/steps", "database/steps", "ui/steps", "hooks"},
        tags = "@all",
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        strict = true)

public class RunnerTest {

    /**
     * Browser type, remote mode and headless mode
     * ​​are passed from the command line when running tests
     * <p>
     * mvn clean test
     * -Dbrowser=chrome
     * -Dheadless=1
     * -Dremote=true
     * -Dparallel=methods
     * -DthreadCount=2 or -DuseUnlimitedThreads=true
     */

    @BeforeClass
    public static void initSettings() {
        PropertiesLoader.loadProperties();
        Configuration.baseUrl = System.getProperty(Properties.BASE_URL);
        String headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
        Configuration.headless = headless.equals("1");
        initRemoteSettings(System.getProperty("remote"));
        Configuration.browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        Configuration.browserSize = "1980x1024";
        Configuration.timeout = 20000;
    }

    private static void initRemoteSettings(String remote) {
        if (remote != null && remote.equals("true")) {
            Configuration.remote = System.getProperty(Properties.SELENOID_URL) + ":4444/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
