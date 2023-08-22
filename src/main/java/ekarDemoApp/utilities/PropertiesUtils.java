package ekarDemoApp.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties properties;

    public PropertiesUtils() {
    }

    public static Properties getConfig(){
        properties = new Properties();
        FileInputStream fileInput = null;

        try {
            fileInput = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInput);
        } catch (IOException fileNotException) {
            fileNotException.printStackTrace();
        }
        return properties;
    }
}
