package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import properties.Properties;
import properties.PropertiesLoader;
import util.ScreenshotMaker;
import util.TestContext;

public class Hooks {

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

    @Before(value = "not @API")
    public static void initSettings(Scenario scenario) {
        TestContext.resetContext();
        PropertiesLoader.loadProperties();
        Configuration.baseUrl = System.getProperty(Properties.BASE_URL);
        Configuration.headless = Boolean.parseBoolean(System.getProperty(Properties.TEST_HEADLESS));
        initRemoteSettings(Boolean.parseBoolean(System.getProperty(Properties.TEST_REMOTE)));
        Configuration.browser = System.getProperty(Properties.TEST_BROWSER);
        Configuration.browserSize = "1980x1024";
        Configuration.timeout = 20000;
        System.out.println("------------------------------------------------------------");
        System.out.println("Run scenario - '" + scenario.getName() + "'");
    }

    private static void initRemoteSettings(boolean remote) {
        if (remote) {
            Configuration.remote = System.getProperty(Properties.SELENOID_URL) + ":4444/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @After(value = "not @API")
    public static void checkScenarioResult(Scenario scenario) {
        System.out.println("Scenario '" + scenario.getName() + "' - " + scenario.getStatus());
        if (scenario.isFailed()) {
            ScreenshotMaker.makeScreenShoot();
        }
        if (Configuration.remote != null) {
            RemoteWebDriver driver = (RemoteWebDriver) WebDriverRunner.getWebDriver();
            Allure.getLifecycle().addAttachment("Видео", "text/html", "html", videoInHtml(driver.getSessionId().toString()).getBytes());
        }
        WebDriverRunner.getWebDriver().quit();
        System.out.println("------------------------------------------------------------");
    }

    public static String videoInHtml(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + System.getProperty(Properties.SELENOID_VIDEO_URL) + sessionId + ".mp4"
                + "' type='video/mp4'></video></body></html>";
    }

}
