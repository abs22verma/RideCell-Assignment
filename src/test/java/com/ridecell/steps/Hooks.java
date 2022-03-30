package com.ridecell.steps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ridecell.utility.Config;
import com.ridecell.utility.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	
	@Before
	public void openBrowser() {
		Driver.initiateDriver(Config.getResource().getString("browser"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void closeBrowser(Scenario scenario) throws IOException {
		String name = scenario.getName().replace(" ", "_");
		Date date1 = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy-HH-MM-ss");
		name = name+date.format(date1);
		if(scenario.isFailed()) {
			TakesScreenshot scr = (TakesScreenshot) Driver.getDriver();
			File file = scr.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"//target//screenShot//"+name+".jpg"));
		}
		Driver.closeDriver();
	}
}
