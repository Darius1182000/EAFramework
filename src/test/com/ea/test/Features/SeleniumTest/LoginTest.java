package com.ea.test.Features.SeleniumTest;

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
        System.setProperty("webdriver.gecko.driver", "D:\\SeleniumDrivers\\geckodriver-v0.33.0.exe");

        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:3000/signin");

    }
    @Test
    public void Login(){

        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("test12345");
        driver.findElement(By.xpath("//button[@data-test='signin-submit']")).submit();

    }
}
