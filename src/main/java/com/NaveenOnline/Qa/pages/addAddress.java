package com.NaveenOnline.Qa.pages;

import com.NaveenOnline.Qa.base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addAddress extends Testbase {

//object Repositories

    @FindBy(xpath = "//a[text()='Address Book']")
    WebElement AddressBookLink;

    @FindBy(xpath = "//a[text()='New Address']")
    WebElement NewAddressBtn;

    @FindBy(xpath="//input[@name='firstname']")
    WebElement FrstName;

    @FindBy(xpath="//input[@name='lastname']")
    WebElement LstName;

    @FindBy(xpath="//input[@name='address_1']")
    WebElement Address;

    @FindBy(xpath="//input[@name='city']")
    WebElement City;


    @FindBy(xpath="//input[@name='postcode']")
    WebElement postcode;

    @FindBy(xpath="//select[@name='country_id']")
    WebElement country;

    @FindBy(xpath="//select[@name='zone_id']")
    WebElement state;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement CntnueBtn;



    public addAddress(){

        PageFactory.initElements(driver,this);
    }



    public String VerifyAddressBookTitle(){
        return driver.getTitle();
    }



    public void addNewAddress(String FName, String LName, String Address_1,String city, String code, String cntry, String stat ){

        NewAddressBtn.click();
        FrstName.sendKeys(FName);
        LstName.sendKeys(LName);
        Address.sendKeys(Address_1);
        City.sendKeys(city);
        postcode.sendKeys(code);
        Select select_country = new Select(country);
        select_country.selectByVisibleText(cntry);
        state.sendKeys(stat);
        CntnueBtn.click();



    }







}
