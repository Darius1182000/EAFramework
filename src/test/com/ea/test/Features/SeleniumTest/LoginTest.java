package com.ea.test.Features.SeleniumTest;

import com.ea.test.Features.Pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginTest {

    //Global variables
    private WebDriver driver = null;
    @BeforeEach
    public void Initialize(){
        //Open the browser
        //Windows
        //System.setProperty("webdriver.gecko.driver", "D:\\SeleniumDrivers\\geckodriver_mac-v0.33.0.exe");
        //MacOS
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver3_mac");

        driver = new FirefoxDriver();
        //driver.navigate().to("http://localhost:3000/signin");
        driver.navigate().to("https://www.google.com/");

    }
    @Test
    public void Login(){

//        driver.findElement(By.name("username")).sendKeys("test");
//        driver.findElement(By.name("password")).sendKeys("test12345");
//        driver.findElement(By.xpath("//button[@data-test='signin-submit']")).submit();
        //test

        LoginPage page = new LoginPage(driver);
        page.Login("nume", "parola");

    }
}
