package com.ea.test.features.pages;

import com.ea.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public HomePage() {

    }

    @FindBy(how = How.LINK_TEXT, using = "Login or register")
    public WebElement loginLink;

    public void ClickLogin() {
        loginLink.click();
    }
}
