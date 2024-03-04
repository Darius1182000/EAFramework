package com.ea.test.pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage() {

    }

    @FindBy (how = How.NAME, using = "username")
    public WebElement usernameField;

    @FindBy (how = How.NAME, using = "password")
    public WebElement passwordField;

    @FindBy (how = How.XPATH, using = "//button[@data-test='signin-submit']")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@data-test='signup']")
    public WebElement signUpLink;

    @FindBy(how = How.XPATH, using = "//*[@data-test='user-onboarding-next']")
    public WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//*[@data-test='bankaccount-bankName-input'")
    public WebElement bankNameField;

    @FindBy(how = How.XPATH, using = "//*[@data-test='bankaccount-routingNumber-input'")
    public WebElement routingNumberField;

    @FindBy(how = How.XPATH, using = "//*[@data-test='bankaccount-routingNumber-input'")
    public WebElement accountNumberField;

    @FindBy(how = How.XPATH, using = "//*[@data-test='bankaccount-submit'")
    public WebElement saveButton;

    public SignUpPage clickSignUp(){
        signUpLink.click();
        return GetInstance(SignUpPage.class);
    }

    public void Login(String Username, String Password){
        usernameField.sendKeys(Username);
        passwordField.sendKeys(Password);
        loginButton.submit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public LoginPage clickLogin(){
        nextButton.click();
        return GetInstance(LoginPage.class);
    }

    public boolean isLogin(){
        return usernameField.isDisplayed();
    }
}
