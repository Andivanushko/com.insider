package com.insider.pages.apply.job;

import com.insider.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitApplicationPage extends AbstractPage {

    @FindBy(css = ".content form")
    private WebElement formData;

    public SubmitApplicationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public boolean isPageLoaded() {
        return formData.isDisplayed();
    }
}
