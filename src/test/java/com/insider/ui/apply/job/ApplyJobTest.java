package com.insider.ui.apply.job;

import com.insider.ui.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Apply job")
@Story("Apply Quality Assurance job")
public class ApplyJobTest extends BaseTest {

    public static final String QUALITY_ASSURANCE = "Quality Assurance";
    public static final String ISTANBUL_TURKEY = "Istanbul, Turkey";

    @Test(description = "Search for Career opportunities")
    public void searchForCareerOpportunities() {
        // 1. Navigate to Career page
        // 2. Select Job menu item
        // 3. Filter by Office / Departments
        // 4. Assert positions / department / Location

    }
}