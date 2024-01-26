package com.naveenautomationlabs.AFramework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.AFramework.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer{
	private int count=1;
	private int maxCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxCount) {
			count++;
			return true;
		}
		return false;
	}
}
