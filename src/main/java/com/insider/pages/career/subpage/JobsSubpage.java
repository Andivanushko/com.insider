package com.insider.pages.career.subpage;

import com.insider.pages.apply.job.ApplyJobPage;
import com.insider.pages.career.CareerPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class JobsSubpage extends CareerPage {

    private static final By jobLocationsDropdown = By.className("jobs-locations");
    private static final By jobTeamsDropdown = By.className("jobs-teams");

    @FindBy(className = "jobs-list")
    private WebElement jobsList;

    @Override
    public boolean isPageLoaded() {
        return jobsList.isDisplayed();
    }

    @Step("Select {location} location")
    public JobsSubpage selectLocation(String location) {
        waitForJSInactivity();
        selectDropdownValue(jobLocationsDropdown, location);
        return this;
    }

    @Step("Select {jobTeams} job teams")
    public JobsSubpage selectJobTeams(String jobTeams) {
        waitForJSInactivity();
        selectDropdownValue(jobTeamsDropdown, jobTeams);
        return this;
    }

    @Step
    public ApplyJobPage openFirstJob() {
        getAllJobs().stream().findFirst().orElseThrow(() -> new RuntimeException("Could not find any job")).click();
        return new ApplyJobPage();
    }

    public boolean areAllJobsTitleContains(String jobTitle) {
        return getAllJobs().stream().allMatch(ele -> ele.findElement(By.className("job-title")).getText().contains(jobTitle));
    }

    public boolean areAllDepartmentsContains(String department) {
        return getAllJobs().stream().allMatch(ele -> ele.findElement(By.cssSelector("span:nth-child(2)")).getText().contains(department));
    }

    public boolean areAllJobsLocationsContains(String location) {
        return getAllJobs().stream().allMatch(ele -> ele.findElement(By.cssSelector("span:last-child")).getText().contains(location));
    }

    private List<WebElement> getAllJobs() {
        waitForJSInactivity();
        return new ArrayList<>(jobsList.findElements(By.className("job")));
    }

    private void selectDropdownValue(By locator, String value) {
        Select select = new Select(getDriver().findElement(locator));
        select.selectByVisibleText(value);
    }

}