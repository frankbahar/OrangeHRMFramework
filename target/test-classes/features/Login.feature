#Author: Frank Bahar
@sprint3
Feature: Login to Orange HRM website

  Background: 
    Given I see OrangeHrm logo

  @smoke @login
  Scenario: with valid credentials I should be able to login
    When I enter valid username and password
    And I click login button
    Then I successfuly logged in

  @regression
  Scenario: with invalid credentials I should not be able to login
    When I enter invalid username and password
    And I click login button
    Then I see error messages is displayed

  @temp1
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password  | ErrorMessage         |
      | Admin    | Admin123  | Invalid Credentials  |
      | Admin1   | Admin1234 | Invalid Credentials1 |
      | Admin2   | Admin1234 | Invalid Credentials2 |
