package com.insider.ui;

import com.insider.config.listener.TestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static com.insider.config.Configuration.getBrowserHeight;
import static com.insider.config.Configuration.getBrowserWidth;

@Listeners(TestListener.class)
public abstract class BaseTest implements TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest(description = "Clear cookies and set browser size")
    public void beforeTestSetup() {
        cleanCookies();
        setBrowserSize(getBrowserWidth(), getBrowserHeight());
        LOG.info("Screen size" + getDriver().manage().window().getSize());
    }

    @AfterTest(description = "Remove driver instance")
    public void afterTestSetup() {
        quitDriver();
        LOG.info("WebDriver was successfully closed");
    }
}