package com.thetestingacademy.pages;

import com.thetestingacademy.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    public DashboardPage(){}

    // Page Locators
    By userNameOnDashboard = By.cssSelector("span[data-qa='lufexuloga']");

    // page Actions
    public String loggedInUsername(){
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}
