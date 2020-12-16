package com.insider.page.main;

import com.insider.page.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.insider.config.Configuration.getBaseUrl;

public class MainPage extends AbstractPage {

    @FindBy(className = "home")
    private WebElement homeContent;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    @Step("Open main page for Insider")
    public MainPage open() {
        getDriver().get(getBaseUrl());
        return this;
    }

    public boolean isPageLoaded() {
        return homeContent.isDisplayed();
    }
}