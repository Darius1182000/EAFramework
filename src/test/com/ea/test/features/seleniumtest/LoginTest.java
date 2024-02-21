package com.ea.test.features.seleniumtest;

import com.ea.framework.base.DriverContext;
import com.ea.test.features.pages.HomePage;
import com.ea.test.features.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

    @BeforeEach
    public void Initialize(){

        if(System.getProperty("os.name").contains("Mac OS")){
            System.setProperty("webdriver.gecko.driver", "lib/geckodriverMAC");
        } else if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", "D:\\SeleniumDrivers\\geckodriver_mac-v0.33.0.exe");
        }

        DriverContext.Driver = new FirefoxDriver();
        //driver.navigate().to("http://localhost:3000/signin");
        DriverContext.Driver.navigate().to("https://automationteststore.com/");

    }
    @Test
    public void Login(){

//        LoginPage page = new LoginPage(driver);
//        page.Login("nume", "parola");

        HomePage homePage = new HomePage();
        homePage.ClickLogin();

        LoginPage page = new LoginPage();
        page.SignIn("darius", "darius123");

    }
}
