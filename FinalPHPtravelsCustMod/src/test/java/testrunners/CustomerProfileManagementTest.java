package testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features={"featurefiles/custprofilemanagement.feature"},
glue ={"utils","stepdefinitions"},dryRun = false,
plugin ={"com.cucumber.listener.ExtentCucumberFormatter:reports/myprofile.html"})


public class CustomerProfileManagementTest extends AbstractTestNGCucumberTests {

}
	