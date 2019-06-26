package com.Orangehrm.steps;

import com.Orangehrm.utils.BaseClass;
import com.Orangehrm.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void start(Scenario scenario) {
		System.out.println("Stacenario name " + scenario.getName() + " starting");
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Scenario name " + scenario.getName() + " ending");
		if(scenario.isFailed()) {
			byte[] shot = CommonMethods.takeScreenshot();
			scenario.embed(shot, "image/png");
		}
		BaseClass.quitDriver();
	}
}
