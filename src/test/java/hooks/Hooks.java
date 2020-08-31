package hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MyScreenRecorder;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static io.cucumber.core.event.Status.PASSED;
import static util.ScreenshotMaker.makeScreenShoot;


public class Hooks {
    private final static Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void startScenario(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        logger.info("Run scenario - '" + scenario.getName() + "'");
        logger.info("------------------------------------------------------------");
    }

    @After
    public static void checkScenarioResult(Scenario scenario) throws Exception {
        logger.info("------------------------------------------------------------");
        System.out.println("Scenario '" + scenario.getName() + "' - " + scenario.getStatus());
        if (!scenario.getStatus().equals(PASSED)) {
            makeScreenShoot();
        }
        logger.info("------------------------------------------------------------");
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

    @Before("@video")
    public void startVideoRecording(Scenario scenario) throws Exception {
        logger.info("Start recording the test video " + scenario.getName());
        MyScreenRecorder.startRecording(scenario.getName());
    }

    @After("@video")
    public static void attachVideo(Scenario scenario) throws Exception {
        MyScreenRecorder.stopRecording();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        try {
            File file = new File("target/recordings/" + scenario.getName() + ".avi");
            byte[] fileContent = Files.readAllBytes(file.toPath());
            Allure.getLifecycle().addAttachment(scenario.getName() + "-" + dateFormat.format(new Date()), "video/avi", "avi", fileContent);
            logger.info("The video was successfully attached to the report");
        } catch (Exception e) {
            logger.info("Unable to attach video to the report " + e.getMessage());
            e.printStackTrace();
        }
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

}
