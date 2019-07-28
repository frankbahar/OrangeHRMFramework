package com.Orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Orangehrm.pages.AddSkillPage;
import com.Orangehrm.pages.HomePage;
import com.Orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddSkillSteps extends CommonMethods {
	HomePage home = new HomePage();
	AddSkillPage skillPage;

	@Given("I am on Skills Page")
	public void i_am_on_Skills_Page() {
		home = new HomePage();
		click(home.adminLink);
		click(home.qualifiations);
		click(home.skills);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(home.addSkillsEle);
	}

	@When("I provide  skill details {string} , {string}")
	public void i_provide_skill_details(String skill, String description) {
		skillPage = new AddSkillPage();
		sendText(skillPage.skillName, skill);
		sendText(skillPage.skillDescriptionEle, description);

		click(skillPage.saveSkillBtn);
	}

	@Then("I see skill {string} is added successfuly")
	public void i_see_title_is_added_successfuly(String skill) {
		home.driver.navigate().refresh();
		boolean skillAdded = false;
		for (WebElement we : home.locationList) {
			String actualname = we.getText();
			if (actualname.equals(skill)) {
				skillAdded = true;
				break;
			}
		}

		Assert.assertTrue(skillAdded);
	}
}
