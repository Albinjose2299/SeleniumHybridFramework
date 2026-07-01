package com.qa.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    public static ExtentReports getExtentReport() {
        if (extent == null) {
            spark = new ExtentSparkReporter("Reports/TestReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
