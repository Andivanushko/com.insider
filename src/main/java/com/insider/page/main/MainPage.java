package com.insider.page.main;

import com.insider.page.AbstractPage;
import com.insider.page.career.CareerPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import static com.insider.config.Configuration.getBaseUrl;
import static org.testng.Assert.fail;

public class MainPage extends AbstractPage {

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load() {
        getDriver().get(getBaseUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            getDriver().findElement(By.className("home"));
        } catch (NoSuchElementException exception) {
            fail("Cannot locate main content");
        }
    }

    @Step
    public MainPage open() {
        load();
        isLoaded();
        return this;
    }

    @Step
    public CareerPage selectCareer() {
        return getHeaderNavigationMenu().selectCareer();
    }
}