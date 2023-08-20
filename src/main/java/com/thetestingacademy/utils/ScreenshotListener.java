package com.thetestingacademy.utils;

import com.thetestingacademy.driver.DriverManagerTL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v85.io.IO;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        DriverManagerTL.getDriver();

        File srcFile = ((TakesScreenshot)DriverManagerTL.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*if (DriverManagerTL.getDriver() instanceof TakesScreenshot){
            File screenshot = ((TakesScreenshot) DriverManagerTL.getDriver()).getScreenshotAs(OutputType.FILE);
            String path = "./screenshots/"+result.getName()+".png";

            try{
                Files.copy(screenshot.toPath(), new File(path).toPath(), StandardCopyOption.REPLACE_EXISTING);
                Reporter.log("<a href='"+path+"' target='_blank'>screenshot</a>");
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }*/
    }
}
