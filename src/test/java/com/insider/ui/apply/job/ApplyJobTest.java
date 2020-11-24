package com.insider.ui.apply.job;

import com.insider.pages.apply.job.ApplyJobPage;
import com.insider.pages.apply.job.SubmitApplicationPage;
import com.insider.pages.career.CareerPage;
import com.insider.pages.career.subpage.CultureSubpage;
import com.insider.pages.career.subpage.JobsSubpage;
import com.insider.pages.career.subpage.LifeAtInsiderSubpage;
import com.insider.pages.career.subpage.LocationsSubpage;
import com.insider.pages.career.subpage.TeamsSubpage;
import com.insider.pages.main.MainPage;
import com.insider.ui.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ApplyJobTest extends BaseTest {

    public static final String QUALITY_ASSURANCE = "Quality Assurance";
    public static final String ISTANBUL_TURKEY = "Istanbul, Turkey";

    private MainPage mainPage;
    private CareerPage careerPage;

    @BeforeClass
    public void init() {
        mainPage = new MainPage();
    }

    @Test(description = "Apply for this job test")
    public void applyJobTestTest() {
        mainPage.open();
        assertTrue(mainPage.isPageLoaded(), "Main page wasn't opened");

        careerPage = mainPage.getHeaderNavigationMenu()
                .selectCareer();

        CultureSubpage cultureSubpage = careerPage.clickCulture();
        assertTrue(cultureSubpage.isPageLoaded(), "Culture sub page wasn't opened");

        LocationsSubpage locationsSubpage = careerPage.navigateToTop().clickLocations();
        assertTrue(locationsSubpage.isPageLoaded(), "Locations sub page wasn't opened");

        TeamsSubpage teamsSubpage = careerPage.navigateToTop().clickTeams();
        assertTrue(teamsSubpage.isPageLoaded(), "Teams sub page wasn't opened");

        LifeAtInsiderSubpage lifeAtInsiderSubpage = careerPage.navigateToTop().clickLifeAtInside();
        assertTrue(lifeAtInsiderSubpage.isPageLoaded(), "Life at Insider sub page wasn't opened");

        JobsSubpage jobsSubpage = careerPage.navigateToTop().clickJobs();
        assertTrue(jobsSubpage.isPageLoaded(), "Jobs sub page wasn't opened");

        jobsSubpage
                .selectLocation(ISTANBUL_TURKEY)
                .selectJobTeams(QUALITY_ASSURANCE);
        assertTrue(jobsSubpage.areAllJobsTitleContains(QUALITY_ASSURANCE), "Not all jobs title contains " + QUALITY_ASSURANCE);
        assertTrue(jobsSubpage.areAllDepartmentsContains(QUALITY_ASSURANCE), "Not all departments are equals to " + QUALITY_ASSURANCE);
        assertTrue(jobsSubpage.areAllJobsLocationsContains(ISTANBUL_TURKEY), "Not all jobs location are equals to " + ISTANBUL_TURKEY);

        ApplyJobPage applyJobPage = jobsSubpage.openFirstJob();
        assertTrue(applyJobPage.isPageLoaded(), "Jobs description page wasn't opened");
        assertTrue(applyJobPage.getJobTitle().contains(QUALITY_ASSURANCE), "Job title is NOT contains expected " + QUALITY_ASSURANCE);
        assertTrue(applyJobPage.isApplyForThisPositionButtonDisplayed(), "Apply for this job button is NOT displayed ");

        SubmitApplicationPage submitApplicationPage = applyJobPage.clickApplyButton();
        assertTrue(submitApplicationPage.isPageLoaded(), "Submit application page wasn't opened");
    }
}