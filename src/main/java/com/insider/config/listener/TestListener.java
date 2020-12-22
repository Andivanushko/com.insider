package com.insider.config.listener;

import com.insider.config.driver.WebDriverProvider;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr){
        TakesScreenshot driver = ((TakesScreenshot) WebDriverProvider.INSTANCE.getDriverInstance());
        byte[] srcFile = driver.getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }
}