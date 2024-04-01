package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.ea.framework.utilities.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {//this listener si on test level, ISuiteListener is on suite level
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On Test Start");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On Test Success");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On Test Failure");
        ITestListener.super.onTestFailure(result);
        ExtentReport.scenario.log(Status.FAIL,"Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On Test Skipped");
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("On Test Percentage");
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On Start");
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Test Finish");
        ITestListener.super.onFinish(context);
        ExtentReport.extentReport.flush();
    }
}
