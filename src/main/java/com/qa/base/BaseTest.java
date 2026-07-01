package com.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.qa.utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static Logger logger = LogManager.getLogger(BaseTest.class);

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }
    ConfigReader configReader = new ConfigReader();
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {


        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            logger.info("Launching Chrome browser");

            driver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("edge")) {

            logger.info("Launching Edge browser");

            driver.set(new EdgeDriver());
        }
        logger.info("Maximizing browser");
        driver.get().manage().window().maximize();

        logger.info("Opening application: " + configReader.getProperty("url"));
        driver.get().get(configReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver.get() != null) {
            logger.info("Closing browser");
            driver.get().quit();
        }
    }

}