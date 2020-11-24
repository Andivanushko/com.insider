package com.insider.pages.career;

import com.insider.pages.AbstractPage;
import com.insider.pages.career.subpage.CultureSubpage;
import com.insider.pages.career.subpage.JobsSubpage;
import com.insider.pages.career.subpage.LifeAtInsiderSubpage;
import com.insider.pages.career.subpage.LocationsSubpage;
import com.insider.pages.career.subpage.TeamsSubpage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareerPage extends AbstractPage {

    @FindBy(className = "career-back")
    private WebElement careerContent;
    @FindBy(css = "#career-nav .center")
    private WebElement careerNav;

    public CareerPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public boolean isPageLoaded() {
        return careerContent.isDisplayed();
    }

    @Step("Click JOBS in career navigation menu")
    public JobsSubpage clickJobs() {
        waitAndClick("JOBS");
        return new JobsSubpage();
    }

    @Step("Click CULTURE in career navigation menu")
    public CultureSubpage clickCulture() {
        waitAndClick("CULTURE");
        return new CultureSubpage();
    }

    @Step("Click LOCATIONS in career navigation menu")
    public LocationsSubpage clickLocations() {
        waitAndClick("LOCATIONS");
        return new LocationsSubpage();
    }

    @Step("Click TEAMS in career navigation menu")
    public TeamsSubpage clickTeams() {
        waitAndClick("TEAMS");
        return new TeamsSubpage();
    }

    @Step("Click LIFE AT INSIDER in career navigation menu")
    public LifeAtInsiderSubpage clickLifeAtInside() {
        waitAndClick("LIFE AT INSIDER");
        return new LifeAtInsiderSubpage();
    }

    @Step("Click on scroll to top button")
    public CareerPage navigateToTop() {
        // Navigation to TOP using JS because top-icon button is not fully visible if browser is NOT maximezed
        WebElement element = getDriver().findElement(By.className("top-icon"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);

        waitForJSInactivity();
        return this;
    }

    public void waitAndClick(String text) {
        // These waiters were added only to speed down webdriver
        waitFor(1000);
        WebElement element = careerNav.findElement(By.partialLinkText(text));
        getDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        waitFor(1000);
    }

}