package com.Orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Orangehrm.utils.BaseClass;

public class LoginPageWithoutFactory extends BaseClass{
	
	public WebElement username = driver.findElement(By.id("txtUsername"));
	public WebElement password = driver.findElement(By.id("txtPassword"));
	public WebElement btnLogin = driver.findElement(By.id("btnLogin"));
}
