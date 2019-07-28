#Author: Frank Bahar
Feature: Add Location

  Background: 
    Given I logged in into OrangeHrm
    When I click on admin link
    And I click on organization
    And I click on locations
    And I click on Add Location details

  Scenario Outline: Add Location
    And I provide location details "<name>" , "<country>" , "<city>" and "<zip>"
    And I click on save location button
    Then I see location "<name>" is added successfuly

    Examples: 
      | name         | country   | city   | zip   |
      | Australia HQ | Australia | Sydnay | 78756 |
      
	@temp1
  Scenario: Locations labels verification
    Then I seeThen I see following location labels
      | Name            |
      | Country         |
      | Time Zone       |
      | State/Province  |
      | City            |
      | Zip/Postal Code |
      | Phone           |
      | Fax             |
      | Address         |
      | Notes           |
