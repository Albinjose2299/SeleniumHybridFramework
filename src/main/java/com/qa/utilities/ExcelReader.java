package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public String getCellData(String sheetName, int rowNum, int colNum) {

        try {

            FileInputStream fis =
                    new FileInputStream("TestData/LoginData.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            Row row = sheet.getRow(rowNum);

            Cell cell = row.getCell(colNum);

            String value = cell.getStringCellValue();

            workbook.close();

            return value;


        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;
    }
    public Object[][] getExcelData(String sheetName) {

        try {

            FileInputStream fis =
                    new FileInputStream("TestData/LoginData.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int totalRows = sheet.getLastRowNum();

            int totalCols = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[totalRows][totalCols];
            for (int i = 1; i <= totalRows; i++) {

                for (int j = 0; j < totalCols; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }

            }
            workbook.close();

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}