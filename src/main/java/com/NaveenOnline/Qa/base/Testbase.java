package com.NaveenOnline.Qa.base;

import com.NaveenOnline.Qa.utility.WebEvenListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class Testbase {


    public static String browserName;
    public static WebDriver driver;
    public  static Properties prop;


    public Wait <WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));


    public Testbase(){

        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream
                    ("/Users/apple/AquaProjects/NaveenOnline_Automation/src/main/java/com/NaveenOnline/Qa/config/config.properties");
            prop.load(ip);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }




    public static <eventListner> void initialization(){
        browserName = prop.getProperty("browser");
        if(browserName.equals("chrome"))
            driver = new ChromeDriver();
        else if (browserName.equals("edge"))
            driver = new EdgeDriver();
        else if (browserName.equals("FF"))
            driver = new FirefoxDriver();
        else if(browserName.equals("Safari"))
            driver = new SafariDriver();
        else
            System.out.println("Enter correct browser name in properties file");







        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.get(prop.getProperty("url"));

    }



}
