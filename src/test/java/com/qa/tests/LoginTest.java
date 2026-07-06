package com.qa.tests;

import com.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.LoginPage;
import com.qa.utilities.ConfigReader;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.TestDataProvider;
import org.testng.annotations.Listeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.retry.RetryAnalyzer;


@Listeners(com.qa.listeners.TestListener.class)
public class LoginTest extends BaseTest {
    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyTitle() {
        System.out.println(
                Thread.currentThread().getName() +
                        " --> " +
                        Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualTitle = getDriver().getTitle();

        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @Test
    public void verifyCurrentUrl() {
        System.out.println(
                Thread.currentThread().getName() +
                        " --> " +
                        Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualUrl = getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/");
    }
    @Test(dataProvider = "loginData",
            dataProviderClass = TestDataProvider.class, retryAnalyzer = RetryAnalyzer.class)

    public void verifyLogin(String username, String password, String expected) {
        System.out.println(
                Thread.currentThread().getName() +
                        " --> " +
                        Thread.currentThread().getId());
        logger.info("Starting verifyLogin test");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(username, password);

        if (expected.equals("Pass")) {

            Assert.assertEquals(
                    getDriver().getCurrentUrl(),
                    "https://www.saucedemo.com/inventory.html");
            logger.info("verifyLogin test completed successfully");

        } else {

            Assert.assertEquals(
                    loginPage.getErrorMessage(),
                    "Epic sadface: Sorry, this user has been locked out.");
        }
    }

}