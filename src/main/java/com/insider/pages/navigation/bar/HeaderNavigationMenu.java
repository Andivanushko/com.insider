package com.insider.pages.navigation.bar;

import com.insider.pages.career.CareerPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderNavigationMenu {

    private static final String CAREER = "CAREER";

    @FindBy(css = "#header-outer .ubermenu")
    private WebElement headerMenu;


    public HeaderNavigationMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Select 'CAREER' from navigation menu")
    public CareerPage selectCareer() {
        headerMenu.findElement(By.partialLinkText(CAREER)).click();
        return new CareerPage();
    }
}