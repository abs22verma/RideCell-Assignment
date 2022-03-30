package com.ridecell.common;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ridecell.utility.Driver;
import com.ridecell.utility.World;

public class RepositoriesPage {
	private static Logger LOGGER = LogManager.getLogger();
	
	public static String getRepoName(String path) {
		return BasePage.findWebElementByXpath(path).getText();
	}
	
	public static String getRepoDescription(String path) {
		return BasePage.findWebElementByXpath(path).getText();
	}
	
	public static void setRepoNameAndDesc() {
		String path = "(//div[@class='flex-auto'])";
		List<WebElement> repo = BasePage.getAllWebElements(path);
		String name="";
		String desc="";
		for(int i=1;i<=repo.size();i++) {
				name = getRepoName(path+"["+i+"]"+"//child::a");
				try {
					desc = getRepoDescription(path+"["+i+"]"+"//child::p");
				}catch(NoSuchElementException e) {
					desc = "";
				}
				LOGGER.info("Repository Name : "+name+" And Description : "+desc);
			World.getInstance().add(name, desc);
		}
	}
	
}
