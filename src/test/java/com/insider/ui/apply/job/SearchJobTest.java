package com.insider.ui.apply.job;

import com.insider.base.test.BaseTest;
import com.insider.condition.JobCondition;
import com.insider.dto.Job;
import com.insider.flow.CareerFlow;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@Feature("Search job")
@Story("Search Quality Assurance job")
public class SearchJobTest extends BaseTest {

    /* Test case:

     * 1. Open main page
     * 2. Click on Career link in header
     * 3. Click on Jobs in career navigation menu
     * 4. Filter by Istanbul, Turkey office
     * 5. Filter by Quality Assurance department

     * Expected result: verify job positions contains Quality Assurance,
     *                  verify department contains Quality Assurance,
     *                  verify location equals to Istanbul, Turkey.
     *  */

    @Test(description = "Search for Career opportunities")
    public void searchForCareerOpportunities() {
        Job job = Job.builder()
                .location("Istanbul, Turkey")
                .position("Quality Assurance")
                .department("Quality Assurance")
                .build();

        CareerFlow.searchJob(job);
        verifyJobDescription(job);
    }

    @Step("Verify job position, department and location")
    private void verifyJobDescription(Job job) {
        JobCondition jobCondition = CareerFlow.getJobCondition();

        assertSoftly(softAssertions -> {
            softAssertions.assertThat(jobCondition.verifyJobTitleContains(job))
                    .as("Job Title doesn't contain " + job.getPosition())
                    .isTrue();

            softAssertions.assertThat(jobCondition.verifyJobDepartmentContains(job))
                    .as("Job Department doesn't contain " + job.getDepartment())
                    .isTrue();

            softAssertions.assertThat(jobCondition.verifyJobLocationContains(job))
                    .as("Job location doesn't contain " + job.getLocation())
                    .isTrue();

            softAssertions.assertAll();
        });
    }
}