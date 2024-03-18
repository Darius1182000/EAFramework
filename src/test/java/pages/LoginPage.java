package pages;

import com.ea.framework.base.BasePage;
import com.ea.framework.base.DriverContext;
import com.ea.framework.controls.elements.Button;
import com.ea.framework.controls.elements.HyperLink;
import com.ea.framework.controls.elements.TextBox;
import com.ea.framework.controls.elements.TextBoxBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy (how = How.NAME, using = "username")
    public WebElement usernameFieldM;

    @FindBy (how = How.NAME, using = "password")
    public TextBox passwordFieldM;
    @FindBy (how = How.NAME, using = "username")
    public WebElement usernameField;

    @FindBy (how = How.NAME, using = "password")
    public WebElement passwordField;

    @FindBy (how = How.XPATH, using = "//button[@data-test='signin-submit']")
    public WebElement loginButton;

    @FindBy (how = How.XPATH, using = "//button[@data-test='signin-submit']")
    public Button loginButtonM;

    @FindBy(how = How.XPATH, using = "//*[@data-test='signup']")
    public HyperLink signUpLink;

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
        signUpLink.clickLink();
        return GetInstance(SignUpPage.class);
    }

    public void Login(String Username, String Password){
        DriverContext.waitForElementVisible(usernameField);
        usernameField.sendKeys(Username);
        passwordField.sendKeys(Password);
        loginButton.submit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void LoginM(String Username, String Password){
        TextBox textUser = new TextBoxBase(usernameFieldM);
        textUser.enterText(Username);

        passwordFieldM.enterText(Password);
        loginButtonM.performSubmit();
        //The above code works better after the classes from api package got implemented
    }

    public LoginPage clickLogin(){
        nextButton.click();
        return GetInstance(LoginPage.class);
    }

    public boolean isLogin(){
        return usernameField.isDisplayed();
    }
}
