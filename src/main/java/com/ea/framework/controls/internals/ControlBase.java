package com.ea.framework.controls.internals;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;

import java.util.List;

public class ControlBase implements Control{

    private final WebElement webElement;

    public ControlBase(WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getDomProperty(String name) {
        return Control.super.getDomProperty(name);
    }

    @Override
    public String getDomAttribute(String name) {
        return Control.super.getDomAttribute(name);
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public String getAriaRole() {
        return Control.super.getAriaRole();
    }

    @Override
    public String getAccessibleName() {
        return Control.super.getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public SearchContext getShadowRoot() {
        return Control.super.getShadowRoot();
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return null;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }

    public WebElement getWrappedElement() {
        // This method is not strictly necessary if the class doesn't use wrapped elements
        // and directly interacts with the webElement.
        // However, it can be added for potential future extensions or compatibility.
        return webElement;
    }
}
