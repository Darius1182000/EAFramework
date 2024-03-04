package com.ea.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base{

    public void initializeBrowser(BrowserTypes browserTypes){

        WebDriver driver = null;

        switch (browserTypes){
            case Chrome:
            {
                driver = new ChromeDriver();
                break;
            }
            case Firefox:
            {
                if(System.getProperty("os.name").contains("Mac OS")){
                    System.setProperty("webdriver.gecko.driver", "lib/geckodriverMAC");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", "lib/geckodriver-v0.33.0.exe");
                }
                driver = new FirefoxDriver();
            }
            case IE:
            {
                break;
            }
            case Safari:
            {
                break;
            }
        }

        //Set the driver
        DriverContext.setDriver(driver);
        //Browser
        DriverContext.Browser = new Browser(driver);

    }
}
