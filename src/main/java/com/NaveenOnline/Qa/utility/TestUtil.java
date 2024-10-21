package com.NaveenOnline.Qa.utility;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.NaveenOnline.Qa.base.Testbase.driver;

public class TestUtil {
    static String  TEST_DATA_FILE_PATH = "src/main/java/com/NaveenOnline/Qa/TestData/Testdata.xlsx";
    static XSSFSheet sheet;
    static XSSFWorkbook book;
    static FileInputStream file;





    public static Object[][] getTestData(String sheetName){

        try{
            file = new FileInputStream(TEST_DATA_FILE_PATH);
            book = new XSSFWorkbook(file);
            sheet = book.getSheet(sheetName);
            file.close();
        }
        catch(Exception e){
             e.printStackTrace();
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i = 0; i<sheet.getLastRowNum();i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }


    public static void takeScreenshotAtEndOfTest() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
