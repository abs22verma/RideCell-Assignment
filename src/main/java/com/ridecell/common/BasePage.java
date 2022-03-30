package com.ridecell.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ridecell.utility.Config;
import com.ridecell.utility.Driver;

public class BasePage {
	
	public static Logger LOGGER = LogManager.getLogger();
	
	public Map<String, String> worldMap = new HashMap<>();
	public static void openURL(String url) {
		String baseURL = Config.getResource().getString("baseURL");
		LOGGER.info("Open url :" + baseURL+url);
		Driver.getDriver().get(baseURL+url);
	}
	
	public static void navigateTo(String field) {
		LOGGER.info("Navigate to :"+field);
		String path = "//a[contains(@class,'UnderlineNav-item') and contains(@href,'"+field+"')]";
		LOGGER.info(path);
		scrollToElement(findWebElementByXpath(path));
		findWebElementByXpath(path).click();
	}
	
	public static WebElement findWebElementByXpath(String field) {
		scrollToElement(Driver.getDriver().findElement(By.xpath(field)));
		return Driver.getDriver().findElement(By.xpath(field));
	}
	
	public static List<WebElement> getAllWebElements(String field){
		LOGGER.info("Finding WebElement using :"+ field);
		return Driver.getDriver().findElements(By.xpath(field));
	}
	
	public static void scrollToElement(WebElement element) {
		LOGGER.info("Scrolling to "+element);
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
