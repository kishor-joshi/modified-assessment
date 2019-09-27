package com.atmecs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport {

	static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./src/test/resources/extendReport/toolExtendReport.html");
	static ExtentReports extent = new ExtentReports();

	public static void reportLog(String testname, String Failuremsg) {
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest(testname);
		logger.log(Status.INFO, testname);
		logger.log(Status.PASS, testname);
		/*
		 * logger.log(Status.FAIL, Failuremsg); logger.fail("failed script",
		 * MediaEntityBuilder.createScreenCaptureFromPath("./Openmrs/Snapshot").build())
		 * ;
		 */
		extent.flush();

	}
}
