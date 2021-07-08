package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.remote.RemoteWebDriver;
import properties.Properties;
import util.ScreenshotMaker;


public class Hooks {

    @Before
    public void startScenario(Scenario scenario) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Run scenario - '" + scenario.getName() + "'");
    }

    @After
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
