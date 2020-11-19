package com.insider.pages;

import com.insider.config.WebDriverProvider;
import com.insider.pages.navigation.bar.UberMenu;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver getDriver() {
        return WebDriverProvider.INSTANCE.getDriverInstance();
    }

    public UberMenu navigationMenu() {
        return new UberMenu(getDriver());
    }
}