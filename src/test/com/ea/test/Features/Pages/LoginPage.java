package com.ea.test.Features.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //Initialize the PageFactory
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (how = How.NAME, using = "username")
    public WebElement usernameField;

    @FindBy (how = How.NAME, using = "password")
    public WebElement passwordField;

    @FindBy (how = How.XPATH, using = "//button[@data-test='signin-submit']")
    public WebElement loginButton;

    public void Login(String Username, String Password){

        usernameField.sendKeys(Username);
        passwordField.sendKeys(Password);
        loginButton.submit();
    }
}
