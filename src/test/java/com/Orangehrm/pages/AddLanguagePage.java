package com.Orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Orangehrm.utils.BaseClass;

public class AddLanguagePage extends BaseClass{
	@FindBy(xpath="//*[@id='name']")
	public WebElement language;
	@FindBy(xpath="//*[@id='modal1']/form/div[2]/a[1]")
	public WebElement saveLanguageBtn;
	
	public AddLanguagePage() {
		PageFactory.initElements(driver, this);
	}

}
