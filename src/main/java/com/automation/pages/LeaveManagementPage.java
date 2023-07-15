package com.automation.pages;

import com.automation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveManagementPage extends TestBase {

    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;
    public LeaveManagementPage() {
        PageFactory.initElements(driver, this);
    }
    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();
    }

}
