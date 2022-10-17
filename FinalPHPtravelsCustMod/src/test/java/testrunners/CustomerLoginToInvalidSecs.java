package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/custlogintoinvalidsection.feature",

glue ={"utils","stepdefinitions"},dryRun = false,
plugin ={"com.cucumber.listener.ExtentCucumberFormatter:reports/customerlogininvalidsection.html"})


public class CustomerLoginToInvalidSecs extends AbstractTestNGCucumberTests
{
	

}
