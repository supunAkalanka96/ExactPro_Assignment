package com.automation.testcases;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SchedulePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SchedulePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    SchedulePage schedulePage;
    public SchedulePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializationProcess();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        schedulePage = homePage.clickOnScheduleLink();
    }
    @Test(priority = 1)
    public void userPageLogoTest() {
        schedulePage.validateActiTimeLogo();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
