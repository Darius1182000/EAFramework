package com.ea.framework.controls.elements;

import com.ea.framework.controls.api.ImplementedBy;
import com.ea.framework.controls.internals.Control;
import com.ea.framework.controls.internals.ControlBase;

@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {

    void clickLink();
    String getUrlText();
    boolean checkUrlTextContaining(String containsText);
    ControlBase Wait();
    ControlBase WaitForVisible();
    ControlBase Click();
}
