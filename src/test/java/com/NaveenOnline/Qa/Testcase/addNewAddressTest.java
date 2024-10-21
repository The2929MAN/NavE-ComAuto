package com.NaveenOnline.Qa.Testcase;

import com.NaveenOnline.Qa.base.Testbase;
import com.NaveenOnline.Qa.pages.HomePage;
import com.NaveenOnline.Qa.pages.addAddress;
import com.NaveenOnline.Qa.pages.homeLogin;
import com.NaveenOnline.Qa.utility.TestUtil;
import net.bytebuddy.build.Plugin;
import org.apache.log4j.Priority;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class addNewAddressTest extends Testbase {

    homeLogin  homelogin;
    HomePage homepage;
    addAddress addaddress;
    String sheetname = "Addresses";

    public addNewAddressTest(){
        super();
    }


   @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        homelogin = new homeLogin();
        homepage = new HomePage();
        homepage = homelogin.login(prop.getProperty("username"), prop.getProperty("password"));
        addaddress = new addAddress();
        homepage.clickOnAddressBook();
   }

    @DataProvider
    public Object[][] getTestData(){
        Object[][] data = TestUtil.getTestData(sheetname);
        return data;
    }


   @Test(priority = 1,dataProvider = "getTestData")
    public void addAddressTest(String FtName,String LtName, String Address_1, String city,String code, String cntry, String state) throws InterruptedException {
        addaddress.addNewAddress(FtName,LtName,Address_1,city,code,cntry,state);
        Thread.sleep(3000);
   }




   @AfterMethod
    public void teardown(){
        driver.quit();
   }
}
