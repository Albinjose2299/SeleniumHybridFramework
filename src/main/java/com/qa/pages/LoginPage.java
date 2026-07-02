package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.utilities.WaitHelper;
import com.qa.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoginPage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    WebDriver driver;
    WaitHelper waitHelper;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);

    }

    By txtUsername = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");
    By txtError = By.cssSelector("h3[data-test='error']");

    public void enterUsername(String username) {
        logger.info("Entering username");

        waitHelper.waitForElementVisible(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");

        waitHelper.waitForElementVisible(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking Login button");
        waitHelper.waitForElementVisible(btnLogin).click();
        // Login feature branch
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        // Login feature branch
    }
        public String getErrorMessage() {
            return driver.findElement(txtError).getText();
        }
    }
