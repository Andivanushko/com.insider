package com.insider.page.career.subpage;

import com.insider.page.career.CareerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LifeAtInsiderSubpage extends CareerPage {

    @FindBy(id = "locations")
    private WebElement locationsContent;

}
