package com.NaveenOnline.Qa.Testcase;

import com.NaveenOnline.Qa.base.Testbase;
import com.NaveenOnline.Qa.pages.homeLogin;
import com.NaveenOnline.Qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homePageTest extends Testbase {

    String title;
    homeLogin homelogin;
    HomePage homePage;

    public homePageTest(){
        super();
    }



    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        homelogin= new homeLogin();
        //homePage= new HomePage();
        homePage = homelogin.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.naveenLogo.click();


    }

    @Test
    public void HomePageTitleTest(){
       title = homePage.VerifyHomePageTitle();
        Assert.assertEquals(title,"Your Store", "Title Mismatch");
    }

    @Test
    public void clickOnMacInDesktopTabTest(){
        homePage.clickOnMacInDesktopTab();
        title= driver.getTitle();
        Assert.assertEquals(title,"Mac","Title Mismatch");

    }

    @Test
    public void clickOnShowAllInDesktopTabTest(){

        homePage.clickOnShowAllInDesktopTab();
        title= driver.getTitle();
        Assert.assertEquals(title,"Desktops","Title mismatch");
    }


    @Test
    public void clickOnMonitorsInComponentTabTest(){

        homePage.clickOnMonitorsInComponentTab();
        title= driver.getTitle();
        Assert.assertEquals(title,"Monitors","Title mismatch");
    }

    @Test
    public void clickOnTabletsTabTest(){
        homePage.clickOnTabletsTab();
        title= driver.getTitle();
        Assert.assertEquals(title,"Tablets","itle mismatch");
    }


    @Test
    public void clickOnSoftwareTabTest(){

        homePage.clickOnSoftwareTab();
        title = driver.getTitle();
        Assert.assertEquals(title,"Software","Title Mismatch");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

