package com.Orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Orangehrm.utils.BaseClass;

public class AddEmployee extends BaseClass {
	@FindBy(id = "firstName")
	public WebElement firstName;
	@FindBy(css = "#middleName")
	public WebElement middleName;
	@FindBy(css = "#lastName")
	public WebElement lastName;
	@FindBy(css = "#systemUserSaveBtn")
	public WebElement saveEmployee;
	@FindBy(xpath = "//div[@id='location_inputfileddiv']//input")
	public WebElement location;
	@FindBy(xpath = "//div[@id='location_inputfileddiv']//ul")
	public WebElement locationList;
	@FindBy(css="#employeeId")
	public WebElement empID;
	@FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
	public List<WebElement> addEmpLabels;
	@FindBy(xpath="//label[text()='Create Login Details']")
	public WebElement loginDetailcheck;
	@FindBy(css="#username")
	public WebElement username;
	@FindBy(css="#password")
	public WebElement password;
	@FindBy(css="#confirmPassword")
	public WebElement confirmPassword;
	
	public AddEmployee() {
		PageFactory.initElements(driver, this);
	}
}
