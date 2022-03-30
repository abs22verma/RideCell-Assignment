package com.ridecell.steps;

import com.ridecell.common.RepositoriesPage;

import io.cucumber.java.en.When;

public class RepositoriesSteps {

	@When("I save all repository name and description")
	public void iSaveAllRepositoryNameAndDescription() {
		RepositoriesPage.setRepoNameAndDesc();
	}
}
