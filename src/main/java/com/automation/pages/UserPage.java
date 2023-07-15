package com.automation.pages;

import com.automation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends TestBase {
    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;
    @FindBy(xpath = "//div[@class='userNameContent']")
    WebElement userLink;
    public UserPage() {
        PageFactory.initElements(driver, this);
    }
    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();
    }


    public UserPage clickOnUser() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        userLink.click();
        return new UserPage();
    }
}
