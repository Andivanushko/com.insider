package com.insider.pages.career.subpage;

import com.insider.pages.career.CareerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationsSubpage extends CareerPage {

    @FindBy(id = "locations")
    private WebElement locationsContent;

    public boolean isPageLoaded() {
        waitForJSInactivity();
        return locationsContent.isDisplayed();
    }
}
