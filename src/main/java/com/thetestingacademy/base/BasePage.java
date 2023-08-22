package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected BasePage(){

    }
    // Protected - restricting use within same package
    protected void implicitWait(){
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    protected void enterInput(By by, String key){
        DriverManagerTL.getDriver().findElement(by).sendKeys(key);
    }

    // Overloading
    protected void enterInput(WebElement e, String key){
        e.sendKeys(key);
    }

    protected void clickElement(By by){
        DriverManagerTL.getDriver().findElement(by).click();
    }

    protected WebElement getElement(By by){
        return DriverManagerTL.getDriver().findElement(by);
    }

    protected void selectDropdownByText(By by, String text){
        Select select = new Select(DriverManagerTL.getDriver().findElement(by));
        select.selectByVisibleText(text);
    }

    protected WebElement presenceOfElement(final By by){
        return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement visibilityOfElement(final By by){
        return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement elementToBeClickable(final By by){
        return new WebDriverWait(DriverManagerTL.getDriver(),Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
