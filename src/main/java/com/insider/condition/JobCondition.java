package com.insider.condition;

import com.insider.dto.JobDto;
import com.insider.page.career.fragment.JobsFragment;
import org.apache.commons.lang3.StringUtils;

public class JobCondition {

    private JobsFragment jobsSubpage;

    public JobCondition(JobsFragment jobsSubpage) {
        this.jobsSubpage = jobsSubpage;
    }

    public boolean verifyJobTitleContains(JobDto job) {
        return jobsSubpage.getJobsTitle().stream().allMatch(jobTitle -> StringUtils.containsIgnoreCase(jobTitle, job.getPosition()));
    }

    public boolean verifyJobDepartmentContains(JobDto job) {
        return jobsSubpage.getJobsDepartment().stream().allMatch(jobDepartment -> StringUtils.containsIgnoreCase(jobDepartment, job.getDepartment()));
    }

    public boolean verifyJobLocationContains(JobDto job) {
        return jobsSubpage.getJobsLocation().stream().allMatch(jobLocation -> StringUtils.containsIgnoreCase(jobLocation, job.getLocation()));
    }
}