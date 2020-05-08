package com.config;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentsReport {
	public ExtentTest test;
	public ExtentReports extent;
	@BeforeSuite
	public void HomePageTest_Report() {
		// start reporters
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\Java\\POMFrameworkPattern\\Report\\Homepage.html");
    
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        // creates a toggle for the given test, adds all log events under it    
        //ExtentTest test = extent.createTest("HomePageTest_Report", "Amazon home page report");

        // log(Status, details)
        //test.log(Status.INFO, "Amazon home page)");

        // info(details)
        //test.info("This step shows usage of info(details)");
        
        // calling flush writes everything to the log file
        //extent.flush();
	}

}
