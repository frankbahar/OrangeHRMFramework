#Author: Frank Bahar
Feature: Add Employee

  Background: 
    Given I logged in into OrangeHrm
    When I click on PIM link
    And I click on Add Employee details

  Scenario Outline: Add Employee
    And I provide employee details "<firstname>" , "<middlename>" , "<lastname>" and "<location>"
    And I click on save button
    Then I see employee is added successfuly

    Examples: 
      | firstname | middlename | lastname | location |
      | Hakan     | H          | Sukur    | NYC      |

  @temp
  Scenario: Add Employee and Create Login Details
    And I provide employee details from "EmployeeDetails"
    And I click Create Login Details
    And I provide all mandatory fields
    And I click on save button
    Then I see employee is added successfuly
 
  Scenario: Add Employee Labels Verification
    Then I see following label
      | First Names          |
      | Middle Name          |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |
