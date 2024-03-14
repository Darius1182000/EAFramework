package com.ea.test.pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SignUpPage extends BasePage {

    @FindBy (how = How.NAME, using = "firstName")
    public WebElement firstNameField;

    @FindBy (how = How.NAME, using = "lastName")
    public WebElement lastNameField;

    @FindBy (how = How.NAME, using = "username")
    public WebElement usernameField;

    @FindBy (how = How.NAME, using = "password")
    public WebElement passwordField;

    @FindBy (how = How.NAME, using = "confirmPassword")
    public WebElement confirmPasswordField;

    @FindBy (how = How.XPATH, using = "//button[@data-test='signup-submit']")
    public WebElement signUpButton;

    @FindBy (how = How.XPATH, using = "//a[@href='/signin']")
    public WebElement signInLink;


    public BasePage SignUp(String FirstName, String LastName, String Username, String Password, String ConfirmPassword){

        firstNameField.sendKeys(FirstName);
        lastNameField.sendKeys(LastName);
        usernameField.sendKeys(Username);
        passwordField.sendKeys(Password);
        confirmPasswordField.sendKeys(ConfirmPassword);
        signUpButton.submit();
        return GetInstance(LoginPage.class);
    }
}
