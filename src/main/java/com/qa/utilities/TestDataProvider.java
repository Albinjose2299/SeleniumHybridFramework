package com.qa.utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        ExcelReader excel = new ExcelReader();

        return excel.getExcelData("Sheet1");

    }
}