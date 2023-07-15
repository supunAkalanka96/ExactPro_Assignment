package com.automation.utils;

import com.automation.base.TestBase;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
@Log4j
public class TestUtils extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 40;

    public void switchToFrame(String framaName) {
        driver.switchTo().frame(framaName);
    }

    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\testdata\\testData.xlsx";
    static Workbook book;
    static Sheet sheet;
    static JavascriptExecutor js;

    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert file != null;
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException | IOException e) {
            System.out.println(e.toString());
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue().trim();

            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}

