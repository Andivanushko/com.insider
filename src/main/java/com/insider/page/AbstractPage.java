package com.insider.page;

import com.insider.config.DriverInstanceProvider;
import com.insider.page.navigation.bar.HeaderNavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage extends LoadableComponent<AbstractPage> implements DriverInstanceProvider {

    public HeaderNavigationMenu getHeaderNavigationMenu() {
        return new HeaderNavigationMenu(getDriver());
    }

    public void selectDropdownByVisibleText(By locator, String value) {
        Select select = new Select(getDriver().findElement(locator));
        select.selectByVisibleText(value);
    }

    public void waitForJSInactivity() {
        final Wait<WebDriver> webDriverWait = new WebDriverWait(getDriver(), 30);
        webDriverWait.until(condition -> ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active == 0"));
    }
}