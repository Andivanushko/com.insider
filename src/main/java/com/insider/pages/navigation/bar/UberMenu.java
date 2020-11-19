package com.insider.pages.navigation.bar;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UberMenu {

    private static final String CAREER = "CAREER";

    @FindBy(css = "#header-outer .ubermenu")
    WebElement headerMenu;

    public UberMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Select 'CAREER' from navigation menu")
    public void selectCareer() {
        if(headerMenu.findElement(By.partialLinkText(CAREER)).isDisplayed()) {
            headerMenu.findElement(By.partialLinkText(CAREER)).click();
        }
    }
}