package com.insider.ui.apply.job;

import com.insider.pages.main.MainPage;
import com.insider.ui.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApplyJobTest extends BaseTest {

    private MainPage mainPage;

    @BeforeClass
    public void init() {
        mainPage = new MainPage();
    }

    @Test(description = "Apply for this job test")
    public void applyJobTestTest() {
        mainPage.open()
                .navigationMenu().selectCareer();
    }
}