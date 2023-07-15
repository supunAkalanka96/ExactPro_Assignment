package com.automation.base;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Log4j
public class TestBase {
    public static WebDriver driver;
    public static Properties properties;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream iprop = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/"
                    + "automation/configs/config.properties");
            properties.load(iprop);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void initializationProcess() {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        log.info("Initialized the Chrome Driver");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }
}
