package com.ea.test.features.pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    public HomePage(){

    }

    @FindBy(how = How.XPATH, using = "//button[@data-test='user-onboarding-next']")
    public WebElement nextButton;

    public void completeOnboarding(){
        nextButton.click();
    }
}
