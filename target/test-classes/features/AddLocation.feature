#Author: Frank Bahar
Feature: Add Location

  Scenario Outline: Add Location
    Given I logged in into OrangeHrm
    When I click on admin link
    And I click on organization
    And I click on locations
    And I click on Add Location details
    And I provide location details "<name>" , "<country>" , "<city>" and "<zip>"
    And I click on save location button
    Then I see location "<name>" is added successfuly

    Examples: 
      | name     | country       | city    | zip   |
      | Australia HQ | Australia | Sydnay | 78756 |
