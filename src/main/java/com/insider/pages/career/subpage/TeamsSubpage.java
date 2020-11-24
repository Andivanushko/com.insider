package com.insider.pages.career.subpage;

import com.insider.pages.career.CareerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamsSubpage extends CareerPage {

    @FindBy(id = "teams")
    private WebElement teamsContent;

    @Override
    public boolean isPageLoaded() {
        waitForJSInactivity();
        return teamsContent.isDisplayed();
    }

}
