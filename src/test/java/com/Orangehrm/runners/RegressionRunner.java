 
package com.Orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="com/Orangehrm/steps",
		monochrome=true,
		dryRun=false,
		plugin={"pretty", "html:target/cucumber-default-reports","json:target/cucumber.json"},
		tags= {"@regression"}
		)

public class RegressionRunner { 
	

}
