package utils;

import com.aventstack.extentreports.*;
import org.testng.*;

public class ExtentListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}