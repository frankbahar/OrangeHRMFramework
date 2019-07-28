#Author: Frank Bahar
Feature: Skill Functionality

  @temp1
  Scenario Outline: US 121338 - As an admin, I should have the ability to add Skills
    Given I logged in into OrangeHrm
    And I am on Skills Page
    When I provide  skill details "<skill>" , "<description>" 
    Then I see skill "<skill>" is added successfuly

    Examples: 
      | skill  | description       |
      | clould1 | Cloud Development |
