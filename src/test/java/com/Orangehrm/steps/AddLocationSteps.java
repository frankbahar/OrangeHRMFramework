package com.Orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.Orangehrm.pages.AddLocation;
import com.Orangehrm.pages.HomePage;
import com.Orangehrm.utils.BaseClass;
import com.Orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddLocationSteps extends CommonMethods {
	HomePage home = new HomePage();
	AddLocation location;

	@When("I click on admin link")
	public void i_click_on_admin_link() {
		CommonMethods.click(home.adminLink);

	}

	@When("I click on organization")
	public void i_click_on_organization() {
		CommonMethods.click(home.organization);
	}

	@When("I click on locations")
	public void i_click_on_locations() {
		CommonMethods.click(home.locationsLink);

	}

	@When("I provide location details {string} , {string} , {string} and {string}")
	public void i_provide_location_details_and(String name, String country, String city, String zip) {
		// enter location info
		CommonMethods.sendText(location.name, name);
		CommonMethods.click(location.country);
		CommonMethods.selectList(location.countryList, country);
		CommonMethods.sendText(location.city, city);
		CommonMethods.sendText(location.zip, zip);
	}

	@When("I click on Add Location details")
	public void i_click_on_Add_Location_details() {
		CommonMethods.click(home.locationAdd);
		location = new AddLocation();
		
	}

	@When("I click on save location button")
	public void i_click_on_save_location_button() {
		CommonMethods.click(location.saveLocationBtn);
	
	}
	@Then("I see location {string} is added successfuly")
	public void i_see_location_is_added_successfuly(String name) {
		home.driver.navigate().refresh();
		boolean locAdded = false;
		for (WebElement we : home.locationList) {
			String actualname = we.getText();
			if (actualname.equals(name)) {
				locAdded = true;
				break;
			}
		}

		Assert.assertTrue(locAdded);
	}

}
