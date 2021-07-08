package properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private PropertiesLoader() {
    }

    public static void loadProperties() {
        String env = System.getProperty("env");
        logger.debug("Reading properties for environment: {}", env);
        Properties general = env == null ? readPropertiesFromFile(new Properties(), "properties/default.properties") :
                readPropertiesFromFile(new Properties(), "properties/" + env + ".properties");
        saveToSystemProperties(general);
    }

    static Properties readPropertiesFromFile(Properties target, String fileName) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName)) {
            target.load(inputStream);
        } catch (IOException e) {
            logger.error("Unable to read properties from file", e);
        }
        return target;
    }

    private static void saveToSystemProperties(Properties properties) {
        properties.stringPropertyNames().forEach(propertyName -> {
            if (!System.getProperties().containsKey(propertyName)) {
                System.setProperty(propertyName, properties.getProperty(propertyName));
            }
        });
    }

}
