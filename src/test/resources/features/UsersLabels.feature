#Author: Frank Bahar
Feature: Users Labels Verification

  @temp1
  Scenario: Users labels verification
    Given I logged in into OrangeHrm
    And I am on Users Page
    When I click on Add Users
    Then I see the following users labels
      | Employee Name    |
      | Username         |
      | ESS Role         |
      | Supervisor Role  |
      | Admin Role       |
      | Status           |
      | Password         |
      | Confirm Password |
