package com.qa.tests;

import com.qa.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void javascriptDemo() {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("alert('Hello Albin');");

        Alert alert = getDriver().switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();
    }
}