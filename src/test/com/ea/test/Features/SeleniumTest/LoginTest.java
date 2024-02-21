package com.ea.test.Features.SeleniumTest;

import com.ea.test.Features.Pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

    //Global variables
    private WebDriver driver = null;
    @BeforeEach
    public void Initialize(){

        if(System.getProperty("os.name").contains("Mac OS")){
            System.setProperty("webdriver.gecko.driver", "lib/geckodriverMAC");
        } else if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", "D:\\SeleniumDrivers\\geckodriver_mac-v0.33.0.exe");
        }

        driver = new FirefoxDriver();
        //driver.navigate().to("http://localhost:3000/signin");
        driver.navigate().to("https://automationteststore.com/index.php?rt=account/login");

    }
    @Test
    public void Login(){

//        LoginPage page = new LoginPage(driver);
//        page.Login("nume", "parola");
        LoginPage page = new LoginPage(driver);
        page.SignIn("darius", "parola1");

    }
}
