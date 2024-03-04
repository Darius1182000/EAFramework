package com.ea.framework.config;

import com.ea.framework.base.BrowserTypes;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.readProperty();
    }
    private void readProperty() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("GlobalConfig.properties"));

        Settings.AUTConnectionString = properties.getProperty("AUTConnectionString");
        Settings.ReportingConnectionString = properties.getProperty("ReportingConnectionString");
        Settings.LogPath = properties.getProperty("LogPath");
        Settings.DriverType = properties.getProperty("DriverType");
        Settings.ExcelSheetPath = properties.getProperty("ExcelSheetPath");
        Settings.AUT = properties.getProperty("AUT");
        Settings.BrowserType = BrowserTypes.valueOf(properties.getProperty("BrowserType"));
    }
}
