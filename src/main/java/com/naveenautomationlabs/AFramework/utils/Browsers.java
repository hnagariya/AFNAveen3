package com.naveenautomationlabs.AFramework.utils;

public enum Browsers {
	CHROME("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox"),
	SAFARI("Safari");
	
	String browserName;
    Browsers(String browserName) {
		this.browserName=browserName;
	}
	public String getBrowserName() {
		return browserName;
	}
	
}
