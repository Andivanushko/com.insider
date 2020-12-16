package com.insider.pages;

import com.insider.config.WebDriverProvider;
import com.insider.pages.navigation.bar.HeaderNavigationMenu;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage extends LoadableComponent {

    private static final long TIME_SECONDS_LIMIT = 30;

    public WebDriver getDriver() {
        return WebDriverProvider.INSTANCE.getDriverInstance();
    }

    public WebDriverWait getDriverWait() {
        return new WebDriverWait(getDriver(), 30);
    }

    public HeaderNavigationMenu getHeaderNavigationMenu() {
        return new HeaderNavigationMenu(getDriver());
    }

    public void waitForJSInactivity() {
        final Wait<WebDriver> webDriverWait = new WebDriverWait(getDriver(), TIME_SECONDS_LIMIT);
        webDriverWait.until(condition -> ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active == 0"));
    }
}