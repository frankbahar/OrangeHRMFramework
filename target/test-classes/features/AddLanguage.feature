#Author: Frank Bahar
Feature: Languages Functionality

  @temp
  Scenario Outline: US156390 - As an admin, I should have the ability to add Languages
    Given I logged in into OrangeHrm
    And I am on Languages Page 
    When I provide language "<language>" and click save 
    Then I see language "<language>" is added successfuly 

    Examples: 
      | language |
      | Turkish1  |