package com.thetestingacademy.web.testbase;

import com.thetestingacademy.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;

public class TestBase {
    // Call to driver, take screenshot, Action, Switch to Alert, JavaScriptExecutor, window handles etc.

    @BeforeSuite
    protected void init(){
        DriverManagerTL.init();
    }

    @AfterSuite
    protected void tearDown(){
        DriverManagerTL.tearDown();
    }

    protected void takeScreenshot(String name){
        Allure.addAttachment(name,new ByteArrayInputStream(((TakesScreenshot)DriverManagerTL.getDriver())
                .getScreenshotAs(OutputType.BYTES)));
    }
}
