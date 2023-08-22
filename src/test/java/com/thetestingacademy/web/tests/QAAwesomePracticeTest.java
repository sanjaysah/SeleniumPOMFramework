package com.thetestingacademy.web.tests;

import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.Loginpage;
import com.thetestingacademy.pages.QAAwesomePracticePage;
import com.thetestingacademy.utils.PropReader;
import com.thetestingacademy.web.testbase.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class QAAwesomePracticeTest extends TestBase {


    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the form is filled correctly")
    @Test(groups = {"P1","Positive"}, priority = 1, enabled = true)
    public void testAQAPracticeForm() throws Exception {
        DriverManagerTL.getDriver().get(PropReader.readKey("aq_url"));
        new QAAwesomePracticePage().selectContinent("Australia");
        Thread.sleep(5000);
    }
}
