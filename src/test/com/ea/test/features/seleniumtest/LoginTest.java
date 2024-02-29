package com.ea.test.features.seleniumtest;

import com.ea.framework.base.BrowserTypes;
import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.framework.utilities.DatabaseUtil;
import com.ea.framework.utilities.ExcelUtil;
import com.ea.framework.utilities.LogUtil;
import com.ea.test.features.pages.HomePage;
import com.ea.test.features.pages.SignUpPage;
import com.ea.test.features.pages.LoginPage;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;

public class LoginTest extends FrameworkInitialize {

    @BeforeEach
    public void Initialize() throws IOException {

//        String connectionUrl =
//                "jdbc:mysql://127.0.0.1:3306;"
//                        + "database=darius;"
//                        + "user=root;"
//                        + "password=root;"
//                        + "loginTimeout=30;";
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/darius?user=root&password=root&loginTimeout=30";

        Connection connection = DatabaseUtil.open(connectionUrl);
        DatabaseUtil.executeQuery("SELECT * FROM users",connection);

        LogUtil logUtil = new LogUtil();
        logUtil.createLogFile();
        logUtil.write("Framework Initialize");

        initializeBrowser(BrowserTypes.Firefox);
        DriverContext.Browser.goToUrl("http://localhost:3000/signin");

        try {
            ExcelUtil excelUtil = new ExcelUtil("lib/data.xls");
        } catch (BiffException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void Login(){

        CurrentPage = GetInstance(LoginPage.class);
        CurrentPage = CurrentPage.As(LoginPage.class).clickSignUp();
        CurrentPage = CurrentPage.As(SignUpPage.class).SignUp("darius", "merca", "darius112", "darius12345", "darius12345");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Hardcoded
        //CurrentPage.As(LoginPage.class).Login("darius112","darius12345");

        //Retrieve data from Excel sheet
        CurrentPage.As(LoginPage.class).Login(ExcelUtil.readCell("Username",1),
                ExcelUtil.readCell("Password",1));
//        String username = ExcelUtil.readCell(0, 1);
//        String password = ExcelUtil.readCell(1, 1);
//        System.out.println("Retrieved username: " + username);
//        System.out.println("Retrieved password: " + password);
//        CurrentPage.As(LoginPage.class).Login(username, password);
    }
}
