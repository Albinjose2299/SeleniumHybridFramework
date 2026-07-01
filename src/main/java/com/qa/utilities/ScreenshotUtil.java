package com.qa.utilities;
import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {

        try {

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            File destination = new File("Screenshots/" + testName + ".png");

            FileUtils.copyFile(source, destination);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}