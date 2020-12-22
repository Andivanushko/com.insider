package com.insider.config.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface WebDriverHelper {

    default WebDriver getDriver() {
        return WebDriverProvider.INSTANCE.getDriverInstance();
    }

    default WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getDriver(), 30);
    }

    default void cleanCookies() {
        getDriver().manage().deleteAllCookies();
    }

    default void setBrowserSize(int browserWith, int browserHeight) {
        getDriver().manage().window().setSize(new Dimension(browserWith, browserHeight));
    }

    default void quitDriver() {
        getDriver().quit();
    }
}