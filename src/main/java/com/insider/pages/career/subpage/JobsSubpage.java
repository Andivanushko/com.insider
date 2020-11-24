package com.insider.pages.career.subpage;

import com.insider.pages.career.CareerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class JobsSubpage extends CareerPage {

    @FindBy(className = "jobs-list")
    private WebElement jobsList;

    public JobsSubpage filterLocation() {
        waitForJSInactivity();
        Select select = new Select(getDriver().findElement(By.className("jobs-locations")));
        select.selectByVisibleText("Istanbul, Turkey");
        return this;
    }

    public JobsSubpage filterJobTeams() {
        Select select = new Select(getDriver().findElement(By.className("jobs-teams")));
        select.selectByVisibleText("Quality Assurance");
        return this;
    }
}