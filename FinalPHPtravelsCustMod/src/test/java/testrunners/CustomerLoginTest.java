package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(features={"featurefiles/customerlogin.feature"},
glue ={"utils","stepdefinitions"},dryRun = false,
plugin ={"com.cucumber.listener.ExtentCucumberFormatter:reports/customerlogin.html"})


public class CustomerLoginTest extends AbstractTestNGCucumberTests 
{

}
