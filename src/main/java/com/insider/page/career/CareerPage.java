package com.insider.page.career;

import com.insider.page.AbstractPage;
import com.insider.page.career.fragment.JobsFragment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.fail;

public class CareerPage extends AbstractPage {

    @FindBy(className = "career-back")
    private WebElement careerContent;
    @FindBy(id = "career-nav")
    private WebElement careerNav;

    public CareerPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load() {
        getDriver().get("/career");
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            getDriver().findElement(By.id("career-nav"));
        } catch (NoSuchElementException exception) {
            fail("Cannot locate career page");
        }
    }

    @Step
    public JobsFragment selectJobs() {
        careerNav.findElement(By.partialLinkText("JOBS"));
        return new JobsFragment();
    }
}