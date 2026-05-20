package swagLabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static String getProperty(String key) {
        if (properties == null) {
            try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
                properties = new Properties();
                properties.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Could not load config.properties");
            }
        }
        return properties.getProperty(key);
    }
}
