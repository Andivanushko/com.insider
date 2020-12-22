package com.insider.page;

import com.insider.config.driver.WebDriverHelper;
import com.insider.page.navigation.bar.HeaderNavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public abstract class AbstractPage extends LoadableComponent<AbstractPage> implements WebDriverHelper {

    public HeaderNavigationMenu getHeaderNavigationMenu() {
        return new HeaderNavigationMenu(getDriver());
    }

    public void selectDropdownByVisibleText(By locator, String value) {
        Select select = new Select(getDriver().findElement(locator));
        select.selectByVisibleText(value);
    }

    public void waitForJSInactivity() {
        getWebDriverWait().until(condition -> ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active == 0"));
    }
}