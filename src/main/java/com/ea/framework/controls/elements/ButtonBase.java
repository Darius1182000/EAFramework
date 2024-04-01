package com.ea.framework.controls.elements;

import com.ea.framework.base.DriverContext;
import com.ea.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class ButtonBase extends ControlBase implements Button {
    public ButtonBase(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void performClick() {
        getWrappedElement().click();
    }

    @Override
    public String getButtonText() {
        return getWrappedElement().getText();
    }

    @Override
    public void performSubmit() {
        getWrappedElement().submit();
    }

}
