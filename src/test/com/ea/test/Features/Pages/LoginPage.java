package com.ea.test.Features.Pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    //Initialize the PageFactory
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (how = How.NAME, using = "username")
    public WebElement usernameField;

    @FindBy (how = How.NAME, using = "loginname")
    public WebElement loginNameField;

    @FindBy (how = How.NAME, using = "password")
    public WebElement passwordField;

    @FindBy (how = How.XPATH, using = "//button[@data-test='signin-submit']")
    public WebElement loginButton;

    @FindBy (how = How.XPATH, using = "//button[@title='Login']")
    public WebElement signInButton;

    public void Login(String Username, String Password){

        usernameField.sendKeys(Username);
        passwordField.sendKeys(Password);
        loginButton.submit();
    }

    public void SignIn(String LoginName, String Password){

        loginNameField.sendKeys(LoginName);
        passwordField.sendKeys(Password);
        signInButton.submit();
    }
}
