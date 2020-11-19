package com.insider.ui;

import com.insider.config.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.insider.config.Configuration.getBrowserHeight;
import static com.insider.config.Configuration.getBrowserWidth;

public class BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void cleanCookies() {
        WebDriverProvider.INSTANCE.getDriverInstance().manage().deleteAllCookies();
        WebDriverProvider.INSTANCE.getDriverInstance().manage().window().setSize(new Dimension(getBrowserWidth(), getBrowserHeight()));
        LOG.info("Screen size" + WebDriverProvider.INSTANCE.getDriverInstance().manage().window().getSize());
    }

    @After
    public void afterClassSetup() {
        WebDriverProvider.INSTANCE.removeDriver();
        LOG.info("WebDriver was successfully closed");
    }
}