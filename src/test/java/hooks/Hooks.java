package hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;
import static io.cucumber.core.event.Status.PASSED;
import static runner.RunnerTest.BASE_URL;
import static util.ScreenshotMaker.makeScreenShoot;


public class Hooks {
    private static Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void startScenario(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        logger.info("Run scenario - '" + scenario.getName() + "'");
        logger.info("------------------------------------------------------------");
        open(BASE_URL);
    }

    @After
    public static void checkScenarioResult(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        System.out.println("Scenario '" + scenario.getName() + "' - " + scenario.getStatus());
        if (!scenario.getStatus().equals(PASSED)) {
            makeScreenShoot();
        }
        logger.info("------------------------------------------------------------");
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

}
