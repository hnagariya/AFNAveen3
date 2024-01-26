package com.naveenautomationlabs.AFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import com.naveenautomationlabs.AFramework.listeners.WebDriverEvents;
import com.naveenautomationlabs.AFramework.utils.Browsers;
import com.naveenautomationlabs.AFramework.utils.Env;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	public static WebDriverWait wait;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebDriverEvents events;
	private EventFiringWebDriver eDriver;
	private Browsers DEFAULT_BROWSER=Browsers.CHROME;
	private Env DEFAULT_ENV=Env.PROD;

	public TestBase() {
		prop=new Properties();
		try {
			fileInputStream = new FileInputStream("C:\\Users\\Neelam Nagariya\\eclipse-workspace\\AutomationFramework\\src\\main\\java\\com\\naveenautomationlabs\\AutomationFramework\\config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		prop.load(fileInputStream);}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeClass
	public void setUpLogger() {
		logger=Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}


	public void initialisation() {
		//String browser=System.getProperty("Browsers");
		//switch (browser) {
		switch (DEFAULT_BROWSER.getBrowserName()) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			wd =WebDriverManager.edgedriver().create();
			break;
		case "FireFox":
			wd =WebDriverManager.firefoxdriver().create();
			break;
		default:
			System.out.println("Not a valid driver name");
		}
		eDriver = new EventFiringWebDriver(wd);
		events = new WebDriverEvents();
		eDriver.register(events);
		wd = eDriver;
		
		wd.get(DEFAULT_ENV.getUrl() );
		wd.manage().window().maximize();
		wait=new WebDriverWait(wd, 10);
	}

	public void tearDown() {
		wd.quit();
	}

}
