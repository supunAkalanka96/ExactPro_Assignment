package com.automation.pages;

import com.automation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends TestBase {
    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;
    @FindBy(xpath = "//a[@class='content corporate_schedule']")
    WebElement leaveManagementLink;
    public SchedulePage() {
        PageFactory.initElements(driver, this);
    }
    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();
    }
    public LeaveManagementPage clickOnLeaveManagementLink() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        leaveManagementLink.click();
        return new LeaveManagementPage();
    }
}
