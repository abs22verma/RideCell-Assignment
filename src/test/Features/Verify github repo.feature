@
Feature: As a public user 
				 I want to validate github repository name and description from both UI and API 
				 So that I can verify both are in sync

Scenario: Validate github repo from UI and API
Given I open public repo "django"
When I click "repositories"
And I save all repository name and description
Then I get the response and compare with UI

