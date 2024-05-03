package com.naveenautomationlabs.AFramework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.naveenautomationlabs.AFramework.base.TestBase;
import com.naveenautomationlabs.AFramework.utils.Utils;


public class CustomListeners extends TestBase implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test execution started for"+result.getMethod().getMethodName()+"********************************");
	}

	  public void onTestSuccess(ITestResult result) {
		  logger.info("Test"+result.getMethod().getMethodName()+"Passed!!!!!!!!!!!!!!!!!!!!!!!!");
		  
	  }

	  @Override
	  public void onTestFailure(ITestResult result) {
		  Utils.takeScreenShot (result.getMethod().getMethodName());  
		  System.out.println("...............");
	  }

	  @Override
	  public void onTestSkipped(ITestResult result) {
		  
	  }

	
	  @Override
	  public void onStart(ITestContext context) {
		  
	  }

	  @Override
	  public void onFinish(ITestContext context) {
		  
	  }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


}
