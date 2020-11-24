package com.insider.pages.career.subpage;

import com.insider.pages.career.CareerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LifeAtInsiderSubpage extends CareerPage {

    @FindBy(id = "locations")
    private WebElement locationsContent;

    @Override
    public boolean isPageLoaded() {
        waitForJSInactivity();
        return locationsContent.isDisplayed();
    }
}
