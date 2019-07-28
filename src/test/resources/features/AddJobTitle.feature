#Author: Frank Bahar
Feature: Job Title Functionality

  @test
  Scenario Outline: US121390 - As an admin, I should have the ability to add Job Title
    Given I logged in into OrangeHrm
    And I am on Job Titles Page
    And I click add job title
    When I provide job title details "<title>" , "<description>"
    Then I see title "<title>" is added successfuly

    Examples: 
      | title     | description    |
      | Developer | Java Developer |
  
  @smoke
	Scenario Outline: US22437- As a User I should see same job title in both UI and Database
		Given I logged in into OrangeHrm
    And I am on Job Titles Page
    And I get all Job Titles from UI
    And I execute "<Query>" from Database
    Then job titles are matched
     
    Examples:
    |Query|
    |SELECT job_title FROM jobs ORDER BY 1|