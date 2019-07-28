package com.Orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Orangehrm.utils.BaseClass;

public class AddSkillPage extends BaseClass{
	@FindBy(xpath="//*[@id='name']")
	public WebElement skillName;
	@FindBy(xpath="//*[@id='description']")
	public WebElement skillDescriptionEle;
	@FindBy(xpath="//*[@id='modal1']/form/div[2]/a[1]")
	public WebElement saveSkillBtn;
	
	public AddSkillPage() {
		PageFactory.initElements(driver, this);
	}

}
