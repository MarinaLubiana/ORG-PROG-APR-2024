package org.prog.cucumber.steps;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import javax.annotation.meta.When;

public class HW10 {
    Feature: Integration of Web, REST, and DB technologies

    Scenario: Allo UA Scenario
    Scenario: Allo UA Scenario
    Given I open the Allo UA website
    When I search for "Samsung"
    Then I should see at least 4 product titles in the search results
}
