package com.ea.framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent = new ExtentReports();

    public static ExtentReports createInstance(){
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("lib/reports");
        extent.attachReporter(htmlReporter);

        //htmlReporter.config().getReporter();
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("lib/reports");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("lib/reports");
        //I can add multiple configs
        //extent.flush();
        return extent;
    }
}
