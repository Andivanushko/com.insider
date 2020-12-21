package com.insider.page.career.fragment;

import com.insider.page.career.CareerPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.fail;

public class JobsFragment extends CareerPage {

    private static final By JOB_LOCATIONS_DROPDOWN = By.className("jobs-locations");
    private static final By JOB_TEAMS_DROPDOWN = By.className("jobs-teams");

    @FindBy(css = ".jobs-list .job-title")
    private List<WebElement> jobTitle;
    @FindBy(css = ".jobs-list span:nth-child(2)")
    private List<WebElement> jobDepartment;
    @FindBy(css = ".jobs-list span:last-child")
    private List<WebElement> jobLocation;

    @Override
    protected void load() {
        getDriver().get("/#jobs");
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            getDriver().findElement(By.id("jobs-container"));
        } catch (NoSuchElementException exception) {
            fail("Cannot locate jobs subpage");
        }
    }

    @Step("Select {location} location")
    public JobsFragment filterLocation(String location) {
        waitForJSInactivity();
        selectDropdownByVisibleText(JOB_LOCATIONS_DROPDOWN, location);
        return this;
    }

    @Step("Select {jobTeams} job teams")
    public JobsFragment filterDepartment(String jobTeams) {
        waitForJSInactivity();
        selectDropdownByVisibleText(JOB_TEAMS_DROPDOWN, jobTeams);
        return this;
    }

    public List<String> getJobsTitle() {
        return jobTitle.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getJobsDepartment() {
        return jobDepartment.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getJobsLocation() {
        return jobLocation.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}