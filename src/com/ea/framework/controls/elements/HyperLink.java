package com.ea.framework.controls.elements;

import com.ea.framework.controls.api.ImplementedBy;
import com.ea.framework.controls.internals.Control;

@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {

    void clickLink();
    String getUrlText();
    boolean checkUrlTextContaining(String containsText);
}
