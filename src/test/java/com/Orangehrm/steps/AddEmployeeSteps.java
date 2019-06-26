package com.Orangehrm.steps;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Orangehrm.pages.AddEmployee;
import com.Orangehrm.pages.HomePage;
import com.Orangehrm.pages.LoginPage;
import com.Orangehrm.utils.CommonMethods;
import com.Orangehrm.utils.ConfigsReader;
import com.Orangehrm.utils.Constants;
import com.Orangehrm.utils.ExcelUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	LoginPage login;
	HomePage home;
	AddEmployee addEmployee;
	String expectedEmpID;
	ExcelUtility excel;

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		login = new LoginPage();
		home = login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		CommonMethods.click(home.PIM);
	}

	@When("I click on Add Employee details")
	public void i_click_on_Add_Employee_details() {
		CommonMethods.click(home.addEmployee);
		addEmployee = new AddEmployee();
	}

	@When("I provide employee details {string} , {string} , {string} and {string}")
	public void i_provide_employee_details_and(String fName, String mName, String lName, String loc) {
		CommonMethods.sendText(addEmployee.firstName, fName);
		CommonMethods.sendText(addEmployee.middleName, mName);
		CommonMethods.sendText(addEmployee.lastName, lName);
		CommonMethods.click(addEmployee.location);
		CommonMethods.selectList(addEmployee.locationList, loc);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		expectedEmpID = addEmployee.empID.getAttribute("value");

	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethods.click(addEmployee.saveEmployee);
	}

	@Then("I see employee is added successfuly")
	public void i_see_employee_is_added_successfuly() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		home.driver.navigate().refresh();
		CommonMethods.click(home.employeeList);
		CommonMethods.sendText(home.empSearchBox, expectedEmpID);
		wait.until(ExpectedConditions.elementToBeClickable(home.empSearchBtn));
		WebElement table = driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[1]"));
		CommonMethods.click(home.empSearchBtn);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(table)));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
		Assert.assertNotEquals(rows.size(), 0);
	}

	@Then("I see following label")
	public void i_see_following_label(DataTable addEmpLabel) {
		List<String> labels = addEmpLabel.asList();
		System.out.println("----Printing labels from cucumber dataTable------");
		for (String label : labels) {
			System.out.println(label);
		}
		System.out.println("--Printing labels text from the application");
		List<WebElement> labelList = addEmployee.addEmpLabels;
		List<String> actualLabels = new ArrayList<>();
		for (WebElement label : labelList) {
			String labelText = label.getText();
			if (!labelText.isEmpty()) {
				actualLabels.add(labelText.replace("*", ""));
			}
		}
		Assert.assertTrue(actualLabels.equals(labels));
	}

	@When("I provide employee details from {string}")
	public void i_provide_employee_details(String sheetName) {
		/*
		 * lets say they come from excel fis workbook sheet number # rows number #cols
		 * loop(rows) loop(cols) CommonMethods.sendText(addEmployee.firstName, fName);
		 * CommonMethods.sendText(addEmployee.middleName, mName);
		 * CommonMethods.sendText(addEmployee.lastName, lName);
		 * CommonMethods.click(addEmployee.location);
		 * CommonMethods.selectList(addEmployee.locationList, loc);
		 * 
		 */
		excel = new ExcelUtility();
		excel.openExcel(Constants.EXCEL_FILEPATH, sheetName);
		int rows = excel.getRowNum();
		int cols = excel.getColNum(0);
		for (int i = 1; i < rows; i++) {
			int j = 0;
			CommonMethods.sendText(addEmployee.firstName, excel.getCellData(i, j));
			CommonMethods.sendText(addEmployee.middleName, excel.getCellData(i, j + 1));
			CommonMethods.sendText(addEmployee.lastName, excel.getCellData(i, j + 2));
			CommonMethods.click(addEmployee.location);
			CommonMethods.selectList(addEmployee.locationList, excel.getCellData(i, j + 3));
			expectedEmpID = addEmployee.empID.getAttribute("value");
		}

	}

	@When("I click Create Login Details")
	public void i_click_Create_Login_Details() {
		waitForElementBeClickable(addEmployee.loginDetailcheck, 10);
		CommonMethods.click(addEmployee.loginDetailcheck);
	}

	@When("I provide all mandatory fields")
	public void i_provide_all_mandatory_fields() {
		int rows = excel.getRowNum();
		int cols = excel.getColNum(0);
		for (int i = 1; i < rows; i++) {
			int j = 4;
			System.out.println(excel.getCellData(i, j));
			System.out.println(excel.getCellData(i, j+1));
			System.out.println(excel.getCellData(i, j+2));
			
			
			addEmployee.username.clear();
			addEmployee.password.clear();
			
			CommonMethods.sendText(addEmployee.username, excel.getCellData(i, j));
			CommonMethods.sendText(addEmployee.password, excel.getCellData(i, j + 1));
			CommonMethods.sendText(addEmployee.confirmPassword, excel.getCellData(i, j + 2));
		}
		excel.closeExcel();
	}
}
