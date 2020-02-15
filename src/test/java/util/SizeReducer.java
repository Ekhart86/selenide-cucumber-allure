package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SizeReducer {

    private static Logger logger = LoggerFactory.getLogger(SizeReducer.class);

    /**
     * The method changes the image size
     * @param percentage 1.0 original size
     */
    public static BufferedImage resize(File picture, double percentage) {

        BufferedImage resized = null;
        BufferedImage image;
        try {
            image = ImageIO.read(picture);
            int newHeight = (int) (image.getHeight() * percentage);
            int newWidth = (int) (image.getWidth() * percentage);
            Image tmp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resized.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
        } catch (IOException e) {
            logger.error("Could not reduce the size of the picture.");
            logger.error(e.getMessage());
        }
        return resized;
    }

}

