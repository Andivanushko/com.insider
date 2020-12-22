package com.insider.flow;

import com.insider.condition.JobCondition;
import com.insider.dto.Job;
import com.insider.page.career.fragment.JobsFragment;
import com.insider.page.main.MainPage;
import io.qameta.allure.Step;

public class CareerFlow {

    @Step("Search for job {job}")
    public static void searchJob(Job job) {
        new MainPage().open()
                .selectCareer()
                .selectJobs()
                .filterLocation(job.getLocation())
                .filterDepartment(job.getDepartment())
                .filterDepartment(job.getDepartment());
    }

    public static JobCondition getJobCondition() {
        return new JobCondition(new JobsFragment());
    }
}
