package com.Orangehrm.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	public WebDriver driver;
	@Given("I navigated to the Google")
	public void i_navigated_to_the_Google() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("I type search item")
	public void i_type_search_item() {
		driver.findElement(By.cssSelector("input[class='gLFyf gsfi']")).sendKeys("Cucumber");
	}

	@When("click on google search button")
	public void click_on_google_search_button() {
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div[2]/center/input[1]")).click();
	}

	@Then("I see search results are displaed")
	public void i_see_search_results_are_displaed() {
		Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Cucumber')]")).isDisplayed());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	

}
