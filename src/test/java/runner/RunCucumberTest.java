package runner;

import base.ProjectSpecificMethods;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="C:\\Users\\AneleNqari\\Desktop\\Salesforce\\src\\test\\resources\\features\\SalesforceManagement.feature", 
				glue ="pages",
				publish = true,
				monochrome = true)
public class RunCucumberTest extends ProjectSpecificMethods {
	
}
