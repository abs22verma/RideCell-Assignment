package com.ridecell.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	static final Logger LOGGER = LogManager.getLogger();
	public static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void initiateDriver(String browser) {
		LOGGER.info("initializing "+browser);
		
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			LOGGER.info(browser+" not supported");
		}
	}
	
	public static void closeDriver() {
		driver.quit();
	}
}
