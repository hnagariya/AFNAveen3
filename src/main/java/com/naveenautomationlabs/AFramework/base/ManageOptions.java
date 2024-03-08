package com.naveenautomationlabs.AFramework.base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.naveenautomationlabs.AFramework.utils.Browsers;



public class ManageOptions {
	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		//options.addArguments("--headless=new");;
		return options;
	}

	private EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		return options;
	}

	private FirefoxOptions getFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		return options;
	}

	public MutableCapabilities getOption(Browsers browser) {

		switch (browser) {
		case CHROME:
			return this.getChromeOptions();
		case FIREFOX:
			return this.getFireFoxOptions();
		case EDGE:
			return this.getEdgeOptions();

		default:
			throw new IllegalArgumentException();
		}
	}

}
