package com.automation.testcases;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.TestUtils;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Log4j
public class TestLoginPage extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    String sheetName = "Users";
    TestUtils testUtil;

    public TestLoginPage() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializationProcess();
        loginPage = new LoginPage();
    }

    @DataProvider
    public Object[][] getactiTimeTestData() {
        return TestUtils.getTestData(sheetName);
    }

    @Test(priority = 1, dataProvider="getactiTimeTestData")
    public void LoginTest(String userName, String password) {
        log.info("Load the login page after login");
        try{
            homePage = loginPage.loging(userName, password);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
