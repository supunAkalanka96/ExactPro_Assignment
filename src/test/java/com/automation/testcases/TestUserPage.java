package com.automation.testcases;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.UserPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUserPage extends TestBase {

    HomePage homePage;
    UserPage userPage;
    LoginPage loginPage;
    public TestUserPage() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializationProcess();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        userPage = homePage.clickOnUserLink();
    }

    @Test(priority = 1)
    public void userPageLogoTest() {
        userPage =  userPage.clickOnUser();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
