package com.insider.page.career.subpage;

import com.insider.page.career.CareerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamsSubpage extends CareerPage {

    @FindBy(id = "teams")
    private WebElement teamsContent;

}
