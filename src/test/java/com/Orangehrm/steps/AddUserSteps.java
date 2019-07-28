package com.Orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.Orangehrm.pages.AddUserPage;
import com.Orangehrm.pages.HomePage;
import com.Orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddUserSteps extends CommonMethods {
	HomePage home;
	AddUserPage addUser;

	@Given("I am on Users Page")
	public void i_am_on_Users_Page() {
		home = new HomePage();
		click(home.adminLink);
		click(home.userManagement);
		click(home.usersLink);
	}

	@When("I click on Add Users")
	public void i_click_on_Add_Users() {
		click(home.addUser);
		addUser = new AddUserPage();

	}

	@Then("I see the following users labels")
	public void i_see_the_following_users_labels(io.cucumber.datatable.DataTable dataTable) {
		List<String> labels = dataTable.asList();
		List<WebElement> labelList = addUser.usersLabels;
		List<String> actualLabels = new ArrayList<>();
		for (WebElement label : labelList) {
			String labelText = label.getText();
			if (!labelText.isEmpty()) {
				actualLabels.add(labelText.replace("*", ""));
			}
		}
		System.out.println(actualLabels);
		System.out.println("Expected" + labels);
		Assert.assertTrue(actualLabels.equals(labels));
	}

}
