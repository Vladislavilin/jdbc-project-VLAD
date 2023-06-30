package io.loopcamp.jdbctests.utility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 1st we make properties object
 * We make it private because do not want to be accessible outside the class
 * We make Properties obj static because do not want to create the object of the COnfiguration class to call
 * We make a static block because we want it to run first
 */
public class ConfigurationReader {
    private static Properties properties;


    static {
        try {
            String path = "config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            System.out.println("File is not Found");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName){
        return properties.getProperty(keyName);

    }

}
