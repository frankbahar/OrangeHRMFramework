package com.Orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Orangehrm.utils.BaseClass;

public class AddJobTitlePage extends BaseClass{
	@FindBy(xpath="//*[@id='jobTitleName']")
	public WebElement jobTitleEle;
	@FindBy(xpath="//*[@id='jobDescription']")
	public WebElement jobDescriptionEle;
	@FindBy(xpath="//*[@id='modal1']/form/div[2]/a[1]")
	public WebElement saveTitleBtn;
	
	
	public AddJobTitlePage() {
		PageFactory.initElements(driver, this);
	}

}
