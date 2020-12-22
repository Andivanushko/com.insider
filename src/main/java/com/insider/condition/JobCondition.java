package com.insider.condition;

import com.insider.dto.Job;
import com.insider.page.career.fragment.JobsFragment;
import org.apache.commons.lang3.StringUtils;

public class JobCondition {

    private JobsFragment jobsSubpage;

    public JobCondition(JobsFragment jobsSubpage) {
        this.jobsSubpage = jobsSubpage;
    }

    public boolean verifyJobTitleContains(Job job) {
        return jobsSubpage.getJobsTitle().stream().allMatch(jobTitle -> StringUtils.containsIgnoreCase(jobTitle, job.getPosition()));
    }

    public boolean verifyJobDepartmentContains(Job job) {
        return jobsSubpage.getJobsDepartment().stream().allMatch(jobDepartment -> StringUtils.containsIgnoreCase(jobDepartment, job.getDepartment()));
    }

    public boolean verifyJobLocationContains(Job job) {
        return jobsSubpage.getJobsLocation().stream().allMatch(jobLocation -> StringUtils.containsIgnoreCase(jobLocation, job.getLocation()));
    }
}