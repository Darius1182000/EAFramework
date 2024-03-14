package com.ea.test.seleniumtest;

import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.framework.config.ConfigReader;
import com.ea.framework.config.Settings;
import com.ea.framework.utilities.DatabaseUtil;
import com.ea.framework.utilities.ExcelUtil;
import com.ea.framework.utilities.LogUtil;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
//import io.cucumber.java.Before;

public class TestInitializeJunit extends FrameworkInitialize {

    @BeforeEach
    public void Initialize() throws IOException {

        //Initialize config
        ConfigReader.populateSettings();
        //Logging
        Settings.Logs = new LogUtil();
        Settings.Logs.createLogFile();
        //Access the database
        Settings.AUTConnection = DatabaseUtil.open(Settings.AUTConnectionString);
        DatabaseUtil.executeQuery("SELECT * FROM users",Settings.AUTConnection);
        //Initialize browser
        Settings.Logs.write("Test Cycle Created");
        initializeBrowser(Settings.BrowserType);
        Settings.Logs.write("Browser initialized");
        DriverContext.Browser.goToUrl(Settings.AUT);//AUT=Application under test
        Settings.Logs.write("Navigated to URL: " + Settings.AUT);


        try {
            ExcelUtil excelUtil = new ExcelUtil(Settings.ExcelSheetPath);
        } catch (BiffException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
