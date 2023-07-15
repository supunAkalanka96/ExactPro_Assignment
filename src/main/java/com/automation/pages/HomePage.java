package com.automation.pages;

import com.automation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    //Page Factory - Object Repository
    @FindBy(xpath = "//a[@class='content tasks']")
    WebElement taskLink;
    @FindBy(xpath = "//a[@class='content reports']")
    WebElement reportsLink;
    @FindBy(xpath = "//a[@class='content users']")
    WebElement userLink;
    @FindBy(xpath = "//div[@class='logoSwitcherText']")
    WebElement scheduleLink;


    //initialization
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public TasksPage clickOnTaskLink() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        taskLink.click();
        return new TasksPage();
    }

    public UserPage clickOnUserLink() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        userLink.click();
        return new UserPage();
    }
    public SchedulePage clickOnScheduleLink() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        scheduleLink.click();
        return new SchedulePage();
    }


}
