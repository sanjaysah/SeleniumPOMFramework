package com.thetestingacademy.pages;

import com.thetestingacademy.base.BasePage;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.utils.PropReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends BasePage {

    public Loginpage(){
        super();
    }

    // Page Locators
    @FindBy(id="login-username")
    private WebElement username;
    //private By username = By.id("login-username");

    private By password =  By.id("login-password");
    private By signButton = By.id("js-login-btn");

    private By sign_uplink   = By.partialLinkText("Start a free trial");

    private By error_message = By.id("js-notification-box-msg");

    // Page Actions
    public Loginpage loginToVWO(boolean value) throws Exception {
        PageFactory.initElements(DriverManagerTL.getDriver(),this);
        if(!value){
            enterInput(username, PropReader.readKey("invalid_username"));
            enterInput(password, PropReader.readKey("invalid_password"));
            //visibilityOfElement(error_message);
        }
        else{
            enterInput(username, PropReader.readKey("username"));
            enterInput(password, PropReader.readKey("password"));
        }

        clickElement(signButton);
        return this;
    }

    // Invalid Login
    public String error_message_text() throws InterruptedException {
        visibilityOfElement(error_message);
        return DriverManagerTL.getDriver().findElement(error_message).getText();

    }

    public DashboardPage afterLogin(){
        return new DashboardPage();
    }
}
