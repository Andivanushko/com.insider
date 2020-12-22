package com.insider.config.driver;

import com.insider.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WebDriverProvider {

    private static final Logger LOG = LoggerFactory.getLogger(WebDriverProvider.class);

    public static final WebDriverProvider INSTANCE = new WebDriverProvider();
    private final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public WebDriver getDriverInstance() {
        if (DRIVER.get() == null) {
            DRIVER.set(WebDriverFactory.getDriver(Configuration.getBrowserType()));
            LOG.info("WebDriver " + Configuration.getBrowserType() + " was created");
        }
        return DRIVER.get();
    }
}