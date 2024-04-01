package com.ea.framework.controls.elements;

import com.ea.framework.base.DriverContext;
import com.ea.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class HyperLinkBase extends ControlBase implements HyperLink{
    public HyperLinkBase(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void clickLink() {
        getWrappedElement().click();
    }

    @Override
    public String getUrlText() {
        return getWrappedElement().getText();
    }

    @Override
    public boolean checkUrlTextContaining(String containsText) {
        return getWrappedElement().getText().contains(containsText);
    }
}
