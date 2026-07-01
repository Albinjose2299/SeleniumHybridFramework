package com.qa.listeners;

import com.qa.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.qa.utilities.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.reports.ExtentManager;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getExtentReport();

    ExtentTest test;
    private static final Logger logger =
            LogManager.getLogger(TestListener.class);
    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
        logger.info("Starting Test : {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("========== TEST PASSED ==========");
        logger.info("Test Name : " + result.getName());
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("========== TEST FAILED ==========");
        logger.error("Test Name : " + result.getName());
        this.test.fail(result.getThrowable());
        BaseTest test = (BaseTest) result.getInstance();

        ScreenshotUtil.takeScreenshot(
                test.getDriver(),
                result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        logger.info("Extent Report generated successfully.");
    }
}