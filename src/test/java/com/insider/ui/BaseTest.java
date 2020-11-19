package com.insider.ui;

import com.insider.config.TestListener;
import com.insider.config.WebDriverProvider;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static com.insider.config.Configuration.getBrowserHeight;
import static com.insider.config.Configuration.getBrowserWidth;

@Listeners(TestListener.class)
public class BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest(description = "Clear cookies and set browser size")
    public void cleanCookies() {
        WebDriverProvider.INSTANCE.getDriverInstance().manage().deleteAllCookies();
        WebDriverProvider.INSTANCE.getDriverInstance().manage().window().setSize(new Dimension(getBrowserWidth(), getBrowserHeight()));
        LOG.info("Screen size" + WebDriverProvider.INSTANCE.getDriverInstance().manage().window().getSize());
    }

    @AfterTest(description = "Remove driver instance")
    public void afterClassSetup() {
        WebDriverProvider.INSTANCE.removeDriver();
        LOG.info("WebDriver was successfully closed");
    }
}