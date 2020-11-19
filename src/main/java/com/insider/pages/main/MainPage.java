package com.insider.pages.main;

import com.insider.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.insider.config.Configuration.getBaseUrl;

public class MainPage extends BasePage {

    @FindBy(className = "home")
    private WebElement home;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage open() {
        getDriver().get(getBaseUrl());
        return this;
    }

    public MainPage assertPageLoad() {
        home.isDisplayed();
        return this;
    }
}