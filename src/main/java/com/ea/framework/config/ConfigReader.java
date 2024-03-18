package com.ea.framework.config;

import com.ea.framework.base.BrowserTypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.readProperty();
    }
    private void readProperty() throws IOException {
        Properties properties = new Properties();
        //System.out.println(getClass().getResourceAsStream("GlobalConfig.properties"));
        properties.load(new FileInputStream("src/main/java/com/ea/framework/config/GlobalConfig.properties"));
        //properties.load(getClass().getResourceAsStream("GlobalConfig.properties"));

        Settings.AUTConnectionString = properties.getProperty("AUTConnectionString");
        Settings.ReportingConnectionString = properties.getProperty("ReportingConnectionString");
        Settings.LogPath = properties.getProperty("LogPath");
        Settings.DriverType = properties.getProperty("DriverType");
        Settings.ExcelSheetPath = properties.getProperty("ExcelSheetPath");
        Settings.AUT = properties.getProperty("AUT");
        Settings.BrowserType = BrowserTypes.valueOf(properties.getProperty("BrowserType"));
    }
}
