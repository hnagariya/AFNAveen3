package com.naveenautomationlabs.AFramework.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext) {
		// generate timestamp
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

		// name of the report
		String repName = "Report_" + timeStamp + ".html";

		// save the report
		htmlReporter = new ExtentHtmlReporter("./Reports/" + repName);
		// loaded the config file
		htmlReporter.loadXMLConfig("./extent-config.xml");

		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat(timeStamp);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Env", "QA");
		extent.setSystemInfo("TesterName", "Neelam");
		extent.setSystemInfo("Website", "https://demo.naveenautomationlabs.com/");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getMethod().getMethodName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getMethod().getMethodName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getMethod().getMethodName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
	}
 
	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}


}
