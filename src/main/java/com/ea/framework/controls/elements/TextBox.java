package com.ea.framework.controls.elements;

import com.ea.framework.controls.api.ImplementedBy;
import com.ea.framework.controls.internals.Control;
import com.ea.framework.controls.internals.ControlBase;

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void enterText(String text);
    String getTextValue();
}
