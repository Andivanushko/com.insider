package com.insider.ui.apply.job;

import com.insider.pages.main.MainPage;
import com.insider.ui.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class ApplyJobTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void init() {
        mainPage = new MainPage();
    }

    @Test
    @DisplayName("Apply for this job test ")
    public void applyJobTestTest() {
        mainPage.open()
                .navigationMenu().selectCareer();
    }
}