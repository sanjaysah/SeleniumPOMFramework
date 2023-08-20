package com.thetestingacademy.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManagerTL {
    // Thread Local - Java
    // 5 parallel - They all will have their own separate sandbox - static driver object is thread safe.
    static WebDriver driver;
    public static final ThreadLocal<WebDriver> tldr = new ThreadLocal<>();

    public static WebDriver getDriver() {

        return tldr.get();
    }

    public static void setDriver(WebDriver driver) {

        tldr.set(driver);
    }

    public static void unload(){

        tldr.remove();
    }

    @BeforeMethod
    public static void init(){
        if(getDriver()==null) {
            // TODO #1 - Need to make it support for other browsers too.
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            setDriver(new ChromeDriver(options));
        }
    }

    @AfterMethod
    public static void tearDown(){
        if(getDriver()!=null){
            getDriver().quit();
        }
    }
}
