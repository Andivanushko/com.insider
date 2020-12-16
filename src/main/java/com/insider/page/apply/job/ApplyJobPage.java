package com.insider.page.apply.job;

import com.insider.page.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyJobPage extends AbstractPage {

    @FindBy(className = "header-comfortable")
    private WebElement applyJobContent;
    @FindBy(css = ".posting-headline h2")
    private WebElement jobTitle;
    @FindBy(css = ".postings-btn-wrapper .template-btn-submit")
    private WebElement applyButton;

    public ApplyJobPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public String getJobTitle() {
        return jobTitle.getText();
    }

    public boolean isApplyForThisPositionButtonDisplayed() {
        return applyButton.isDisplayed();
    }

    @Step
    public SubmitApplicationPage clickApplyButton() {
        applyButton.click();
        return new SubmitApplicationPage();
    }
}