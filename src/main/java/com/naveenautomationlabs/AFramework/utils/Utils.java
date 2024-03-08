package com.naveenautomationlabs.AFramework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomationlabs.AFramework.base.TestBase;

public class Utils extends TestBase{
	public static void takeScreenShot(String testName) {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date());
		System.out.println(timeStamp);

		// take screenshot
		File screenshotFile = ((TakesScreenshot) wd.get()).getScreenshotAs(OutputType.FILE);

		// save screenshot
		try {
			FileUtils.copyFile(screenshotFile,
					new File("./FailedTestScreenShots/" + "_" + testName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static int returnDigitsFromString(String str) {
		return Integer.parseInt(str.replaceAll("[^0-9]", ""));
	}

}
