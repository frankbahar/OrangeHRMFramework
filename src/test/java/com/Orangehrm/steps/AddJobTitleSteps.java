package com.Orangehrm.steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Orangehrm.pages.AddJobTitlePage;
import com.Orangehrm.pages.HomePage;
import com.Orangehrm.utils.CommonMethods;
import com.Orangehrm.utils.DbUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddJobTitleSteps extends CommonMethods {
	HomePage home = new HomePage();
	AddJobTitlePage jobTitle;
	List<Map<String, String>> actualTitleList;
	List<Map<String, String>> expectedTitleList;

	@Given("I am on Job Titles Page")
	public void i_am_on_Job_Titles_Page() {
		home = new HomePage();
		click(home.adminLink);
		click(home.job);
		click(home.jobTitles);
	}

	@Given("I click add job title")
	public void i_click_add_job_title() {
		click(home.addJobTitleEle);
	}

	@When("I provide job title details {string} , {string}")
	public void i_provide_job_title_details(String title, String description) {
		jobTitle = new AddJobTitlePage();

		sendText(jobTitle.jobTitleEle, title);
		sendText(jobTitle.jobDescriptionEle, description);
		click(jobTitle.saveTitleBtn);
	}

	@Then("I see title {string} is added successfuly")
	public void i_see_title_is_added_successfuly(String title) {
		home.driver.navigate().refresh();
		boolean titleAdded = false;
		for (WebElement we : home.locationList) {
			String actualname = we.getText();
			if (actualname.equals(title)) {
				titleAdded = true;
				break;
			}
		}

		Assert.assertTrue(titleAdded);
	}

	@Given("I get all Job Titles from UI")
	public void i_get_all_Job_Titles_from_UI() {
		actualTitleList = new ArrayList<>();
		for (WebElement row : home.titleRows) {
			Map<String, String> uiDataMap = new LinkedHashMap<>();
			uiDataMap.put("JOB_TITLE", row.getText());	
			actualTitleList.add(uiDataMap);
		}
	}

	@Given("I execute {string} from Database")
	public void i_execute_from_Database(String sql) {
		expectedTitleList = DbUtils.getResultSetData(sql);
	}

	@Then("job titles are matched")
	public void job_titles_are_matched() {
		System.out.println("actaul"+ actualTitleList);
		System.out.println("expected " + expectedTitleList);
		Assert.assertTrue(actualTitleList.equals(expectedTitleList));
	}

}
