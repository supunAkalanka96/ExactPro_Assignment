package com.automation.testcases;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public TestHomePage() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializationProcess();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void homePageTaskLinkTest() {
        homePage.clickOnTaskLink();
    }
    @Test(priority = 2)
    public void homePageUserLinkTest() {
        homePage.clickOnUserLink();
    }

    @Test(priority = 3)
    public void homePageScheduleLinkTest() {
        homePage.clickOnScheduleLink();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
