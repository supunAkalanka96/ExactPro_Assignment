package com.automation.pages;

import com.automation.base.TestBase;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j
public class LoginPage extends TestBase {

    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    WebElement userName;
    @FindBy(xpath = "//input[@type='password'and @name='pwd']")
    WebElement passWord;
    @FindBy(xpath = "//a[@id='loginButton']")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public HomePage loging(String uName, String pword)   {
        userName.sendKeys(uName);
        passWord.sendKeys(pword);
        loginButton.click();
        log.info("Login using Username : "+ uName + " and password :"+ pword);

        return new HomePage();
    }
    public void enterUserName(String uName) {
        userName.sendKeys(uName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void enterPassword(String pwd) {
        passWord.sendKeys(pwd);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
