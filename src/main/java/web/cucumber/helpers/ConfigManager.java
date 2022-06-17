package web.cucumber.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;

    public Properties initConfig(){
        properties=new Properties();
        try {
            FileInputStream config = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
    public Properties getConfig(){
        return properties;
    }
}
