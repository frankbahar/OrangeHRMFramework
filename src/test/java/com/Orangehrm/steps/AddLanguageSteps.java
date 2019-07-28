package com.Orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.Orangehrm.pages.AddLanguagePage;
import com.Orangehrm.pages.HomePage;
import com.Orangehrm.utils.CommonMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddLanguageSteps extends CommonMethods {
	HomePage home=new HomePage();
	AddLanguagePage languagePage;

	@Given("I am on Languages Page")
	public void i_am_on_Languages_Page() {
		click(home.adminLink);
		click(home.qualifiations);
		click(home.languages);
		click(home.addLanguageEle);
	}

	@When("I provide language {string} and click save")
	public void i_provide_language_and_click_save(String language) {
		 languagePage = new AddLanguagePage();
		sendText(languagePage.language, language);
		click(languagePage.saveLanguageBtn);
	}

	@Then("I see language {string} is added successfuly")
	public void i_see_language_is_added_successfuly(String language) {
		home.driver.navigate().refresh();
		boolean languageAdded = false;
		for (WebElement we : home.locationList) {
			String actualname = we.getText();
			if (actualname.equals(language)) {
				languageAdded = true;
				break;
			}
		}
		Assert.assertTrue(languageAdded);
	}
}