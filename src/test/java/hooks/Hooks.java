package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static runner.Constants.SELENOID_VIDEO_URL;
import static util.ScreenshotMaker.makeScreenShoot;

public class Hooks {
    private final static Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void startScenario(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        logger.info("Run scenario - '" + scenario.getName() + "'");
    }

    @After
    public static void checkScenarioResult(Scenario scenario) {
        System.out.println("Scenario '" + scenario.getName() + "' - " + scenario.getStatus());
        if (scenario.isFailed()) {
            makeScreenShoot();
        }
        if (Configuration.remote != null) {
            RemoteWebDriver driver = (RemoteWebDriver) WebDriverRunner.getWebDriver();
            Allure.getLifecycle().addAttachment("Видео", "text/html", "html", videoInHtml(driver.getSessionId().toString()).getBytes());
        }
        WebDriverRunner.getWebDriver().close();
        logger.info("------------------------------------------------------------");
    }

    public static String videoInHtml(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + SELENOID_VIDEO_URL + sessionId + ".mp4"
                + "' type='video/mp4'></video></body></html>";
    }
}
