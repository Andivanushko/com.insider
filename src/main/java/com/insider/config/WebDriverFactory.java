package com.insider.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class WebDriverFactory {

    public static WebDriver getDriver(final String browserType) {
        return createLocalDriver(browserType);
    }

    private static WebDriver createLocalDriver(final String browserType) {
        if (browserType.equals(FIREFOX)) {
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, Constants.FIREFOX_DRIVER_WINDOWS_PATH);
            return new FirefoxDriver();
        }
        if (browserType.equals(CHROME)) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, Constants.CHROME_DRIVER_WINDOWS_PATH);
            return new ChromeDriver();
        }
        throw new Error("Unrecognized browser type: " + browserType);
    }

}