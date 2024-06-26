package com.ea.framework.controls.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.lang.reflect.InvocationTargetException;

public class ControlFactory extends PageFactory {

    public static<T> T initElements(WebDriver driver, Class<T> pageClassToProxy){
        try {
            T page = pageClassToProxy.getDeclaredConstructor().newInstance();
            PageFactory.initElements(new ControlFieldDecorator(new DefaultElementLocatorFactory(driver)),page);
            return pageClassToProxy.cast(page);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
