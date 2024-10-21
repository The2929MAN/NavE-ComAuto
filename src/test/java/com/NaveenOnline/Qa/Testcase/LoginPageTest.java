package com.NaveenOnline.Qa.Testcase;

import com.NaveenOnline.Qa.base.Testbase;
import com.NaveenOnline.Qa.pages.homeLogin;
import com.NaveenOnline.Qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Testbase {

    public LoginPageTest(){
        super();
    }

    homeLogin homelogin;
    HomePage homepage;


    @BeforeMethod
    public void setup(){
        initialization();
        homelogin = new homeLogin();


    }

    @Test(priority = 2)
    public void loginPageTitleTest(){
        String title = homelogin.validateLoginPageTitle();
        Assert.assertEquals("Your Store", title);
    }

    @Test(priority = 3)
    public void naveenLogo(){
        boolean flag = homelogin.validateLogo();
    }

    @Test(priority = 1)
    public void logintest() throws InterruptedException {

       homepage = homelogin.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test
    public void AddressBook(){

    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
