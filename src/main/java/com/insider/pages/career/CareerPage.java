package com.insider.pages.career;

import com.insider.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerPage extends BasePage {

    @FindBy(className = "career-back")
    private WebElement career;

    public CareerPage() {
        PageFactory.initElements(getDriver(), this);
    }
}