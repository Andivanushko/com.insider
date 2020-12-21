package com.insider.config;

import org.openqa.selenium.WebDriver;

public interface DriverInstanceProvider {

    default WebDriver getDriver() {
        return WebDriverProvider.INSTANCE.getDriverInstance();
    }
}