package com.Orangehrm.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Orangehrm.pages.HomePage;
import com.Orangehrm.pages.LoginPage;
import com.Orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {
	LoginPage login;
	HomePage home;

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
		login = new LoginPage();
		boolean isDiplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDiplayed);
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		sendText(login.username, "Admin");
		sendText(login.password, "yMZW@aB17i");
	}

	@When("I click login button")
	public void i_click_login_button() {
		click(login.btnLogin);
	}

	@Then("I successfuly logged in")
	public void i_successfuly_logged_in() {
		home = new HomePage();
		Assert.assertTrue(home.dashboard.isDisplayed());
	}

	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() {
		sendText(login.username, "Admin");
		sendText(login.password, "yMZW@aB17i111");
	}

	@Then("I see error messages is displayed")
	public void i_see_error_messages_is_displayed() {
		Assert.assertTrue(login.loginError.isDisplayed());
		String errorText = login.loginError.getText().trim();
		Assert.assertEquals("Invalid Credentials", errorText);
	}

	@When("I enter invalid username and password I see errorMessage")
	public void i_enter_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
		List<Map<String, String>> maps = wrongCredentials.asMaps();
		for (Map<String, String> map : maps) {
			sendText(login.username, map.get("UserName"));
			sendText(login.password, map.get("Password"));
			click(login.btnLogin);
			// verifying the text of error messag
			String actualError = login.message.getText().trim();			
			String expectedError = map.get("ErrorMessage");
			System.out.println("Actual:" + actualError );
			System.out.println("Expected;" + expectedError);
			Assert.assertEquals(expectedError, actualError);
		}

	}

}
