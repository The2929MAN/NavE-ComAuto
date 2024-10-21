package com.NaveenOnline.Qa.pages;

import com.NaveenOnline.Qa.base.Testbase;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Testbase {


    //object Repositories
    @FindBy(xpath = "//li//a[contains(text(),'PC')]")
    WebElement Desktop_pc;


    @FindBy(xpath = "//a[text()='Desktops']//parent::li//*[contains(text(),'Mac')]")
    WebElement Desktop_mac;

    @FindBy(xpath = "//a[text()='Show All Desktops']")
    WebElement Desktop_showallDesk;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    WebElement components_Monitors;

    @FindBy(xpath = "//a[text()='Tablets']")
    WebElement tabletsTab;

    @FindBy(xpath = "//a[text()='Software']")
    WebElement softwareTab;

    @FindBy(xpath = "//a[text()='Address Book']")
    WebElement AddressBookLink;

    @FindBy(xpath = "//img[@title='naveenopencart']")
    public WebElement naveenLogo;



    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    public  String VerifyHomePageTitle(){
        return driver.getTitle();
    }


    public void clickOnMacInDesktopTab(){
    driver.findElement(By.xpath("//a[text()='Desktops']")).click();
    Desktop_mac.click();

    }

    public void clickOnShowAllInDesktopTab(){
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        Desktop_showallDesk.click();

    }

    public void clickOnMonitorsInComponentTab(){
      driver.findElement(By.xpath("//a[text()='Components']")).click();
        components_Monitors.click();
    }


    public TabletsTab clickOnTabletsTab(){
        tabletsTab.click();
        return new TabletsTab();

    }

    public SoftwareTab clickOnSoftwareTab(){
        softwareTab.click();
        return new SoftwareTab();
    }


    public addAddress clickOnAddressBook(){
        AddressBookLink.click();
        return new addAddress();
    }

}
