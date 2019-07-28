package com.Orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Orangehrm.utils.BaseClass;

public class AddLocation extends BaseClass{
	@FindBy(css="#name")
	public WebElement name;
	@FindBy(xpath="//*[@id=\"countryCode_inputfileddiv\"]/div/input")
	public WebElement country;
	@FindBy(xpath = " //div[@id='countryCode_inputfileddiv']/div/ul")
	public WebElement countryList;
	@FindBy(css="#city")
	public WebElement city;
	@FindBy(css="#zipCode")
	public WebElement zip;
	@FindBy(xpath="//a[text()='Save']")
	public WebElement saveLocationBtn;
	@FindBy(xpath="//div/label")
	public List<WebElement> locLabels;
	
	public AddLocation() {
		PageFactory.initElements(driver, this);
	}

}
