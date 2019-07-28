package com.Orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Orangehrm.utils.BaseClass;

public class AddUserPage extends BaseClass {
	@FindBy(xpath="//div/label")
	public List<WebElement> usersLabels;
	
	public AddUserPage() {
		PageFactory.initElements(driver, this);
	}
	

}
