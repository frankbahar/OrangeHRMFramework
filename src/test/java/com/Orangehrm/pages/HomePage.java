package com.Orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Orangehrm.utils.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboard;
	@FindBy(xpath="//*[@id=\"menu_pim_viewPimModule\"]/a/span[3]")
	public WebElement PIM;
	@FindBy(xpath="//span[text()='Add Employee']")
	public WebElement addEmployee;
	@FindBy(xpath="//a[@id='menu_pim_viewEmployeeList']")
	public WebElement employeeList;
	@FindBy(css="#employee_name_quick_filter_employee_list_value")
	public WebElement empSearchBox;
	@FindBy(xpath="//a[@ng-click='navbar.search()']")
	public WebElement empSearchBtn;
	@FindBy(xpath="//table[@id='employeeListTable']/tbody/tr")
	public WebElement empRows;
	@FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]/a/span[3]")
	public WebElement adminLink;
	@FindBy(xpath="//*[@id=\"menu_admin_Organization\"]/a/span[3]")
	public WebElement organization;
	@FindBy(xpath="//*[@id=\"menu_admin_viewLocations\"]/span[2]")
	public WebElement locationsLink;
	@FindBy(xpath="//*[@id=\"locationDiv\"]/div/a/i")
	public WebElement locationAdd;
	@FindBy(xpath="//table[@class='highlight bordered']/tbody/tr/td[2]")
	public List<WebElement> locationList;
	@FindBy(xpath="//*[@id=\"menu_admin_viewSystemUsers\"]/span[2]")
	public WebElement usersLink;
	@FindBy(xpath="//*[@id=\"systemUserDiv\"]/div/a/i")
	public WebElement addUser;
	@FindBy(xpath="//*[@id=\"menu_admin_UserManagement\"]/a/span[3]")
	public WebElement userManagement;
	@FindBy(xpath="//*[@id=\"menu_admin_Job\"]/a/span[3]")
	public WebElement job;
	@FindBy(xpath="//*[@id=\"menu_admin_viewJobTitleList\"]/span[2]")
	public WebElement jobTitles;
	@FindBy(xpath="//*[@id=\"jobTitlesDiv\"]/div/a/i")
	public WebElement addJobTitleEle;
	@FindBy(xpath="//*[@id='menu_admin_Qualifications']/a/span[3]")
	public WebElement qualifiations;
	@FindBy(xpath="//*[@id='menu_admin_viewSkills']/span[2]")
	public WebElement skills;
	@FindBy(xpath="//*[@id=\"skillDiv\"]/div/a/i")
	public WebElement addSkillsEle;
	@FindBy(xpath="//*[@id=\"menu_admin_viewLanguages\"]/span[2]")
	public WebElement languages;
	@FindBy(xpath="//*[@id=\"languagesDiv\"]/div/a/i")
	public WebElement addLanguageEle;	
	@FindBy(xpath="//*[@id=\"jobTitlesDiv\"]/crud-panel/div/div/list/table/tbody/tr/td[2]")
	public List<WebElement> titleRows;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
