package util;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static util.SizeReducer.resize;

public class ScreenshotMaker {

    private final static Logger logger = LoggerFactory.getLogger(ScreenshotMaker.class);

    public static void makeScreenShoot() {

        File scrFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = new byte[0];
        try {
            fileContent = toByteArrayAutoClosable(resize(scrFile, 1.0));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", fileContent);
    }

    private static byte[] toByteArrayAutoClosable(BufferedImage image) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", out);
            return out.toByteArray();
        }
    }
}
