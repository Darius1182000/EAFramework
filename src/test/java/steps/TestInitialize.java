package steps;

import com.aventstack.extentreports.GherkinKeyword;
import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.framework.config.ConfigReader;
import com.ea.framework.config.Settings;
import com.ea.framework.utilities.DatabaseUtil;
import com.ea.framework.utilities.ExcelUtil;
import com.ea.framework.utilities.ExtentReport;
import com.ea.framework.utilities.LogUtil;
import io.cucumber.java.Scenario;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.sql.Connection;
import io.cucumber.java.Before;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void Initialize(Scenario scenario) throws IOException, ClassNotFoundException {

        //Insert the scenario name
        ExtentReport.scenario = ExtentReport.feature.createNode(new GherkinKeyword("Scenario"), scenario.getName());

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