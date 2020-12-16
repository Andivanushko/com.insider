package com.insider.page.career;

import com.insider.page.AbstractPage;
import com.insider.page.career.subpage.CultureSubpage;
import com.insider.page.career.subpage.JobsSubpage;
import com.insider.page.career.subpage.LifeAtInsiderSubpage;
import com.insider.page.career.subpage.LocationsSubpage;
import com.insider.page.career.subpage.TeamsSubpage;
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
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

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
        WebElement element = careerNav.findElement(By.partialLinkText(text));
        getDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}