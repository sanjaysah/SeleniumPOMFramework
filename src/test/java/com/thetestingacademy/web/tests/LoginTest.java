package com.thetestingacademy.web.tests;

import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.DashboardPage;
import com.thetestingacademy.pages.Loginpage;
import com.thetestingacademy.utils.PropReader;
import com.thetestingacademy.utils.ScreenshotListener;
import com.thetestingacademy.web.testbase.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ScreenshotListener.class)
public class LoginTest extends TestBase {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the INValid Credential have expected outcome")
    @Test(groups = {"P0","Negative"}, priority = 1, enabled = true)
    public void testVWOLogin_Negative() throws Exception {
        DriverManagerTL.getDriver().get(PropReader.readKey("url"));
        String expectedResult = new Loginpage().loginToVWO(false).error_message_text();
        Assertions.assertThat(expectedResult).isNotBlank().isNotNull()
                .contains(PropReader.readKey("expected_error"));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Valid Credential have expected outcome")
    @Test(groups = {"P0","Positive"}, priority = 2)
    public void testVWOLogin_Positive() throws Exception {
        // Navigate, Login and Assert
        DriverManagerTL.getDriver().get(PropReader.readKey("url"));
        DashboardPage dashboard = new Loginpage().loginToVWO(true).afterLogin();
        String expected = dashboard.loggedInUsername();
        Assertions.assertThat(expected).isNotBlank().isNotNull()
                .contains(PropReader.readKey("expected_username"));

    }



}
