package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static final Properties prop = new Properties();

    public static Properties loadPropertyFile(String filePath) {
        try (FileReader fileReader = new FileReader(filePath + ".properties")){
            prop.load(fileReader);
        } catch (IOException e) {
            MyLogger.severe(PropertiesManager.class.getSimpleName(), "Can not load the flowing property file: "
                    + filePath);
            e.printStackTrace();
        }
        return prop;
    }
}
