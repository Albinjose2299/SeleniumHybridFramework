package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.qa.constants.FrameworkConstants;

public class ConfigReader {

    Properties properties;

    public ConfigReader() {

        properties = new Properties();

        try {

            String environment = System.getProperty("env");

            if (environment == null) {
                environment = "qa";
            }

            FileInputStream fis =
                    new FileInputStream(
                            "src/main/resources/config-" + environment + ".properties");

            properties.load(fis);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public String getProperty(String key) {

        return properties.getProperty(key);

    }

}
