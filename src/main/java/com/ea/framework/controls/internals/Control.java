package com.ea.framework.controls.internals;

import com.ea.framework.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Locatable;

@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsDriver, Locatable {
    ControlBase WaitForVisible();

    ControlBase Click();

    ControlBase ScrollToElement();
}
