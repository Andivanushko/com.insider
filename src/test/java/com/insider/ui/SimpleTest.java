package com.insider.ui;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class SimpleTest {

    @Test
    public void firstTest() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://useinsider.com/");
        driver.close();
    }

    @Test
    public void secondTest() {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://useinsider.com/");
        driver.close();
    }
}
