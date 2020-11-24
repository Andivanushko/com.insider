package com.insider.pages.career;

import com.insider.pages.AbstractPage;
import com.insider.pages.career.subpage.JobsSubpage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerPage extends AbstractPage {

    @FindBy(className = "career-back")
    private WebElement career;
    @FindBy(css = "#career-nav .center")
    private WebElement careerNav;

    public CareerPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("Click JOBS in career navigation menu")
    public JobsSubpage selectJobs() {
        careerNav.findElement(By.partialLinkText("JOBS")).click();
        return new JobsSubpage();
    }
}