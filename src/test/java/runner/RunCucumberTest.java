package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\resources\\features\\IncidentManagement.feature", 
				glue ="stepsDefn",
				publish = true,
				monochrome = true,
				tags = "@Get or @Smoke")
public class RunCucumberTest extends AbstractTestNGCucumberTests{

}
