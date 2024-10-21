package com.NaveenOnline.Qa.pages;

import com.NaveenOnline.Qa.base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homeLogin  extends Testbase {

    //PageFactory - OR:

    @FindBy(xpath = "//*[@title='My Account']")
    WebElement MyAccountTab;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement ToLoginpage;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailFeild;

    @FindBy(name = "password")
    WebElement pwdFeild;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//img[@title='naveenopencart']")
    public WebElement naveenLogo;

    @FindBy(xpath = "//a[text()='Logout' and @class]")
    WebElement Logouttab;

//    WebDriver driver;


    //initializing the page objects


    public homeLogin(){
        PageFactory.initElements(driver,this);
    }


    //Actions

    public String validateLoginPageTitle(){
        System.out.println("Title = > " + driver.getTitle());
       return driver.getTitle();
    }

    public boolean validateLogo(){
        System.out.println("Logo displayed = > " + naveenLogo.isDisplayed());
        return naveenLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd) throws InterruptedException {
            MyAccountTab.click();
            ToLoginpage.click();
            emailFeild.sendKeys(un);
            pwdFeild.sendKeys(pwd);
            loginBtn.click();
            boolean validateLogin = Logouttab.isDisplayed();
            System.out.println("logged in successfully = >" + validateLogin);
            Thread.sleep(3000);
            return new HomePage();

    }










}
