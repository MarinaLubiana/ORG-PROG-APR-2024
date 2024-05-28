package org.prog.cucumber.steps;

public class CucumberGoogle {
    //TODO: write tests for ${your.site.name} as cucumber scenarios
    Feature: Google search tests
    Given I accept cookies if present
    When I google for "random_user"
    Then I can see at least 3 search results for "random_user"
}
