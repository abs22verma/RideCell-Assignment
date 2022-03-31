package com.ridecell.runner;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ridecell.pojo.Users;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, monochrome = true, snippets = SnippetType.CAMELCASE, features = "src/test/Features", 
glue = "com.ridecell.steps", publish = false,plugin = {"json:target/reports/cucumber.json","pretty", 
		"html:target/reports/reports.html"}, tags="@negative"
)
public class RunTest {
	
	@BeforeClass
	public static void setUserDetails() {
		Users user = new Users();
		user.setUsername(System.getProperty("username"));
		user.setPassword(System.getProperty("password"));
	}

}
