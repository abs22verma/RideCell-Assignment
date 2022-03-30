package com.ridecell.steps;

import org.junit.Assert;

import com.ridecell.common.BasePage;
import com.ridecell.common.CommonAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CommonSteps {

	@Given("I open public repo {string}")
	public void iOpenPublicRepo(String repo) {
	    BasePage.openURL(repo);
	}

	@When("I click {string}")
	public void iClick(String string) {
	   BasePage.navigateTo(string);
	}
	
	@When("I get the response and compare with UI")
	public void iGetTheResponse() {
		CommonAPI.compareRepo(CommonAPI.getResponse());
	}
}
